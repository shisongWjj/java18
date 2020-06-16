package com.ss.gupao.Serializer.first;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerDemo
 *
 * @author shisong
 * @date 2020/6/16
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        User o = (User)ois.readObject();
        System.out.println(o);
    }
}
