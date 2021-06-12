package net.study.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLFileDownloading {

    public static void main(String[] args) throws IOException {

//        URL descUrl = new URL("https://m8.music.126.net/20210611145237/1e3b6b81879cc82f212e675a4ec6d4d5/ymusic/040f/0409/035c/3efcd05a943cc8a00a6e460e44084584.mp3");
        URL descUrl = new URL("https://m8.music.126.net/20210611145237/1e3b6b81879cc82f212e675a4ec6d4d5/ymusic/040f/0409/035c/3efcd05a943cc8a00a6e460e44084584.mp3");
        // 开启连接通道
        HttpURLConnection httpURLConnection = (HttpURLConnection)descUrl.openConnection();
        // 通过流读取指定文件
        InputStream is = httpURLConnection.getInputStream();

        // 通过流将文件写入硬盘
        FileOutputStream fos = new FileOutputStream("D:\\downloads.mp3");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        fos.flush();

        is.close();
        fos.close();


    }

}
