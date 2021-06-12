package net.learn.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 *  案例二：客户端发送文件给服务器，服务端将文件保存在本地
 * @author neo
 * @date 2021/6/12 22:48
 */
public class TCPTest02 {

    public static void main(String[] args){

    }
    /*
        Client:
     */
    @Test
    public void client(){

        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 8888);
            is = new FileInputStream("D:\\downloadFile.m4a");
            os = socket.getOutputStream();

            byte[] buffer = new byte[20];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                // 通过socket将读取到的数据写到服务端
                os.write(buffer);
            }
            // 因为传统的IO是阻塞式的 没有明确的指示文件什么时候读取结束
            // 解决方法如下：
            // 关闭数据的输出
            socket.shutdownOutput();
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
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        Server:
     */
    @Test
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            // 读取到socket发送过来的数据通过文件写入流写到磁盘保存
            is = socket.getInputStream();
            os = new FileOutputStream("D:\\multiFile.m4a");
            byte[] buffer = new byte[20];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                os.write(buffer);
            }

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
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
