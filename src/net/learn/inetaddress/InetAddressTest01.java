package net.learn.inetaddress;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  一、网络编程中需要解决两个问题？
 *      1、如何准确定位网络上的一台或者多台主机、定位主机上特定的应用
 *      2、找到主机之后按照什么规则进行可靠的数据传输、信息交换
 *
 *  二、网络编程中的两个要素？
 *      1、IP和Port
 *      2、网络协议：TCP/TP参考模型
 *
 *  三、通信要素一：IP和端口号
 *      1、IP：唯一表示Internet上的一台主机
 *      2、在Java中使用InetAddress类代表IP
 *      3、IP分类：Ipv4&Ipv6    公网地址&私网地址
 *      4、域名：DNS  ----> 为了访问ip进行的简化
 *
 *      5、端口号+IP地址=Socket（套接字、插槽）
 *
 *  四、通信要素二：网络协议
 *      1、进行网络通信的规则
 *      2、网络协议分层思想
 *      3、TCP/IP协议簇     (TCP：传输控制协议)&(UDP：用户数据报协议)
 *
 *
 *   提高：
 *      InetAddress类没有对应的构造器：使用了静态工厂设计模式
 *      常通过InetAddress类的静态方法：public static InetAddress getByName(String str)
 *      来获取一个域名、ip、主机名对应的IP表示。
 *
 *      InetAddress实例常用的两个方法：
 *          getHostName()   获取该ip对应的域名
 *          getAddress()    获取该ip对应的ip地址
 */
public class InetAddressTest01 {

    public static void main(String[] args){

        try {
            /* 一：IP */
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println(localhost);
            InetAddress google = InetAddress.getByName("www.google.com");
            /* 本机地址：127.0.0.1 (localhost) */
            System.out.println(google);

            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local);


            /* 二：Port */
            /*
            *   一个端口对一个着在该计算机上运行的进程
            *   端口范围：0~65535
            *   端口分类：公认端口、注册端口、用户端口
            * */
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
