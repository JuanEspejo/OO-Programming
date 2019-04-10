// Hecho por Brando Palacios

import java.util.Scanner;

public class Christmas {
  public static void main(String[] args) {

    String [] dias =
     {"first","second","third","fourth","fiveth","sixth",
            "seventh","eighth","nineth","tenth","eleventh","twelfth"};
            for(int i=0;i<dias.length;i++) {
            System.out.println("On the "+dias[i]+" day of Christmas my true"+                                         "love sent to me:");
            switch(i) {
              case 11:  System.out.println("Twelve drummers drumming");
             case 10:  System.out.println("Eleven pipers piping");
                 case 9:  System.out.println("Ten Lords a Leaping");
             case 8:  System.out.println("Nine Ladies Dancing");
             case 7:  System.out.println("Eight Maids a Milking");
             case 6:  System.out.println("Seven Swans a Swimming");
             case 5:  System.out.println("Six Geese a Laying");
             case 4:  System.out.println("Five Golden Rings");
             case 3:  System.out.println("Four Calling Birds");
             case 2:  System.out.println("Three French Hens");
             case 1:     System.out.println("Two Turtle Doves");
                         System.out.println("And a partridge in a pear tree");
                         break;
             case 0:     System.out.println("A partridge in a pear tree");
            }
             System.out.println();
        }          
    }
}
