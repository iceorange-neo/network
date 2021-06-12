package net.study.talk;

import java.io.*;
import java.net.*;

public class TalkSend implements Runnable {
    private DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;
    private String toIp;
    private int toPort;
    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run(){
        while(true){
            try {
                // 从控制台读取数据
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                // 创建数据包
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));
                // 发送
                socket.send(packet);
                if("bye".equals(data)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

}
