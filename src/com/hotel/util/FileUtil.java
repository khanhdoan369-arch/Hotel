package com.hotel.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void writeToFile(String fileName, List<String> data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }

    public static List<String> readFromFile(String fileName) {

        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return data;
    }

}
