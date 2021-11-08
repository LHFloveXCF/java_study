package com.xu.netty.day01.net02;

import io.netty.buffer.Unpooled;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * java_study
 */
public class ClientFrame extends Frame {

    TextArea ta = new TextArea();
    TextField tf = new TextField();
    Client client;

    // 内部类单例模式
    public static ClientFrame getInstance() {
        return InnerClientFrame.FRAME;
    }

    private static class InnerClientFrame{
        private static final ClientFrame FRAME = new ClientFrame();
    }

    private ClientFrame() {
        setSize(600, 300);
        setTitle("客户端");
        add(ta, BorderLayout.CENTER);
        add(tf, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client.send("byte");
                System.exit(0);
            }
        });

        tf.addActionListener(e -> {
            client.send(tf.getText());
            // updateTextArea(tf.getText());
            tf.setText("");
        });
        setVisible(true);
        client = new Client();
    }

    public void connect() {
        client.connect();
    }

    public void updateTextArea(String msg) {
        ta.setText(ta.getText() + System.getProperty("line.separator") + msg);
    }

    public static void main(String[] args) {
        ClientFrame.getInstance().connect();
    }
}
