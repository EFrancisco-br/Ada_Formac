import java.util.Scanner;

public class Baskara {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("---------------------------------------");
        System.out.println("FÓRMULA DE BÁSKARA OU DO 2º GRAU");
        System.out.println("Calcula as raízes para a equação");
        System.out.println("do 2º grau: ax² + bx + c = 0");
        System.out.println("---------------------------------------");
        System.out.println("Você deve entrar com três valores reais");
        System.out.print("Qual o valor de a: ");
        double a = ler.nextDouble();
        System.out.print("Qual o valor de b: ");
        double b = ler.nextDouble();
        System.out.print("Qual o valor de c: ");
        double c = ler.nextDouble();
        System.out.println("---------------------------------------");

        double delta = CalculaDelta(a, b, c);
        System.out.printf("O discriminante (delta) é %.3f \n", delta);
        System.out.println("---------------------------------------");
        if (delta < 0) {
            System.out.println("A equação não possui resultados reais!");
        } else if (delta > 0) {
            System.out.println("A equação possui dois resultados reais:");
            System.out.printf("As raiz da equação são %.3f e %.3f \n", CalculaRaiz(a, b, Math.sqrt(delta)), CalculaRaiz(a, b, Math.sqrt(delta) * -1));
        } else {
            System.out.println("A equação possui um resultado real:");
            System.out.printf("A raiz da equação é %.3f \n", CalculaRaiz(a, b, Math.sqrt(delta)));
        }
       System.out.println("---------------------------------------");

    }
    public static double CalculaDelta(double a, double b, double c) {
        return (Math.pow(b,2) - 4 * a * c);
    }
    public static double CalculaRaiz(double a, double b, double raizQuadradaDelta) {
        return (((-1*b)+raizQuadradaDelta)/(2 * a));
    }
}
