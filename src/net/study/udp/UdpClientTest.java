package net.study.udp;

import java.io.IOException;
import java.net.*;

public class UdpClientTest {

    public static void main(String[] args) throws IOException {
        // 建立UDP Socket连接
        DatagramSocket socket = new DatagramSocket();

        // 接收方的主机
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        String message = "Hello World";
        // 建立数据包，将消息作为一帧塞入数据包中
        /*
        DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
          构造数据报包，用来将长度为 length 偏移量为 offset 的包发送到指定主机上的指定端口号
         */
        byte[] messageToBytes = message.getBytes();
        DatagramPacket packet = new DatagramPacket(messageToBytes, 0, messageToBytes.length, localhost,port);

        // 发送
        socket.send(packet);

        // 关闭socket连接
        socket.close();

    }

}
