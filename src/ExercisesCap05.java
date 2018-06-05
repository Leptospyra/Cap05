import java.text.*;
import java.text.ParseException;
import java.util.*;

public class ExercisesCap05 {
    public static void main (String[] args) throws ParseException {
        //Exercise01();
        //Exercise02();
        //Exercise03();
        //Exercise04();
        //Exercise06();
         //Exercise07();
        //Exercise09();
        //Exercise11();
        //Exercise12();
        //Exercise13();
        //Exercise14();
        //Exercise15();
        Exercise16();
        //Exercise17();
        //Exercise18();

    }

    private static void Exercise16() throws ParseException {
        boolean flag = monthApart(1,2,3,4);//ficou redundante mas é melhor para entender
        if (flag) {
            System.out.println("A diferença é menor que 1 mes! ");
        } else{
            System.out.println("A diferença é menor que 1 mes! ");
        }

    }

    private static boolean monthApart(int mes01, int dia01, int mes02, int dia02) throws ParseException {
        String data1 = dia01+"/"+mes01+"/"+"2018";
        String data2 = dia02+"/"+mes02+"/"+"2018";
        String dataHoje = "01/01/2018";
        double numeroDiasDt01 = getDiasTranscorridos(data1, dataHoje);
        double numeroDiasDt02 = getDiasTranscorridos(data2, dataHoje);
        double diferenca = (numeroDiasDt01 - numeroDiasDt02);
        if (diferenca<0){
            diferenca = (numeroDiasDt02 - numeroDiasDt01);
        }
        System.out.println("O diferença em dias é de : " + diferenca);
        if (diferenca>30){
            return false;
        }
        return true;
    }
/*private static void Exercicio04(Scanner console) throws ParseException {
        System.out.println("Informe a data de hoje (dd/MM)");
        String dataHoje = console.next();
        dataHoje = dataHoje + "/2018";

        System.out.println("Informe a data do aniversario 1 (dd/MM)");
        String aniversario1 = console.next();
        aniversario1 = aniversario1 + "/2018";
        double diasAniver1 = getDiasTranscorridos(aniversario1, dataHoje);

        System.out.println("Informe a data do aniversario 2 (dd/MM)");
        String aniversario2 = console.next();
        aniversario2 = aniversario2 + "/2018";
        double diasAniver2 = getDiasTranscorridos(aniversario2, dataHoje);

        System.out.printf("Dias corridos que faltam para o aniversario 1 %s\n", diasAniver1);
        System.out.printf("Dias corridos que faltam para o aniversario 2 %s\n", diasAniver2);

        System.out.println();
        if (diasAniver1 < diasAniver2){
            System.out.println("O dia do aniversario do Aniversariante 1 está mais proximo: " + diasAniver1);
        } else {
            System.out.println("O dia do aniversario do Aniversariante 2 está mais proximo: " + diasAniver2);
        }
    }
*/
    private static double getDiasTranscorridos(String dataFutura, String dataHoje) throws ParseException {

        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = df.parse (dataHoje);
        Date d2 = df.parse (dataFutura); // aqui pega a string que eu recebi no cabeçalho
        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
        return (dt / 86400000L); // passaram-se 67111 dias
    }

    private static void Exercise15() {
        System.out.println(hasMidpoint(10,7,4));
    }

    private static Boolean hasMidpoint(int a, int b, int c) {
        //ordena os valores
        int maior = Math.max(a, Math.max(b,c));
        int menor = Math.min(a, Math.min(b,c));
        int meio =  Math.max(Math.max(Math.min(a, b),
                Math.min(b, c)),
                Math.min(a, c));
        //usado para simplificar o caulculo
        int aux = (maior - menor)/2;
        //confere se aux está no meio
        if (((aux + meio)== maior) && ((meio - aux)==menor)){
            return true;
        } else {
            return false;
        }
    }

    /*Write a method named numUnique that takes three integers as parameters and returns the
    number of unique integers among the three. For example, the call numUnique(18, 3, 4) should
    return 3 because the parameters have three different values. By contrast, the call
    numUnique(6, 7, 6) should return 2 because there are only two unique numbers among
    the three parameters: 6 and 7.*/
    private static void Exercise14() {
        System.out.println(numUnique(1, 1, 1));
    }
/*
    private static int numUnique(int a, int b, int c) { //solução da net
        if ((a == b)&& (b==c)){
            return 1;
        } else if ((a == b) || (a==c) || (b == c))  {
            return 2;
        }
        return 3;
    }
    */
    private static int numUnique(int a, int b, int c) {
        int cont = 3;
        if (a == b){
            cont--;
        }
        if (a==c){
            cont--;
        }
        if (b==c){
            cont--;
        }

        if (cont==0){
            return cont+1;
        }
        else {
            return cont;
        }
    }

    private static void Exercise13() {
        boolean flag = consecutive(-11,-12,-13);
        System.out.print(flag);
    }

