import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadTemperature {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(new FileInputStream("temperature.dat"))) {
            System.out.println("The file is opened.\n");

            int cityNum = 1;
            while (in.available() > 0) {
                String cityName = in.readUTF();
                double temp = in.readDouble();

                System.out.println("City " + cityNum);
                System.out.println("City name: " + cityName);
                System.out.println("Temperature: " + temp + "\n");
                cityNum++;
            }

            System.out.println("All city temperature records were read.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}