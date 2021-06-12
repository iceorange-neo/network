package net.study.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/myWebsite/index.html?username=smith&password=333");

        System.out.println(url.getProtocol());  // 获取协议
        System.out.println(url.getHost());      // 获得主机ip
        System.out.println(url.getPort());      // 获得端口号
        System.out.println(url.getPath());      // 资源路径  myWebsite/index.html
        System.out.println(url.getFile());      // 资源名称
        System.out.println(url.getQuery());     // 查询参数===请求参数
    }
}
