import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteTemperature {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in);
             DataOutputStream out = new DataOutputStream(new FileOutputStream("temperature.dat"))) {

            System.out.print("Enter number of cities: ");
            int count = input.nextInt();

            for (int i = 1; i <= count; i++) {
                System.out.println("\nCity " + i);

                System.out.print("Enter city name: ");
                String cityName = input.next();

                System.out.print("Enter temperature: ");
                double temp = input.nextDouble();

                out.writeUTF(cityName);
                out.writeDouble(temp);
            }

            System.out.println("\nTemperature records saved successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
