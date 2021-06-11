package net.study.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerTest {

    public static void main(String[] args) throws IOException {
        // 建立DatagramPacket连接 [并设置开启的端口号]
        DatagramSocket socket = new DatagramSocket(9090);

        /*
            DatagramPacket(byte[] buf, int offset, int length)
          构造 DatagramPacket，用来接收长度为 length 的包，在缓冲区中指定了偏移量。
         */
        // 接收数据包
        byte[] buffer = new byte[11];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        /*
         void receive(DatagramPacket p)
          从此socket接收数据报包。

         void send(DatagramPacket p)
          从此socket发送数据报包。

         */
        socket.receive(packet); // 阻塞式接收

        System.out.println(packet.getAddress() + ":" + new String(packet.getData(), 0, packet.getLength()));

        socket.close();

    }

}
