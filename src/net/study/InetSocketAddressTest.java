package net.study;

import java.net.InetSocketAddress;

public class InetSocketAddressTest {
    public static void main(String[] args) {

        InetSocketAddress localhost = new InetSocketAddress("localhost", 8080);
        // InetSocketAddress： 完整连接   主机名+ip+端口号
        System.out.println(localhost);
        System.out.println(localhost.getAddress()); // ip地址  127.0.0.1
        System.out.println(localhost.getHostName());    // 主机名 localhost
        System.out.println(localhost.getPort());    // 端口号
    }
}
