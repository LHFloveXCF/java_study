package com.xu.mca.local.scoket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * java_study
 */
public class Client {
    public static void main(String[] args) throws IOException {
        new ClientThread().start();
    }

    static void clientOne() throws IOException {
        Socket socket = new Socket(InetAddress.getByName(null), Server.port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        for (int i=0; i<10; i++) {
            out.println("hello " + i);
            String s = in.readLine();
            System.out.println(s);
        }
        out.println(Server.end);
        socket.close();
    }
}

class ClientThread extends Thread{
    BufferedReader in;
    PrintWriter pw;
    Socket socket;

    ClientThread() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(),Server.port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }


    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            pw.println("hello " + i);
            String s = null;
            try {
                s = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }
        pw.println(Server.end);

        /*try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
