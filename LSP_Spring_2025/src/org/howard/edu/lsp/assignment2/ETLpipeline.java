package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ETLpipeline {
    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        List<String[]> data = extract(inputFilePath);
        if (data != null) {
            List<String[]> transformedData = transform(data);
            load(outputFilePath, transformedData);
        } else {
            System.out.println("No valid data extracted.");
        }
    }

    public static List<String[]> extract(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  
            while ((line = br.readLine()) != null) {
                String[] record = line.trim().split(",", -1);  
                if (record.length == 4) {  
                    data.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return data;
    }

    public static List<String[]> transform(List<String[]> data) {
        List<String[]> transformedData = new ArrayList<>();
        transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});

        for (String[] record : data) {
            try {
                String productID = record[0].trim();
                String name = record[1].trim().toUpperCase(); 
                double price = Double.parseDouble(record[2].trim());
                String category = record[3].trim();

                if (category.equalsIgnoreCase("Electronics")) {
                    price *= 0.9; 
                    price = Math.round(price * 100.0) / 100.0; 
                    if (price > 500) category = "Premium Electronics"; 
                }

                transformedData.add(new String[]{productID, name, String.format("%.2f", price), category, getPriceRange(price)});

            } catch (NumberFormatException e) {
                System.out.println("Skipping row due to invalid price: " + Arrays.toString(record));
            }
        }
        return transformedData;
    }

    public static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        if (price <= 100) return "Medium";
        if (price <= 500) return "High";
        return "Premium";
    }

    public static void load(String filePath, List<String[]> data) {
        try {
            Files.createDirectories(Paths.get(filePath).getParent()); 
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (String[] record : data) {
                    bw.write(String.join(",", record));
                    bw.newLine();
                }
                System.out.println("File successfully written to " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file " + filePath);
        }
    }
}
