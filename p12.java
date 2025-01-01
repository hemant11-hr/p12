import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileClassDemo {
    public static void main(String[] args) {
        // Creating a File object
        File file = new File("example.txt");

        // Check if file exists
        if (file.exists()) {
            System.out.println("File already exists!");
        } else {
            try {
                // Create a new file
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File could not be created.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }

        // Writing to the file using FileWriter
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, this is a test file!");
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Reading from the file using FileReader and BufferedReader
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            System.out.println("Reading from file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Checking file properties
        if (file.exists()) {
            System.out.println("\nFile Properties:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Writeable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File Size in Bytes: " + file.length());
        }

        // Delete the file
        if (file.delete()) {
            System.out.println("\nFile deleted successfully.");
        } else {
            System.out.println("\nFailed to delete the file.");
        }
    }
}
