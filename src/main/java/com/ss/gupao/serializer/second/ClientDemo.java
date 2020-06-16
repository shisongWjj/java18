package com.ss.gupao.serializer.second;

import com.ss.gupao.serializer.first.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * ClientDemo
 *
 * @author shisong
 * @date 2020/6/16
 */
public class ClientDemo {

    static JavaSerializer<User> javaSerializer = new JavaSerializer();

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);

        User u = new User();
        u.setName("shisong");
        u.setAge(18);
        byte[] serialize = javaSerializer.serialize(u);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(serialize);
    }
}
