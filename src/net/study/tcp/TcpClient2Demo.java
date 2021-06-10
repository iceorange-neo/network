package net.study.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
    客户端
 */
public class TcpClient2Demo {


    public static void main(String[] args) {
        OutputStream os = null;
        Socket socket = null;
        try {
            // 1、需要直到服务器端的地址，端口号
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            // 2、创建一个socket连接
            socket = new Socket(serverIp, port);

            // 3、发送消息IO流
            os = socket.getOutputStream();
            os.write("Hello World".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
