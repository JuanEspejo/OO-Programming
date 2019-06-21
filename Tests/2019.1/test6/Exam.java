import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a world starting with a: ");
        String wordTest = input.nextLine();
        String word;

        if (SpellingChecker.simpleCheck(wordTest) >= 0) {
            System.out.println("word is spelled correctly.");
            System.exit(0);
        }
        System.out.println("word is not spelled correctly.");
        word = SpellingChecker.transposedCheck(wordTest);
        if (word != null)
            System.out.printf("Did you mean \"%s\"?\n", word);
        word = SpellingChecker.doubledCheck(wordTest);
        if (word != null)
            System.out.printf("Did you mean \"%s\"?\n", word);
    }
}


class SpellingChecker {

    static final String[] wordList = {"a","ability","able","about","above","accept","according","account","across","act","action","activity","actually","add","address","administration","admit","adult","affect","after","again","against","age","agency","agent","ago","agree","agreement","ahead","air","all","allow","almost","alone","along","already","also","although","always","American","among","amount","analysis","and","animal","another","answer","any","anyone","anything","appear","apply","approach","area","argue","arm","around","arrive","art","article","artist","as","ask","assume","at","attack","attention","attorney","audience","author","authority","available","avoid","away"};

    public static int simpleCheck(String word) {
        for (int j = 0; j < wordList.length; j++)
            if (word.equals(wordList[j]))
                return j;
        return -1;
    }

    public static String transposedCheck(String wordTest) {
        String auxStr;
        int k;
        for (int j = 1; j < wordTest.length(); j++) {
            auxStr = swap(wordTest,j-1,j);
            k = simpleCheck(auxStr);
            if (k >= 0)
                return wordList[k];
        }
        return null;
    }

    public static String doubledCheck(String wordTest) {
        String auxStr;
        int k;
        for (int j = 0; j < wordTest.length(); j++) {
            auxStr = doubleLetter(wordTest, j);
            k = simpleCheck(auxStr);
            if (k >= 0)
                return wordList[k];
        }
        return null;
    }

    private static String swap(String str, int j, int k) {
        StringBuilder auxStr = new StringBuilder(str);
        char auxChar = auxStr.charAt(j);
        auxStr.setCharAt(j,auxStr.charAt(k));
        auxStr.setCharAt(k,auxChar);
        return auxStr.toString();
    }

    private static String doubleLetter(String str, int k) {
        StringBuilder auxStr = new StringBuilder(str.length() + 1);
        for (int j = 0; j < str.length(); j++) {
            if (j < k)
                auxStr.append(str.charAt(j));
            if (j == k) {
                auxStr.append(str.charAt(j));
                auxStr.append(str.charAt(j));
            }
            if (j > k)
                auxStr.append(str.charAt(j));
        }
        return auxStr.toString();
    }
}
