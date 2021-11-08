package com.xu.netty.day01.net;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * java_study
 * 客户端窗口
 */
public class ClientFrame extends Frame {
    public TextArea ta = new TextArea();
    public TextField tf = new TextField();
    Client client = null;

    public static ClientFrame getFrame() {
        return InnerClientFrame.FRAME;
    }

    public void updateMsg(String toString) {
        this.ta.setText(ta.getText() + System.getProperty("line.separator") + toString);
        // System.out.println(toString);
    }

    private static class InnerClientFrame {
        private static ClientFrame FRAME = new ClientFrame();
    }

    private ClientFrame(){
        setSize(600, 400);
        setTitle("聊天室");
        setVisible(true);

        add(ta, BorderLayout.CENTER);
        add(tf, BorderLayout.SOUTH);

        tf.addActionListener(e -> {
            // ta.append(tf.getText() + "\n");
            // ta.append(ta.getText());
            // tf.setText("");
            client.sendMsg(tf.getText());
            tf.setText("");
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        client = new Client();
    }

    public void connect() {
        client.connect();
    }

    public static void main(String[] args) {
        ClientFrame frame = ClientFrame.getFrame();
        frame.connect();
    }
}