    private static boolean consecutive(int a, int b, int c) {
        int maior = Math.max(a, Math.max(b,c));
        int menor = Math.min(a, Math.min(b,c));
        int meio =  Math.max(Math.max(Math.min(a, b),
                                     Math.min(b, c)),
                                     Math.min(a, c)); //retorna o valor do meio

        if ((menor + 1 == meio) && (meio+1==maior)){
            return true;
        } else {
            return false;
        }
        //System.out.printf("Menor: %s, Meio: %s, Maior %s", menor, meio, maior);
    }

    /*Write a method called printAverage that uses a sentinel loop to repeatedly prompt the user
    for numbers. Once the user types any number less than zero, the method should display the
    average of all nonnegative numbers typed. Display the average as a double.
    Type a number: 7
    Average was 9.0*/
    private static void Exercise12() {
        Scanner console = new Scanner(System.in);
        //System.out.print("Type a number: ");
        //int numero = console.nextInt();
        int numero = getNumberValid(console, "Type a number: ");
        int soma = 0;
        int count = 0;
        while (numero >= 0){
            soma = soma + numero;
            count++;
            numero = getNumberValid(console, "Type a number: ");
        }
        if (count != 0){ System.out.print("Avarage was " + 1.0*soma/count);}

    }
    private static int getNumberValid(Scanner console, String msg){
        System.out.print(msg);
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("You type a invalid number: ");
            System.out.print(msg);
        }

        return console.nextInt();
    }

    private static void Exercise10() {
        Random r = new Random();
        int coin = (r.nextInt(2));
        int countT = 0;
        int countH = 0;
        while ((countT != 3) && (countH != 3)) {
            if (coin == 1) {
                System.out.print(" T");
                countH = 0;
                countT++;

            } else {
                System.out.print(" H");
                countT = 0;
                countH++;
            }
            coin = (r.nextInt(2));

        }
        System.out.println(" fim");
    }

    /*Write a method called printFactors that accepts an integer as its parameter and uses a
    fencepost loop to print the factors of that number, separated by the word "and".
    For example, the factors of the number 24 should print as the following:
    1 and 2 and 3 and 4 and 6 and 8 and 12 and 24*/
    private static void Exercise09() {

        int numero = 6552;
        String descricao = "1 and ";
        for (int i = 2; i <= numero; i++ ) {
            if (numero % i ==0){
                numero = numero/i;
                descricao = descricao + i + " and ";
            }
        }
        System.out.println(descricao);
    }

    private static void Exercise07() {
        Random r = new Random();
        int dice01 = 0;
        int dice02 = 0;

        do {
            dice01 = (r.nextInt(5)+1);
            dice02 = (r.nextInt(5)+1);
            System.out.printf("%s and %s = %s \n", dice01, dice02, dice01+dice02 );

        } while(dice01+dice02!=9);

    }

    private static void Exercise06() {
        Random r = new Random();
        int num = 0;
        int count = 0;
        do {
            num = (r.nextInt(50));
            System.out.println("guess = " +num);
            count++;
        } while(num<48);
        System.out.print("Total guesses = " + count);
    }

    private static void Exercise04() {
        Random r = new Random();
        int num = 0;
        do {
            num = (r.nextInt(15)+5);
            for (int i = 1; i <= num; i++) {
                System.out.print("X");
            }
            System.out.println(num);
        } while(num<16);
    }

    private static void Exercise03() {
        System.out.println(toBinary(141));
    }

    private static String toBinary(int numero) {
        String resultado = "";
        int resto = 0;
        while ((numero!=1)||(resto!=0)){
            resto = numero%2;
            numero= numero/2;
            resultado = resto + resultado;
            //System.out.printf("Resto: %s, resultado: %s", resto, resultado);
        }
        return ("1" + resultado);
    }

    private static void Exercise02() {
        gcd(23732,180);
    }

    private static void gcd(int a, int b) {
        int cociente = 0;
        int divisor = 0;
        int dividendo = 0;
        int resto = 1;
        dividendo = a;
        divisor = b;
        int mdc = 0;
        int cont = 0;
        while (resto != 0) {
            mdc = resto;
            cociente = dividendo / divisor;
            resto = dividendo % divisor;
            dividendo = divisor;
            divisor = resto;
            cont++;
            System.out.println(cont);
        }
        System.out.printf("O mdc: entre %s e %s é %s;",a,b, mdc);
    }

    private static void Exercise01() {
        System.out.println(showTwos(7));
        System.out.println(showTwos(18));
        System.out.println(showTwos(68));
        System.out.println(showTwos(120));
    }

    private static String showTwos(int numero) {
        String equacao = "";
        while (numero % 2 == 0){
            equacao += "2 * ";
            numero /= 2;
        }
        equacao += numero;
        return (equacao);
    }
}
