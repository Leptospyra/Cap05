import java.util.Random;

public class ExercisesCap05 {
    public static void main (String[] args){
        //Exercise01();
        //Exercise02();
        //Exercise03();
        //Exercise04();
//        Exercise06();
         //Exercise07();
        //Exercise09();
        Exercise10();
        //Exercise01();
        //Exercise01();
        //Exercise01();
        //Exercise01();
        //Exercise01();
        //Exercise01();
        //Exercise01();

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
