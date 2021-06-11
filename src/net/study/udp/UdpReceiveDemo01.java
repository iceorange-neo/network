package net.study.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 接收
public class UdpReceiveDemo01 {
    public static void main(String[] args) throws IOException {

        // 建立Socket
        DatagramSocket socket = new DatagramSocket(7777);

        while (true) {
            // 创建数据包
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            // 接收
            socket.receive(packet);
            String receiveData = new String(packet.getData(), 0, packet.getLength());
            System.out.println(receiveData);

            if("bye".equals(receiveData)){
                break;
            }

        }
        socket.close();

    }
}
