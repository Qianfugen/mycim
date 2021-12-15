package fun.qianfg.encoder;

import fun.qianfg.dto.MessageDto;
import fun.qianfg.util.Hessian2Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Function: 消息编码器
 *
 * @author qianfg
 * @date 2021/12/13 下午11:05
 * @Email: 287541326@qq.com
 */
public class MessageEncoder extends MessageToByteEncoder<MessageDto> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageDto msg, ByteBuf out) {
        byte[] data = Hessian2Utils.serialize(msg);
        out.writeBytes(data);
    }

}
