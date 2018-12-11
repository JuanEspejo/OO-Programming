import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.File;


public class aa 
{
    private static Formatter outOldMas;
    private static Formatter outTrans;
    private static Formatter outTransMult;
    private static ObjectOutputStream outOldMasSer;
    private static ObjectOutputStream outTransSer;
    private static Scanner inputFiles;
	private static ObjectInputStream input;

    public static void main(String[] args) 
    {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do 
		{
            System.out.printf(
            "%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s", 
            "Menu", "0.- salir", "1.- ejercicio 14.18",
            "2.- ejercicio 14.20", "3.- ejercicio 14.21",
            "4.- ejercicio 14.22", "5.- ejercicio 15.4",
            "6.- ejercicio 15.5", "7.- ejercicio 15.6",
            "8.- ejercicio 15.7", 
            "Seleccione una de las opciones: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 0: break;
                case 1:
                    p1418(entrada);
                    break;
                case 2:
                    p1420(entrada);
                    break;
                case 3:
                    p1421(entrada);
                    break;
                case 4:
                    p1422(entrada);
                    break;
                case 5:
                    p154();
                    break;
                case 6:
                    p155();
                    break;
                case 7:
                    p156();
                    break;
                case 8:
                    p157();
                    break;
            }
            
        } while(opcion != 0);
    } 
   
    public static void p1418(Scanner entrada)
    {
		
        System.out.println("Elija un programa (a, b, c): ");
        char choice = entrada.next().charAt(0);
        entrada.nextLine();
        System.out.println("Introduzca un texto:");
        String line = entrada.nextLine();
        switch(choice)
        {
            case 'a':
                countLetters(line);
                break;
            case 'b':
                countLettersWords(line);
                break;
            case 'c':
                showWords(line);
                break;
        }
    }
    
    public static void p1420(Scanner entrada)
    { 
        System.out.println("Introduzca el monto:");
        float total = entrada.nextFloat();
        String check = String.format("%,.2f", total);
        if(check.length() > 9)
            System.out.println("Monto invalido.");
        else
        {
            for(int i = 0; i < 9 - check.length(); i++)
                System.out.printf("*");
            System.out.printf("%s%n---------%n", check);
        }
    }
   
    public static void p1421(Scanner entrada)
    { 
        System.out.println("Introduzca el monto (menor a 1000):");
        float total = entrada.nextFloat();
        if(total < 1000)
        {
            //StringBuilder text = new StringBuilder();
            int hundreds = (int)total/100;
            total = total - hundreds * 100;
            int tens = (int)total;
            total = (total%1)*100;
            if(hundreds>0)
                switch(hundreds)
                {
                    case 1:
                        System.out.printf("ONE hundred");
                        break;
                    case 2:
                        System.out.printf("TWO hundred");
                        break;
                    case 3:
                        System.out.printf("THREE hundred");
                        break;
                    case 4:
                        System.out.printf("FOUR hundred");
                        break;
                    case 5:
                        System.out.printf("FIVE hundred");
                        break;
                    case 6:
                        System.out.printf("SIX hundred");
                        break;
                    case 7:
                        System.out.printf("SEVEN hundred");
                        break;
                    case 8:
                        System.out.printf("EIGHT hundred");
                        break;
                    case 9:
                        System.out.printf("NINE hundred");
                        break;
                }
            if(tens > 0)
            {
                System.out.printf(" ");
                if(tens < 20)
                    switch(tens)
                    {
                        case 10:
                            System.out.printf("TEN");
                            break;
                        case 11:
                            System.out.printf("ELEVEN");
                            break;
                        case 12:
                            System.out.printf("TWELVE");
                            break;
                        case 13:
                            System.out.printf("THIRTEEN");
                            break;
                        case 14:
                            System.out.printf("FOURTEEN");
                            break;
                        case 15:
                            System.out.printf("FIFTEEN");
                            break;
                        case 16:
                            System.out.printf("SIXTEEN");
                            break;
                        case 17:
                            System.out.printf("SEVENTEEN");
                            break;
                        case 18:
                            System.out.printf("EIGHTEEN");
                            break;
                        case 19:
                            System.out.printf("NINETEEN");
                            break;    
                    }
                else
                {
                    int b = tens%10;
                    tens = tens / 10;
                    switch(tens)
                    {
                        case 2:
                            System.out.printf("TWENTY");
                            break;
                        case 3:
                            System.out.printf("THIRTY");
                            break;
                        case 4:
                            System.out.printf("FORTY");
                            break;
                        case 5:
                            System.out.printf("FIFTY");
                            break;
                        case 6:
                            System.out.printf("SIXTY");
                            break;
                        case 7:
                            System.out.printf("SEVENTY");
                            break;
                        case 8:
                            System.out.printf("EIGHTY");
                            break;
                        case 9:
                            System.out.printf("NINETY");
                            break;
                    }
                    System.out.printf(" ");
                    switch(b)
                    {
                        case 1:
                            System.out.printf("ONE");
                            break;
                        case 2:
                            System.out.printf("TWO");
                            break;
                        case 3:
                            System.out.printf("THREE");
                            break;
                        case 4:
                            System.out.printf("FOUR");
                            break;
                        case 5:
                            System.out.printf("FIVE");
                            break;
                        case 6:
                            System.out.printf("SIX");
                            break;
                        case 7:
                            System.out.printf("SEVEN");
                            break;
                        case 8:
                            System.out.printf("EIGHT");
                            break;
                        case 9:
                            System.out.printf("NINE");
                            break;
                    }
                }
                
            }
            System.out.printf(" and %d/100", (int)total);
        }
        else
            System.out.println("Monto invalido");
    }
   
