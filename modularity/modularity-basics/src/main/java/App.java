import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        compute();
    }

    private static List<Double> readNumbersFromFile(String filename){
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<Double> numbers = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            numbers.add(number);
        }
        return numbers;
        }

    private static normalize(List<Double> numbers){
        List<Double> normalized = new ArrayList<>();
        double sum = 0;
        for (double f : numbers) {
            sum += f;
        }
        double mean = sum / numbers.size();
        double sumSquare = 0;
        for (double f : numbers) {
            double diff = f - mean;
            sumSquare += diff * diff;
        }
        double std = Math.sqrt(sumSquare / numbers.size());
        for (double f : numbers) {
            normalized.add((f - mean) / std);
        }
        System.out.println(normalized);
        return normalized;
    }

    private static void writeToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            for (double n : normalized) {
                fw.write(Double.toString(n));
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing output file");
        }
        System.out.println("Wrote output file.");
        scanner.close();
    }

    public static List<Double> compute() throws FileNotFoundException {
        List<Double> numbers = readNumbersFromFile("data");
        List<Double> normalized = normalize(numbers);
        writeToFile("output");      
        return normalized;
    }
}
