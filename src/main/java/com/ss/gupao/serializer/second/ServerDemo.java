package com.ss.gupao.serializer.second;

import com.ss.gupao.serializer.first.User;

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

    static JavaSerializer<User> javaSerializer = new JavaSerializer();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        byte[] o = (byte[])ois.readObject();
        System.out.println(o.length);
        for (byte b : o) {
            System.out.print(b + " ");
        }
        System.out.println();

        User user = javaSerializer.deSerialize(o);
        System.out.println(user);
    }
}
