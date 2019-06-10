import java.util.Scanner;

class Exam {

    public static void main(String args[]) {

        Scanner read = new Scanner(System.in);
        System.out.printf("Digite la primera cadena: ");
        String s1 = read.nextLine();

        System.out.printf("Digite la segunda cadena: ");
        String s2 = read.nextLine();

        int i = s1.compareTo(s2);
        if( i > 0  ) System.out.println("Primera cadena es mayor que segunda cadena: "+i);
        if( i < 0  ) System.out.println("Segunda cadena es mayor que la primera cadena: "+i);
        if( i == 0 ) System.out.println("Son iguales en comparación: "+i);

        read.close();

    }
}
