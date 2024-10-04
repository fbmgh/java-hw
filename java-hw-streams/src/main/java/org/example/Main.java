package org.example;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Асинхронная задача начинается...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 300;
        });

        cf.thenAccept(result -> {
            System.out.println("Результат: " + result);
        });

        System.out.println("Задача запущена асинхронно...");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Задача завершена.");
    }
}
