package com.yu.network.socket01.dao;

import com.yu.network.socket01.entity.User;

import java.io.*;
import java.util.ArrayList;

/**
 * @author pengyu
 */
public class UserDaoImpl implements UserDao{

    private static File file = new File("user.txt");
    private static ArrayList<User> users = new ArrayList<>();

    static {
        if (!file.exists()) {
             write(new User("admin", "toor"));
        }
        read();
    }

    private static void write(User user) {
        users.add(user);
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(out);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (oos != null) {
                oos.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                users = (ArrayList<User>)obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (ois != null) {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean query(User user) {

        for (User user1:users) {
            if (user1.getuName().equals(user.getuName())
                    && user1.getPwd().equals(user.getPwd())){
                return true;
            }
        }
        return false;
    }
}
