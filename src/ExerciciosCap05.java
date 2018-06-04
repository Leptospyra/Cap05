import java.util.Random;
import java.util.Scanner;

public class ExerciciosCap05 {
    public static void main(String[] args){
        //Exercicio06();
        //Exercicio09();
        //Exercicio10();
        //Exercicio11();
        //Exercicio12();
        //Exercicio13();
        //System.out.println(contains("Rafae", 'l'));
    }


    public static boolean contains(String str, char ch) {
        boolean found = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                found = true;
            }
        }
        return found;
    }
    /*Write a sentinel loop that repeatedly prompts the user to enter a number and,
    once the number –1 is typed,
    displays the maximum and minimum numbers that the user entered. Here is a sample dialogue:
    Type a number (or –1 to stop): 5*/
    private static void Exercicio13() {
        Scanner console = new Scanner(System.in);
        int num = -1;
        int max = -1;
        int min = -1;
        //System.-1out.println("Type a number (or –1 to stop):");
        //num = console.nextInt();
        num = getInt13(console, "Type a number (or –1 to stop):");
        while (num != -1){

            if ( max == -1){
                max = num;
                min = num;
            }

            if (num > max){
                max = num;
            }

            if (num < max){
                min = num;
            }
            num = getInt13(console, "Type a number (or –1 to stop):");
            //System.out.println("Type a number (or –1 to stop):");
           // num = console.nextInt();
        }
        if ( max == -1 && min == -1){
            max++;
            min++;
        }
        System.out.printf("Maior: %s, menor: %s ", max, min);
    }

    public static int getInt13(Scanner console, String prompt){
        System.out.println(prompt);
        while (!console.hasNextInt()){
            console.next();
            System.out.print("Este não é um número inteiro, tente novamente.");
            System.out.println(prompt);
        }
        return console.nextInt();
    }

    /*Consider the flawed method printLetters that follows, which accepts a String as its parameter
    and attempts to print the letters of the String, separated by dashes.*/
    public static void Exercicio12() {
        printLetters("Rafael");
    }
    public static void printLetters(String text) {
        int i=0;
        System.out.print(text.charAt(i));
        /*for (int j = 1; j < text.length(); j++) {
            System.out.print("-" + text.charAt(j));
        }*/
        do {
            i++;
            System.out.print("-" + text.charAt(i));
        } while (i<text.length()-1);
    }

    /*Write a do/while loop that repeatedly prints random numbers between 0 and 1000 until a number above 900 is
    printed. At least one line of output should always be printed, even if the first random number is above 900.*/
    private static void Exercicio11() {
        Random r = new Random();
        int num = 0;

        do {
            num = r.nextInt(1001);
            System.out.printf("Random number: %s\n", num);
        } while (num < 900);
        System.out.println("Fim");
    }

    /*zeroDigits accepts an integer parameter and returns the number of digits in the number that have the value 0.*/
    private static void Exercicio10() {
        Scanner console = new Scanner(System.in);
        String resposta = "y";
        do {
            int numerox = getInt(console, "Informe um numero inteiro:");
            System.out.printf("Esse numero tem %s zero(s)\n", zeroDigits(numerox));
            System.out.print("Do you want to try it again?");
            resposta = console.next();
        } while (resposta.equals("y"));
        System.out.println("Fim");
    }

    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next(); // to discard the input
            System.out.println("O número não é um inteiro; Tente novamente.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }

    public static int zeroDigits(int n) {
        String numero = n + "";
        int count = 0;
        for (int i = 0; i < numero.length(); i++){
            if (numero.charAt(i) == '0'){
                count++;
            }

        }
        return count;
    }

    /*
           * Write a do/while loop that repeatedly prints a certain message until the user tells the program to stop. The do/while is
   appropriate because the message should always be printed at least one time, even if the user types n after the first message
   appears.
           * */
    public static void Exercicio09(){
        Scanner console = new Scanner(System.in);
        String resposta = "y";
        do {
            System.out.println("She sells seashells by the seashore");
            System.out.print("Do you want to hear it again?");
            resposta = console.next();
        } while (resposta.equals("y"));
    }

    public static void Exercicio06() {
        Random r = new Random();
        r.nextInt(11);
        int num = (r.nextInt(50)+50);
        if (num % 2 == 0){
            num++;
        }
        System.out.println(num);
    }

}
