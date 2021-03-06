package org.ballerinalang.stdlib.tcp.testutils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {
        System.out.println("Received by test server : " + buf.toString(CharsetUtil.UTF_8));
        if (!buf.toString(CharsetUtil.UTF_8).equals("Do not reply")) {
            ctx.channel().writeAndFlush(buf);
        }
    }
}
