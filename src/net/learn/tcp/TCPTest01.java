package net.learn.tcp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * TCP网络编程：
 *    案例一：Client发送消息给Server，Server将接收到的数据显示在控制台
 * @author neo
 * @date 2021/6/12 22:15
 */
public class TCPTest01 {

    public static void main(String[] args){

    }
    /*
        Client:
     */
    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;
        try {
            /* 注意：建立Socket连接中的ip+port是需要通信的对方 */
            socket = new Socket(InetAddress.getByName("localhost"), 8888);

            os = socket.getOutputStream();
            os.write("message".getBytes());
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

    /*
        Server:
     */
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            /* 建立服务器的Socket  需要传递自己的端口号--对应了进程 */
            serverSocket = new ServerSocket(8888);

            /* serverSocket.accept()接收来自该8888端口的Client的Socket */
            socket = serverSocket.accept();
            is = socket.getInputStream();

            // 可能会产生乱码
//            byte[] buffer = new byte[20];
//            int len = 0;
//            while((len = is.read(buffer)) != -1){
//                String receiveMessage = new String(buffer, 0, len);
//                System.out.println(receiveMessage);
//            }

            /* 将所有的字节写到bateArray中 */
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            System.out.println("from " + socket.getInetAddress() + " message");
            /* 整体写完之后在进行转换为字符串 */
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (baos != null) {
                try {
                    baos.close();
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
