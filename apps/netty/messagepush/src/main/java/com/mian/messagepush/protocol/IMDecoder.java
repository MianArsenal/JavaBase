package com.mian.messagepush.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IMDecoder extends ByteToMessageDecoder {

    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        try {
            //read
            final int length = byteBuf.readableBytes();
            final byte[] array = new byte[length];
            String content = new String(array, byteBuf.readerIndex(), length);

            //if null
            if (!(null == content || "".equals(content.trim()))) {
                if (!IMP.isIMP(content)) {
                    channelHandlerContext.channel().pipeline().remove(this);
                }
            }

            // else
            byteBuf.getBytes(byteBuf.readerIndex(), array, 0, length);
            out.add(new MessagePack().read(array, IMMessage.class));
            byteBuf.clear();
        } catch (Exception e) {
            e.printStackTrace();
            channelHandlerContext.channel().pipeline().remove(this);
        }
    }

    public IMMessage decode(String msg) {
        if (null == msg || "".equals(msg.trim())) {
            return null;
        }
        try {
            Matcher m = pattern.matcher(msg);
            String header = "";
            String content = "";
            if(m.matches()) {
                header  = m.group(1);
                content = m.group(3);
            }

            String [] headers = header.split("\\]\\[");
            long time = 0;
            try {
                time = Long.parseLong(headers[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String nickName = headers[2];
            nickName = nickName.length() < 10 ? nickName : nickName.substring(0, 9);

            if(msg.startsWith("[" + IMP.LOGIN.getName() + "]")) {
             return new IMMessage(headers[0], time, headers[3], nickName);
            } else if (msg.startsWith("[" + IMP.CHAT.getName() + "]")) {
                return new IMMessage(headers[0], time, nickName, content);
            } else if(msg.startsWith("[" + IMP.FLOWER.getName() + "]")) {
                return new IMMessage(headers[0], time, headers[3], nickName);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
