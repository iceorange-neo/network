package net.study;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest01 {
    public static void main(String[] args) {
        try {
            // 获得本机IP地址
            InetAddress inetIp = InetAddress.getByName("127.0.0.1");
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println("localhost");
            System.out.println(localHost);
            System.out.println(inetIp);

            // 获得网站IP地址
            InetAddress byName = InetAddress.getByName("www.baidu.com");
            System.out.println(byName);

            // 常用方法
            System.out.println(localhost.getAddress());
            System.out.println(localhost.getCanonicalHostName());
            System.out.println(localhost.getHostAddress());
            System.out.println(localhost.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
