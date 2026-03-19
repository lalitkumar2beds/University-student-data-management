package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static <T> void saveData(String filePath, List<T> dataList) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {

            oos.writeObject(dataList);

        } catch (IOException e) {
            System.out.println("Error saving data: " + filePath);
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {

            return (List<T>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error loading data: " + filePath);
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

}