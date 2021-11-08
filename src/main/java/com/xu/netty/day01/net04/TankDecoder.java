package com.xu.netty.day01.net04;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * java_study
 */
public class TankDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (msg.readableBytes() < 8) {
            return;
        }
        Tank tank = new Tank(msg.readInt(), msg.readInt());
        out.add(tank);
    }
}
