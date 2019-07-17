import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Exam {

    private static Scanner input;

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        Directory directory = new Directory();
        Listable[] list = {dictionary, directory};

        input = FileManager.openTextFile("/home/juanca/Downloads/words.txt");
        FileManager.readTextFile(input, list[0]);
        FileManager.closeTextFile(input);

        input = FileManager.openTextFile("/home/juanca/Downloads/list-of-cities-in-usa-1.txt");
        FileManager.readTextFile(input, list[1]);
        FileManager.closeTextFile(input);

        input = FileManager.openTextFile("/home/juanca/Downloads/dictionaryTest.txt");
        while (input.hasNext()) {
            String word = input.nextLine();
            System.out.printf("The word %s %s spelled correctly\n",
                word, dictionary.isItemThere(word) ? "is" : "is NOT");
        }
        FileManager.closeTextFile(input);

        input = FileManager.openTextFile("/home/juanca/Downloads/directoryTest.txt");
        while (input.hasNext()) {
            String city = input.nextLine();
            System.out.printf("The city %s %s spelled correctly\n",
                city, directory.isItemThere(city)?"is":"is NOT");
        }
        FileManager.closeTextFile(input);

    }
}


interface Listable {

    void addItem(String string);
    boolean isItemThere(String string);

}


class Dictionary implements Listable {

    private List<String> words = new ArrayList<String>();

    public void addItem(String string) {
        char ch = string.charAt(0);
        switch (ch) {
            case 'i': words.add(string); break;
            case 'u': words.add(string); break;
            default: System.out.printf("%-25s does NOT start with 'i' or 'u'!\n", string);
        }
    }

    public boolean isItemThere(String string) {
        for (String word : words)
            if (string.equals(word))
                return true;
        return false;
    }

}


class Directory implements Listable {

    private List<String> cities = new ArrayList<String>();

    public void addItem(String string) {
        if (string.length()==0 || string.length()==49)
            System.out.printf("%s is NOT a city name!\n", string);
        else
            cities.add(string);
    }

    public boolean isItemThere(String string) {
        for (String city : cities)
            if (string.equals(city))
                return true;
        return false;
    }
}


class FileManager {

    public static Scanner openTextFile(String string) {
        Scanner input = null;
        try {
            input = new Scanner(Paths.get(string));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        return input;
    }

    public static void readTextFile(Scanner input, Listable list) {
        try {
            while (input.hasNext())
                list.addItem(input.nextLine());
        }
        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        }
        catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
    }

    public static void closeTextFile(Scanner input) {
        if (input != null)
            input.close();
    }

}
