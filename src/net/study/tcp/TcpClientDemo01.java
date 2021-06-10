package net.study.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class TcpClientDemo01 {
    public static void main(String[] args) {

        // 1、要知道服务器端的地址、端口
        try {
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int serverPort = 1234;
            // 2、创建一个socket连接
            Socket socket = new Socket(serverIp, serverPort);
            // 3、客户端向服务端发送message
            String message = "Hello World"; // 发送--->写
            OutputStream out = socket.getOutputStream();
            // 只能写一个int数字   或者byte[]
            // 故传输字符串需要转化为字节数组
            out.write(message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
