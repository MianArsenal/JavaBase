package com.mian.messagepush.handler;

import com.mian.messagepush.processor.MsgProcessor;
import com.mian.messagepush.protocol.IMMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TerminalServerHandler extends SimpleChannelInboundHandler<IMMessage> {

    private MsgProcessor processor = new MsgProcessor();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IMMessage imMessage) throws Exception {
        processor.sendMsg(channelHandlerContext.channel(), imMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("Socket client: 与客户端断开连接" + cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
