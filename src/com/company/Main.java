package com.company;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        User user = new User(box);
        Thread boxThread = new Thread(null, box::work, "Коробка");
        boxThread.start();
        Thread userThread = new Thread(null, user::press, "Пользователь");
        userThread.start();

        while (true) {
            if (!userThread.isAlive()) {
                boxThread.interrupt();
                break;
            }
        }
    }
}
