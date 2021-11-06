package com.xu.mca.local.scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java_study
 */
public class Server {
    public static final int port = 8080;
    public static final String end = "end";
    public static void main(String[] args) throws IOException {
        serverTwo();
    }

    static void serverTwo() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        new ServerOne(socket);
        serverSocket.close();
    }

    static void serverOne() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            while (true) {
                String s = in.readLine();
                if (end.equals(s)) {
                    break;
                }
                System.out.println("Echoing: " + s);
                pw.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}

class ServerOne extends Thread {

    private Socket s;
    private BufferedReader in;
    private PrintWriter pw;

    ServerOne(Socket socket) throws IOException {
        this.s = socket;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        start();
        s.close();
    }

    @Override
    public void run() {
        while (true) {
            String s = null;
            try {
                s = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Server.end.equals(s)) {
                break;
            }
            System.out.println("Echoing: " + s);
            pw.println(s);
        }
    }
}
