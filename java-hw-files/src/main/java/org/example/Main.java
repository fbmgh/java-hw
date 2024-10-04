package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper om  = new ObjectMapper();

        try {
            Person wp = new Person("sunmeat", 35);
            om.writeValue(new File("person.json"), wp);
            System.out.println("Объект успешно записан в JSON файл");

            Person rp = om.readValue(new File("person.json"), Person.class);
            System.out.println(String.format("Объект: %s, %d", rp.getName(), rp.getAge()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}