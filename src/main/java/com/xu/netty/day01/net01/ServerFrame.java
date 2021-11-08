package com.xu.netty.day01.net01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * java_study
 */
public class ServerFrame extends Frame {

    public static ServerFrame getInstance() {
        return InnerServerFrame.FRAME;
    }

    private static class InnerServerFrame{
        private static final ServerFrame FRAME = new ServerFrame();
    }

    public TextArea ta = new TextArea();
    Server server;

    private ServerFrame () {
        setSize(600, 400);
        setTitle("server");
        setVisible(true);
        add(ta);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 初始化server
        server = new Server();
    }

    public void start() {
        server.start();
    }

    public void updateServerMsg(String msg) {
        ta.setText(ta.getText() + System.getProperty("line.separator") + msg);
    }

    public static void main(String[] args) {
        ServerFrame frame = ServerFrame.getInstance();
        frame.start();
    }
}
