import java.io.Serializable;
import java.io.File;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exam {

    private static Scanner input;
    private static ObjectOutputStream output;
    private static ObjectInputStream input2;
    private static ObjectInputStream input3;

    public static void main(String[] args) {

        input = FileManager.openTextFile("sst0n156e_dy.ascii");
        output = FileManager.openToSerialize("sst.ser");
        FileManager.serialize(input,output,"sst");
        FileManager.closeTextFile(input);
        FileManager.closeBinaryFile(output);

        input = FileManager.openTextFile("bp0n156e_dy.ascii");
        output = FileManager.openToSerialize("bp.ser");
        FileManager.serialize(input,output,"bp");
        FileManager.closeTextFile(input);
        FileManager.closeBinaryFile(output);

        input2 = FileManager.openToDeserialize("sst.ser");
        input3 = FileManager.openToDeserialize("bp.ser");

        FileManager.deserialize(input2, input3);
        FileManager.closeBinaryFile(input2);
        FileManager.closeBinaryFile(input3);
    }
}

interface Measurable {
    String getMeasure();
}

class SstDatum implements Serializable, Measurable {

    private int year;
    private int month;
    private int day;
    private double sst;

    public SstDatum(int year, int month, int day, double sst) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.sst = sst;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getMeasure() {
        return String.format("%.2f", sst);
    }
}

class BpDatum implements Serializable, Measurable {

    private int year;
    private int month;
    private int day;
    private double bp;

    public BpDatum(int year, int month, int day, double bp) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.bp = bp;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getMeasure() {
        return String.format("%.1f", bp);
    }
}

class FileManager {

    public static Scanner openTextFile(String file) {
        Scanner input = null;
        try {
            input = new Scanner(Paths.get(file));
        }
        catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        return input;
    }

    public static ObjectOutputStream openToSerialize(String file) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)));
        }
        catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
        return output;
    }

    public static ObjectInputStream openToDeserialize(String file) {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(
                Files.newInputStream(Paths.get(file)));
        }
        catch (IOException ioException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        return input;
    }

    public static void serialize(Scanner input, ObjectOutputStream output, String string) {
        try {
            while (input.hasNext()) 
                if (input.next().equals("S"))
                    break;
            while (input.hasNext()) {
                int date = input.nextInt();
                int year = date/10000;
                int month = (date - 10000*year)/100;
                int day = date%100;
                input.next();
                double datum = input.nextDouble();
                input.next();
                input.next();
                if (string.equals("sst")) {
                    SstDatum sst = new SstDatum(year, month, day, datum);
                    output.writeObject(sst);
                }
                if (string.equals("bp")) {
                    BpDatum bp = new BpDatum(year, month, day, datum);
                    output.writeObject(bp);
                }
            }
        }
        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        }
        catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
        catch (IOException ioException) {
            System.err.println("Error writing to file. Terminating.");
        }
    }

    public static void deserialize(ObjectInputStream sstInput, ObjectInputStream bpInput) {
        try {
            System.out.printf("%4s%6s%4s%28s%28s\n",
                "Year", "Month", "Day", "Sea Surface Temperature (C)",
                "Sea Level Pressure (hPa)");
            while (true) {
                Measurable[] measurable = new Measurable[2];
                SstDatum sst = (SstDatum) sstInput.readObject();
                BpDatum bp = (BpDatum) bpInput.readObject();
                measurable[0] = sst;
                measurable[1] = bp;
                System.out.printf("%4d%6d%4d", sst.getYear(), sst.getMonth(),
                    sst.getDay());
                for (Measurable m: measurable) {
                    System.out.printf("%28s", m.getMeasure());
                }
                System.out.println();
            }
        }
        catch (EOFException endOfFileException) {
            System.out.printf("\nNo more records\n");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid object type. Terminating.");
        }
        catch (IOException ioException) {
            System.err.println("Error reading from file. Terminating.");
        }
    }

    public static void closeTextFile(Scanner input) {
        if (input != null)
            input.close();
    }

    public static void closeBinaryFile(ObjectOutputStream output) {
        try {
            if (output != null)
                output.close();
        }
        catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
        }
    }

    public static void closeBinaryFile(ObjectInputStream input) {
        try {
            if (input != null)
                input.close();
        }
        catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
        }
    }
}
