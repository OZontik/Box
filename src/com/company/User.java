package com.company;

import java.util.Random;

public class User {
    private final int MIN = 300;
    private final int MAX = 1300;
    private final int WAIT = 200;

    private final Box box;
    private int switchAttempts = 3;

    public User(Box box) {
        this.box = box;
    }

    public void press() {
        Random random = new Random();
        try {
            while (switchAttempts-- > 0) {
                Thread.sleep(random.nextInt(MAX - MIN) + MIN);
                box.switchOn();
                System.out.println("Пользователь включил тумблер");
                while (box.isSwitcher()) {
                    Thread.sleep(WAIT);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
