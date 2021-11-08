package com.xu.netty.day01.net02;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * java_study
 */
public class ServerFrame extends Frame {
    TextArea ta = new TextArea();
    Server server;

    public void updateTa(String msg) {
        ta.setText(ta.getText() + System.getProperty("line.separator") + msg);
    }

    private static class InnerServerFrame{
        private static final ServerFrame FRAME = new ServerFrame();
    }
    private ServerFrame () {
        setTitle("server");
        setSize(600, 300);
        add(ta);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        server = new Server();
    }

    public static ServerFrame getInstance() {
        return InnerServerFrame.FRAME;
    }

    public void start() {
        server.start();
    }

    public static void main(String[] args) {
        ServerFrame.getInstance().start();
    }

}
