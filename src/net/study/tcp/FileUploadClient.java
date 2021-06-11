package net.study.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


// 文件上传
// 客户端上传
public class FileUploadClient {
    public static void main(String[] args) throws IOException {

        // 获得服务器端的主机ip
        InetAddress serverIp = InetAddress.getByName("localhost");
        int port = 9000;
        // 1、与指定主机的端口建立socket连接
        Socket socket = new Socket(serverIp, port);
        // 获取socket输出流
        OutputStream os = socket.getOutputStream();
        // 2、将需要上传的文件读取出来
        FileInputStream fis = new FileInputStream("D:\\workspace\\Network\\src\\net\\study\\tcp\\FileUploadClient.java");
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = fis.read(buffer)) != -1){
            // 通过socket连接写出去
            os.write(buffer);
        }

        // 【@】通知服务器我已经上传好了
        socket.shutdownOutput();    // 传输完毕
        os.flush();


        // 确定文件上传成功
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while((length = is.read(bytes)) != -1){
            baos.write(bytes, 0, length);
        }
        baos.flush();
        System.out.println(baos.toString());


        baos.close();
        is.close();
        os.close();
        fis.close();
        socket.close();
    }
}