    public static void p1422(Scanner entrada)
    { 
        System.out.println("Escriba a para cifrar, b para decifrar: ");
        char choice = entrada.next().charAt(0);
        entrada.nextLine();
        System.out.println("Introduzca un texto:");
        StringBuilder line = new StringBuilder(entrada.nextLine());
        switch(choice)
        {
            case 'a':
                //char c;
                for(int i = line.length() - 1; i >= 0; i--)
                {
                    //c = line.toString().toUpperCase().charAt(i);
                    //System.out.printf("%c, %s", c, cifrar(c));
                    line.insert(i+1, cifrar(line.toString().toUpperCase().charAt(i)));
                    line.deleteCharAt(i);
                    //line.insert(i, cifrar(c));
                }
                System.out.printf("En morse:%n%s%n", line);
                break;
            case 'b':
                System.out.printf("Decifrado:%n%s%n", decifrar(line.toString()));
                break;
        }
    }
   
    public static void p154()
    { 
        writeData();
        FileMatch files = new FileMatch();
        files.match();
        
    }
   
    public static void p155()
    { 
        writeData();
        FileMatchMult files = new FileMatchMult();
        files.match();
    }
   
    public static void p156()
    { 
        writeData();
        FileMatchSer files = new FileMatchSer();
        files.match();
		openFile();
      	readRecords();
		closeFile();
    }
   
