package fun.qianfg.decoder;

import fun.qianfg.dto.MessageDto;
import fun.qianfg.util.Hessian2Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Function: 消息解码器
 *
 * @author qianfg
 * @date 2021/12/15 下午11:04
 * @Email: 287541326@qq.com
 */
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) {
        //复制⼀份ByteBuf数据，轻复制，⾮完全拷⻉
        //避免出现异常： did not read anything but decoded a message
        //Netty检测没有读取任何字节就会抛出该异常
        ByteBuf in2 = in.retainedDuplicate();
        byte[] dst;
        if (in2.hasArray()) {
            //堆缓冲区模式
            dst = in2.array();
        } else {
            dst = new byte[in2.readableBytes()];
            in2.getBytes(in2.readerIndex(), dst);
        }
        //跳过所有的字节，表示已经读取过了
        in.skipBytes(in.readableBytes());
        MessageDto msg = Hessian2Utils.deserialize(dst, MessageDto.class);
        list.add(msg);
    }

}
