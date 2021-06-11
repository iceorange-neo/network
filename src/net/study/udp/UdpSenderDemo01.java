package net.study.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
    发送方
 */
public class UdpSenderDemo01 {

    public static void main(String[] args) throws IOException {

        // 建立Socket
        DatagramSocket socket = new DatagramSocket(8888);
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        // 创建数据包
        DatagramPacket packet = new DatagramPacket(message.getBytes(), 0, message.getBytes().length, InetAddress.getByName("localhost"), 7777);

        // 发送
        socket.send(packet);
    }

}
