package net.study.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 文件上传
// 服务器端收到
public class FileUploadServer {

    public static void main(String[] args) throws IOException {

        // 1、创建服务端Socket连接，在9000端口上
        ServerSocket serverSocket = new ServerSocket(9000);

        // 2、监听客户端socket连接
        Socket socket = serverSocket.accept();

        // 3、客户端Socket获取读流
        InputStream is = socket.getInputStream();

        // 建立写文件的流
        FileOutputStream fos = new FileOutputStream("D:\\FileUploadClient.java");
        // 4、读出来的文件写到服务器端的一个地方
        byte [] buffer = new byte[1024];
        int len = 0;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer, 0 ,len);
        }

        // 接收完毕，通知客户端
        OutputStream os = socket.getOutputStream();
        os.write("文件上传成功".getBytes());
        os.flush();

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
