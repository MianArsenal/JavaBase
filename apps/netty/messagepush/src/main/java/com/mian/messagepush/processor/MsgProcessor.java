package com.mian.messagepush.processor;

import com.alibaba.fastjson.JSONObject;
import com.mian.messagepush.protocol.IMDecoder;
import com.mian.messagepush.protocol.IMEncoder;
import com.mian.messagepush.protocol.IMMessage;
import com.mian.messagepush.protocol.IMP;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MsgProcessor {

    private static ChannelGroup onlineUsers = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static final AttributeKey<String> NICK_NAME = AttributeKey.valueOf("nickName");
    public static final AttributeKey<String> IP_ADDR = AttributeKey.valueOf("ipAddr");
    public static final AttributeKey<JSONObject> ATTRS = AttributeKey.valueOf("attrs");
    public static final AttributeKey<String> FROM = AttributeKey.valueOf("from");

    private IMDecoder decoder = new IMDecoder();
    private IMEncoder encoder = new IMEncoder();

    //user nickname
    public String getNickName(Channel client) {
        return client.attr(NICK_NAME).get();
    }

    //user ip addr
    public String getAddress(Channel client) {
        return client.remoteAddress().toString().replaceFirst("/", "");
    }

    //user extend attr
    public JSONObject getAttrs(Channel client) {
        try {
            return client.attr(ATTRS).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void setAttrs(Channel client, String key, Object value) {
        try {
            JSONObject json = client.attr(ATTRS).get();
            json.put(key, value);
            client.attr(ATTRS).set(json);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(key, value);
            client.attr(ATTRS).set(jsonObject);
        }
    }


    public void sendMsg(Channel channel, IMMessage imMessage) {
        sendMsg(channel, encoder.encode(imMessage));
    }

    public void sendMsg(Channel client, String text) {
        IMMessage request = decoder.decode(text);
        if (null == request) {
            return;
        }
        String addr = getAddress(client);

        if (request.getCmd().equals(IMP.LOGIN.getName())) {
            client.attr(NICK_NAME).getAndSet(request.getSender());
            client.attr(IP_ADDR).getAndSet(addr);
            client.attr(FROM).getAndSet(request.getTerminal());

            onlineUsers.add(client);
            for (Channel channel: onlineUsers) {
                boolean isSelf = (channel == client);
                if (!isSelf) {
                    request = new IMMessage(IMP.SYSTEM.getName(), System.currentTimeMillis(), onlineUsers.size(), getNickName(client) + "加入");
                } else {
                    request = new IMMessage(IMP.SYSTEM.getName(), System.currentTimeMillis(), onlineUsers.size(), "已与服务器建立连接！");
                }

                if ("Console".equals(channel.attr(FROM).get())) {
                    channel.writeAndFlush(request);
                    continue;
                }
                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        } else if (request.getCmd().equals(IMP.CHAT.getName())) {
            for (Channel channel : onlineUsers) {
                boolean isSelf = (channel == client);
                if (isSelf) {
                    request.setSender("You");
                } else {
                    request.setSender(getNickName(client));
                }
                request.setTime(System.currentTimeMillis());
                if ("Console".equals(channel.attr(FROM).get()) & !isSelf) {
                    channel.writeAndFlush(request);
                    continue;
                }
                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        } else if (request.getCmd().equals(IMP.FLOWER.getName())) {
            JSONObject attrs = getAttrs(client);
            long currentTime = System.currentTimeMillis();
            if(null != attrs) {
                long lastTime = attrs.getLongValue("lastFlowerTime");
                //60秒内不允许重复送花
                int seconds = 10;
                long sub = currentTime - lastTime;
                if (sub < 1000 * seconds) {
                    request.setSender("You");
                    request.setCmd(IMP.SYSTEM.getName());
                    request.setContent("您送的鲜花太频繁" + (seconds - Math.round(sub/1000)) + "秒后再试");

                    String content = encoder.encode(request);
                    client.writeAndFlush(new TextWebSocketFrame(content));
                    return;
                }
            }

            //正常送花
            for (Channel channel :
                    onlineUsers) {
                if (channel == client) {
                    request.setSender("You");
                    request.setContent("you send a flower to all members");
                    setAttrs(client, "lastFlowerTime", currentTime);
                } else {
                    request.setSender(getNickName(client));
                    request.setContent(getNickName(client) + "send a flower to you");

                }
                request.setTime(System.currentTimeMillis());

                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        }


    }

}