    public static void p157()
    { 
		Scanner value = new Scanner(System.in);
    	System.out.print("Ingrese número telefónico: ");
        p157(value.nextLine());
    }
    private static void countLetters(String line)
    {
        char[] charArray = new char[line.length()];
        line.toUpperCase().getChars(0, line.length(), charArray, 0);
        int[] count = new int[26];
        
        for(char c : charArray)
        {
            if(c > 64 && c < 91)
                count[c - 65]++;
        }
        System.out.println("Cuenta de letras:");
        for(int i = 0; i < 26; i++)
        {
            if(count[i] > 0)
                System.out.printf("%c: %d%n", (char)i + 97, count[i]);
        }
    }
    private static void countLettersWords(String line)
    {
        String[] tokens = line.split(" ");
        int[] count = new int[25];
        int maxLength = 0;
        for(String word : tokens)
        {
            count[word.length()]++;
            if(word.length() > maxLength)
                maxLength = word.length();
        }
        System.out.println("Letras en palabra: numero de veces");
        for(int i = 1; i <= maxLength; i++)
        {
            System.out.printf("%d   :   %d%n", i, count[i]);
        }
    }
    private static void showWords(String text)
    {
		final HashMap<String, Integer> words = new HashMap<>(); 
		text = text.toLowerCase().replaceAll("[-+.^:,?]", "");
        System.out.println(text);
        for (String string : text.split(" ")) 
		{
        	if (words.containsKey(string)) 
			{
				int get = words.get(string);
                get++;
                words.put(string, get);
            } 
			else {
                    words.put(string, 1);
                }
        }
        //To be, or not to be: that is the question: Whether 'tis nobler in the mind to suffer
        System.out.println("Occurrences\tWord");
        words.keySet().forEach((w) -> {
        	System.out.printf("%d\t\t%s%n", words.get(w), w);
        });

/*
        String[] tokens = line.toLowerCase().split(" ");
        int[] total = new int[tokens.length];
        int[] count = new int[tokens.length];
        for(int i = 0; i < tokens.length; i++)
        {
            if(total[i] == 0)
            {
                total[i] = 1;
                for(int x = 0; x < tokens.length; x++)
                {
                    
                    if(tokens[x].equals(tokens[i]))
                    {
                        total[x] = 1;
                        count[i]++;
                    }
                }
            }   
        }
        System.out.println("Conteo de palabras:");
        for(int i = 0; i < tokens.length; i++)
            if(count[i] > 0)
                System.out.printf("%s : %d veces%n", tokens[i], count[i]);
*/
    }


    private static String cifrar(char c)
    {
        switch(c)
        {
            case 'A':
                return ".- ";
            case 'B':
                return "-... ";
            case 'C':
                return "-.-. ";
            case 'D':
                return "-.. ";
            case 'E':
                return ". ";
            case 'F':
                return "..-. ";
            case 'G':
                return "--. ";
            case 'H':
                return ".... ";
            case 'I':
                return ".. ";
            case 'J':
                return ".--- ";
            case 'K':
                return "-.- ";
            case 'L':
                return ".-.. ";
            case 'M':
                return "-- ";
            case 'N':
                return "-. ";
            case 'O':
                return "--- ";
            case 'P':
                return ".--. ";
            case 'Q':
                return "--.- ";
            case 'R':
                return ".-. ";
            case 'S':
                return "... ";
            case 'T':
                return "- ";
            case 'U':
                return "..- ";
            case 'V':
                return "...- ";
            case 'W':
                return ".-- ";
            case 'X':
                return "-..- ";
            case 'Y':
                return "-.-- ";
            case 'Z':
                return "--.. ";
            case '1':
                return ".---- ";
            case '2':
                return "..--- ";
            case '3':
                return "...-- ";
            case '4':
                return "....- ";
            case '5':
                return "..... ";
            case '6':
                return "-.... ";
            case '7':
                return "--... ";
            case '8':
                return "---.. ";
            case '9':
                return "----. ";
            case '0':
                return "----- ";
            case ' ':
                return "  ";
            
        }
        return "";
    }
    private static String decifrar(String line)
    {
        String[] words = line.split("   ");
        StringBuilder result = new StringBuilder();
        for(String word : words)
            result.append(decifrarWord(word) + " ");
        return result.toString();
    }
    private static String decifrarWord(String cifrado)
    {
        StringBuilder word = new StringBuilder();
        String[] letters = cifrado.split(" ");
        for(String letter : letters)
        {
            word.append(decifrarLetter(letter));
        }
        return word.toString();
    }
    private static char decifrarLetter(String c)
    {
        switch(c)
        {
            case ".-":
                return 'A';
            case "-...":
                return 'B';
            case "-.-.":
                return 'C';
            case "-..":
                return 'D';
            case ".":
                return 'E';
            case "..-.":
                return 'F';
            case "--.":
                return 'G';
            case "....":
                return 'H';
            case "..":
                return 'I';
            case ".---":
                return 'J';
            case "-.-":
                return 'K';
            case ".-..":
                return 'L';
            case "--":
                return 'M';
            case "-.":
                return 'N';
            case "---":
                return 'O';
            case ".--.":
                return 'P';
            case "--.-":
                return 'Q';
            case ".-.":
                return 'R';
            case "...":
                return 'S';
            case "-":
                return 'T';
            case "..-":
                return 'U';
            case "...-":
                return 'V';
            case ".--":
                return 'W';
            case "-..-":
                return 'X';
            case "-.--":
                return 'Y';
            case "--..":
                return 'Z';
            case ".----":
                return '1';
            case "..---":
                return '2';
            case "...--":
                return '3';
            case "....-":
                return '4';
            case ".....":
                return '5';
            case "-....":
                return '6';
            case "--... ":
                return '7';
            case "---.. ":
                return '8';
            case "----. ":
                return '9';
            case "-----":
                return '0';

        }
        
        return 0;
    }
    
