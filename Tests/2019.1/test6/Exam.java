import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Exam {
            
    public static void main(String[] args) {
        
        Corrector.prueba();
        //Pregunta 4; en mi algoritmo no necesito eliminar dobles
        System.out.println(Corrector.eliminaDoble("Baaaloow"));

    } 
}


class Corrector{
    
    static String[] wordList = {"a","ability","able","about","above","accept","according","account","across","act","action","activity","actually","add","address", 
        "administration","admit","adult","affect","after","again","against","age","agency","agent","ago","agree","agreement","ahead","air","all","allow",
        "almost","alone","along","already","also","although","always","American","among","amount","analysis","and","animal","another","answer","any",
        "anyone","anything","appear","apply","approach","area","argue","arm","around","arrive","art","article","artist","as","ask","assume","at","attack","attention","attorney",
        "audience","author","authority","available","avoid","away"}; 
    
    public static void prueba(){        
        
        List<String> wordList2 = Arrays.asList(wordList); // creamos lista del array de String.
        Scanner reader = new Scanner(System.in);
        System.out.printf("Digite una palabra: ");
        String word = reader.nextLine();        

        if(wordList2.contains(word)) System.out.println("word is spelled correctly.");
        else {
            System.out.println("word is not spelled correctly.");
            int compara = 0;
            int max = -10000;
            int aux,tieneTodo;
            String strAux = null;
            String guarda = null;      
            word = word.toLowerCase();
            
            for( String str : wordList ){
                guarda = str;
                aux = 0;
                tieneTodo = 0;
                for( int i = 0; i < word.length() ; i++){          
                    if(contiene((word.charAt(i)),str)){

                        compara += 1;
                        tieneTodo += 1;
                        if( word.length() == guarda.length()){ // caso misma longitud
                            if( aux == 0){
                                 compara += 1; // siempre de la misma longitud tendra prioridad.
                                 aux = 1;
                            }
                           
                            if( word.charAt(i) == guarda.charAt(i)) compara += 1;  // mas coincidencias en posicion              
                        }
                        
                        if( word.length() < guarda.length()){ // caso palabra ingresada mas pequeña que la analizada
                            if( word.charAt(i) == guarda.charAt(i+(guarda.length()-word.length()))) compara += 1; // por derecha
                            if( word.charAt(i) == guarda.charAt(i)) compara += 1; // por izquierda       
                        }
                        
                        if( word.length() > guarda.length()){ // caso palabra ingresada mas grande que la analizada
                            if(i < guarda.length()){ // para no exceder indice del menor
                                if( word.charAt(i+(word.length()-guarda.length())) == guarda.charAt(i)) compara += 1; // por derecha
                                if( word.charAt(i) == guarda.charAt(i)) compara += 1; // por izquierda
                            }
                        }  
                       
                        str = elimina(str,word.charAt(i)); // no repetir coincidencias
                        //System.out.println(str+" "+compara);
                    }
                }
                if(tieneTodo == guarda.length()) compara += 1;
                if( compara > max){
                    max = compara;
                    strAux = guarda;
                }
                compara = 0;
            }
            if( Math.abs(max-(2*strAux.length()+1)) < 5)System.out.println("Did you mean \""+strAux+"\" ?");
            else System.out.println("No suggestion");
        }
        reader.close(); 
    }
    
    private static boolean contiene(char a, String b){
        for(int i = 0; i<b.length(); i++){
            if(b.charAt(i)==a) return true;
        }
        return false;
    }
    
    public static String elimina(String a, char b){
        int index = 0;
        String resultado = null;
        for(int i = 0; i<a.length(); i++){
            
            if(a.charAt(i)==b) {
                index = i;
                i = a.length()+1; // primera coincidencia eliminado
            }
        }
        resultado = a.substring(0, index) + a.substring(index+1,a.length());
        return resultado;
    }
    
    public static String eliminaDoble(String a){
        String resultado = "";        
        resultado = a.replaceAll("(.)\\1","$1");
        return resultado;
    }
    
}
