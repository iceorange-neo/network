package net.study.talk;

public class UserToTwo {
    public static void main(String[] args) {
        new Thread(new TalkSend(8546, "localhost", 8888)).start();
        new Thread(new TalkReceive(9999, "Allen")).start();
    }
}
