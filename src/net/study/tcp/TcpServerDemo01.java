package net.study.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpServerDemo01 {
    public static void main(String[] args) {

        try {
            // 1、服务端需要有一个ip地址和端口号
            ServerSocket serverSocket = new ServerSocket(1234);
            // 2、监听客户端的连接
            Socket socket = serverSocket.accept();
            // 3、读取客户端的消息
            InputStream in = socket.getInputStream();
            // 管道流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = in.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

            baos.close();
            in.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