    private static void writeData()
    {
        
        try
        {
            outOldMas = new Formatter("oldmast.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outTrans = new Formatter("trans.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outTransMult = new Formatter("transMult.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        try
        {
            outOldMas.format("%d %s %s %.2f%n%d %s %s %.2f%n%d %s %s %.2f%n%d %s %s %.2f%n", 100, "Alan", "Jones", 348.17, 300, "Mary", "Smith", 27.19, 500, "Sam", "Sharp", 0.00, 700, "Suzy", "Green", -14.22);
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating.");
            System.exit(1);
        }
        catch (NoSuchElementException elementException)
        {
                System.err.println("Invalid input.");
        }
        
        try
        {
            outTrans.format("%d %.2f%n%d %.2f%n%d %.2f%n%d %.2f%n", 100, 27.14, 300, 62.11, 400, 100.56, 900, 82.17);
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating.");
            System.exit(1);
        }
        catch (NoSuchElementException elementException)
        {
                System.err.println("Invalid input.");
        }
        
        try
        {
            outTransMult.format("%d %.2f%n%d %.2f%n%d %.2f%n%d %.2f%n%d %.2f%n%d %.2f%n%d %.2f%n", 100, 27.14, 300, 62.11, 300, 83.89, 400, 100.56, 700, 80.78, 700, 1.53, 900, 82.17);
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating.");
            System.exit(1);
        }
        catch (NoSuchElementException elementException)
        {
                System.err.println("Invalid input.");
        }
        
        if(outOldMas != null)
            outOldMas.close();
        if(outTrans != null)
            outTrans.close();
        if(outTransMult != null)
            outTransMult.close();
        
        try
        {
            outOldMasSer = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        try
        {
            outTransSer = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            inputFiles = new Scanner(Paths.get("oldmast.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        
        do
        {
            Account account = new Account(inputFiles.nextInt(), inputFiles.next(), inputFiles.next(), inputFiles.nextDouble());
            try
            {
                outOldMasSer.writeObject(account);
            }
            catch(IOException ioException)
            {
                System.err.println("Error writing to file. Terminating.");
                System.exit(1);
            }
        }while(inputFiles.hasNext());
        
        try
        {
            inputFiles = new Scanner(Paths.get("transMult.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        
        do
        {
            TransactionRecord transaction = new TransactionRecord(inputFiles.nextInt(), inputFiles.nextDouble());
            
            //System.out.printf("%n%d %f%n", transaction.getAccount(), transaction.getAmount());
            try
            {
                outTransSer.writeObject(transaction);
            }
            catch(IOException ioException)
            {
                System.err.println("Error writing to serial file. Terminating.");
                System.exit(1);
            }
        }while(inputFiles.hasNext());
        
        try
        {
            if(outTransSer != null)
            outTransSer.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
        try
        {
            if(outOldMasSer != null)
            outOldMasSer.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
    }




	public static void openFile()
   	{
    	try // open file
      	{
         	input = new ObjectInputStream(          
            Files.newInputStream(Paths.get("oldmast.ser")));
      	} 
      	catch (IOException ioException)
      	{
      	   System.err.println("Error opening file.");
      	   System.exit(1);
      	} 
   	}

   	// read record from file
   	public static void readRecords()
   	{
   	   System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
   	      "First Name", "Last Name", "Balance");

   	   try 
   	   {
			while (true) // loop until there is an EOFException
   	      	{
				Account record = (Account) input.readObject();
	
   	         	// display record contents
   	         	System.out.printf("%-10d%-12s%-12s%10.2f%n",  
   	       		record.getAccount(), record.getFirstName(), 
             	record.getLastName(), record.getBalance());
         	} 
      	}
      	catch (EOFException endOfFileException)
      	{
      	   System.out.printf("%nNo more records%n");
      	} 
      	catch (ClassNotFoundException classNotFoundException)
      	{
      	   System.err.println("Invalid object type. Terminating.");
      	} 
      	catch (IOException ioException)
      	{
      	   System.err.println("Error reading from file. Terminating.");
      	} 
   	} // end method readRecords

   	// close file and terminate application
   	public static void closeFile()
   	{
  		try
   		{
         	if (input != null)
            	input.close();
      	} 
      	catch (IOException ioException)
      	{
       		System.err.println("Error closing file. Terminating.");
         	System.exit(1);
      	} 
	}


	public static void p157(String number) 
	{
        P157 p157 = new P157(number);
    }
  

}




class Account implements Serializable
{
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
    
    public Account()
    {
        this(0, "", "", 0.0);
    }
    
    public Account(int account, String firstName, String lastName, double balance)
    {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    
    public void setAccount(int account)
    {
        this.account = account;
    }
    
    public int getAccount()
    {
        return account;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getFirstName() 
    { 
        return firstName; 
    } 
   
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    } 

    public String getLastName() 
    {
        return lastName; 
    } 
   
    public void setBalance(double balance)
    {
        this.balance = balance;
    } 

    public double getBalance() 
    { 
        return balance; 
    }
    
    public void combine(TransactionRecord transaction)
    {
        this.setBalance(this.getBalance() + transaction.getAmount());
    }
}

class TransactionRecord implements Serializable
{
    private int account;
    private double transaction;
    
    public TransactionRecord()
    {
        this(0, 0.0);
    }
    
    public TransactionRecord(int account, double transaction)
    {
        this.account = account;
        this.transaction = transaction;
    }
    
    public void setAccount(int account)
    {
        this.account = account;
    }
    
    public void setAmount(double transaction)
    {
        this.transaction = transaction;
    }
    
    public int getAccount()
    {
        return account;
    }
    
    public double getAmount()
    {
        return transaction;
    }
}

class FileMatch
{
    private Scanner inOldMaster;
    private Scanner inTransaction;
    private static Formatter outNewMaster;
    private static Formatter outLog;
    private Account account = new Account();
    private TransactionRecord transaction = new TransactionRecord();
    public FileMatch()
    {
        try
        {
            inOldMaster = new Scanner(Paths.get("oldmast.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            inTransaction = new Scanner(Paths.get("trans.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outNewMaster = new Formatter("newmast.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outLog = new Formatter("log.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        account.setAccount(inOldMaster.nextInt());
        account.setFirstName(inOldMaster.next());
        account.setLastName(inOldMaster.next());
        account.setBalance(inOldMaster.nextDouble());
        transaction.setAccount(inTransaction.nextInt());
        transaction.setAmount(inTransaction.nextDouble());
    }
    
    public void match()
    {
        do
        {
            //System.out.printf("%n%d %d%n", account.getAccount(), transaction.getAccount());
            if(transaction.getAccount() == account.getAccount())
            {
                account.combine(transaction);
                writeToNewMaster();
                nextTransaction();
                nextAccount();
            }
            else if(account.getAccount() > transaction.getAccount() || (account.getAccount() == 0 && transaction.getAccount() > 0))
            {
                outLog.format("Unmatched transaction record for account number %d%n", transaction.getAccount());
                nextTransaction();
            }
            else if(account.getAccount() < transaction.getAccount())
            {
                writeToNewMaster();
                nextAccount();
            }
        }while(transaction.getAccount() != 0 || account.getAccount() != 0);
        if(inOldMaster != null)
            inOldMaster.close();
        if(inTransaction != null)
            inTransaction.close();
        if(outNewMaster != null)
            outNewMaster.close();
        if(outLog != null)
            outLog.close();
    }
    
    private void nextTransaction()
    {
        if(inTransaction.hasNext())
        {
            transaction.setAccount(inTransaction.nextInt());
            transaction.setAmount(inTransaction.nextDouble());
        }
        else
        {
            transaction.setAccount(0);
            transaction.setAmount(0.00);
        }
    }
    private void nextAccount()
    {
        if(inOldMaster.hasNext())
        {
            account.setAccount(inOldMaster.nextInt());
            account.setFirstName(inOldMaster.next());
            account.setLastName(inOldMaster.next());
            account.setBalance(inOldMaster.nextDouble());
        }
        else
        {
            account.setAccount(0);
            account.setFirstName("end");
            account.setLastName("end");
            account.setBalance(0.00);
        }
    }
    private void writeToNewMaster()
    {
        outNewMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
    }

}


class FileMatchMult
{
    private Scanner inOldMaster;
    private Scanner inTransaction;
    private static Formatter outNewMaster;
    private static Formatter outLog;
    private Account account = new Account();
    private TransactionRecord transaction = new TransactionRecord();
    public FileMatchMult()
    {
        try
        {
            inOldMaster = new Scanner(Paths.get("oldmast.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            inTransaction = new Scanner(Paths.get("transMult.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outNewMaster = new Formatter("newmast.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outLog = new Formatter("log.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        account.setAccount(inOldMaster.nextInt());
        account.setFirstName(inOldMaster.next());
        account.setLastName(inOldMaster.next());
        account.setBalance(inOldMaster.nextDouble());
        transaction.setAccount(inTransaction.nextInt());
        transaction.setAmount(inTransaction.nextDouble());
    }
    
    public void match()
    {
        do
        {
            //System.out.printf("%n%d %d%n", account.getAccount(), transaction.getAccount());
            if(account.getAccount() > transaction.getAccount() || (account.getAccount() == 0 && transaction.getAccount() > 0))
            {
                outLog.format("Unmatched transaction record for account number %d%n", transaction.getAccount());
                nextTransaction();
            }
            else if(transaction.getAccount() == account.getAccount())
            {
                account.combine(transaction);
                nextTransaction();
            }
            else if(account.getAccount() < transaction.getAccount())
            {
                writeToNewMaster();
                nextAccount();
            }
        }while(transaction.getAccount() != 0 || account.getAccount() != 0);
        if(inOldMaster != null)
            inOldMaster.close();
        if(inTransaction != null)
            inTransaction.close();
        if(outNewMaster != null)
            outNewMaster.close();
        if(outLog != null)
            outLog.close();
    }
    
    private void nextTransaction()
    {
        if(inTransaction.hasNext())
        {
            transaction.setAccount(inTransaction.nextInt());
            transaction.setAmount(inTransaction.nextDouble());
        }
        else
        {
            transaction.setAccount(0);
            transaction.setAmount(0.00);
        }
    }
    private void nextAccount()
    {
        if(inOldMaster.hasNext())
        {
            account.setAccount(inOldMaster.nextInt());
            account.setFirstName(inOldMaster.next());
            account.setLastName(inOldMaster.next());
            account.setBalance(inOldMaster.nextDouble());
        }
        else
        {
            account.setAccount(0);
            account.setFirstName("end");
            account.setLastName("end");
            account.setBalance(0.00);
        }
    }
    private void writeToNewMaster()
    {
        outNewMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
    }
}

class FileMatchSer
{
    private static ObjectInputStream inOldMaster;
    private static ObjectInputStream inTransaction;
    private static Formatter outLog;
    private static ObjectOutputStream outNewMaster;
    private Account account;
    private TransactionRecord transaction;
    
    public FileMatchSer()
    {
        try
        {
            inOldMaster = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        try
        {
            inTransaction = new ObjectInputStream(Files.newInputStream(Paths.get("trans.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        
        try
        {
            outNewMaster = new ObjectOutputStream(Files.newOutputStream(Paths.get("newmast.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            outLog = new Formatter("log.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            account = (Account)inOldMaster.readObject();
        }
        catch(EOFException endOfFileException)
        {
            System.out.printf("%nNo data in the file.%n");
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch(IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
        
        try
        {
            transaction = (TransactionRecord)inTransaction.readObject();
        }
        catch(EOFException endOfFileException)
        {
            System.out.printf("%nNo data in the file.%n");
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch(IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
    public void match()
    {
        
        do
        {
            //System.out.printf("%n%d %d%n", account.getAccount(), transaction.getAccount());
            if(account.getAccount() > transaction.getAccount() || (account.getAccount() == 0 && transaction.getAccount() > 0))
            {
                outLog.format("Unmatched transaction record for account number %d%n", transaction.getAccount());
                nextTransaction();
            }
            else if(transaction.getAccount() == account.getAccount())
            {
                account.combine(transaction);
                nextTransaction();
            }
            else if(account.getAccount() < transaction.getAccount())
            {
                writeToNewMaster();
                nextAccount();
            }
        }while(transaction.getAccount() != 0 || account.getAccount() != 0);
        try
        {
            if(outNewMaster != null)
            outNewMaster.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
        if(outLog != null)
            outLog.close();
    }
    
    private void nextAccount()
    {
        try
        {
            account = (Account) inOldMaster.readObject();
        }
        catch(EOFException endOfFileException)
        {
            account.setAccount(0);
            account.setBalance(0.00);
            account.setFirstName("");
            account.setLastName("");
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch(IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
    private void nextTransaction()
    {
        try
        {
            transaction = (TransactionRecord)inTransaction.readObject();
        }
        catch(EOFException endOfFileException)
        {
            transaction.setAccount(0);
            transaction.setAmount(0.00);
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch(IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
    private void writeToNewMaster()
    {
        try
        {
            outNewMaster.writeObject(account);
        }
        catch(IOException ioException)
        {
            System.err.println("Error writing to file. Terminating.");
            System.exit(1);
        }
    }
}


class P157 
{
	public String[][] letters = {
            {"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"},
            {"J", "K", "L"}, {"M", "N", "O"}, {"P", "R", "S"},
            {"T", "U", "V"}, {"W", "X", "Y"}
	};

    public P157(String telephone) 
	{
		if (telephone.length() == 7) 
		{
        	try 
			{
            	PrintStream ps = new PrintStream(new File(telephone + ".txt"));
                List<String> combos = generateCombination(telephone);
                combos.forEach((combo) -> {
                        ps.format("%s%n", combo);
                });
                ps.close();
            } 
			catch (FileNotFoundException ex) 
			{
                System.err.println(ex.getMessage());
            }
			System.out.print("Revisar en la carpeta de donde se ejecuta este archivo java para ver los archivos de texto.");
            } 
			else 
                System.out.println("Ingrese numero de 7 digitos!");
        }

        public void generateCombosHelper(List<String> combos,
                String prefix, String remaining) {
            int digit = Integer.parseInt(remaining.substring(0, 1));
            if (remaining.length() == 1) {
                for (String mapping : letters[digit]) {
                    combos.add(prefix + mapping);
                }
            } else {
                for (String mapping : letters[digit]) {
                    generateCombosHelper(combos, prefix + mapping, remaining.substring(1));
                }
            }
        }

        public List<String> generateCombination(String phoneNumber) {
            List<String> combos = new LinkedList<>();
            generateCombosHelper(combos, "", phoneNumber);
            return combos;
        }
}
