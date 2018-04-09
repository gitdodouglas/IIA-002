/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author Douglas
 */
public class Perceptron {

    private double w[], x1[][], x2[][], limiar, u0, taxaAprendizado;
    private int f, y1, y2;

    public Perceptron(double[] w, double[][] x1, double[][] x2, double limiar, double taxaAprendizado) {
        this.w = w;
        this.x1 = x1;
        this.x2 = x2;
        this.limiar = limiar;
        this.taxaAprendizado = taxaAprendizado;
        this.y1 = 0;
        this.y2 = 1;
    }

    public void interacao(int n, int e) {
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("\nTreinamento: %d", (i + 1)));
            for (int v = 1; v <= e; v++) {
                w = entradaX1(w, v);
                w = entradaX2(w, v);
            }
        }
    }

    public double[] entradaX1(double[] w, int u) {
        System.out.println("Entrada x1");

        u0 = 0;
        u0 = w[0] * x1[0][0] + w[1] * x1[u][0] + w[2] * x1[u][1];
        System.out.println(String.format("Valor de u0 = \t %.20f", u0));

        f = u0 > limiar ? 1 : 0;
        System.out.println(String.format("Valor de f = \t %d", f));

        w[0] = w[0] + taxaAprendizado * (y1 - f) * x1[0][0];
        System.out.println(String.format("Pesos w = \t %.20f", w[0]));
        w[1] = w[1] + taxaAprendizado * (y1 - f) * x1[u][0];
        System.out.println(String.format("Pesos w = \t %.20f", w[1]));
        w[2] = w[2] + taxaAprendizado * (y1 - f) * x1[u][1];
        System.out.println(String.format("Pesos w = \t %.20f", w[2]));

        return w;
    }

    public double[] entradaX2(double[] w, int u) {
        System.out.println("Entrada x2");

        u0 = 0;
        u0 = w[0] * x2[0][0] + w[1] * x2[u][0] + w[2] * x2[u][1];
        System.out.println(String.format("Valor de u0 = \t %.20f", u0));

        f = u0 > limiar ? 1 : 0;
        System.out.println(String.format("Valor de f = \t %d", f));

        w[0] = w[0] + taxaAprendizado * (y2 - f) * x2[0][0];
        System.out.println(String.format("Pesos w = \t %.20f", w[0]));
        w[1] = w[1] + taxaAprendizado * (y2 - f) * x2[u][0];
        System.out.println(String.format("Pesos w = \t %.20f", w[1]));
        w[2] = w[2] + taxaAprendizado * (y2 - f) * x2[u][1];
        System.out.println(String.format("Pesos w = \t %.20f", w[2]));

        return w;
    }

    public void verificaPerceptron(double[] w, double[][] x1, double[][] x2, int e) {
        System.out.println("\n\nTESTE DA REDE NEURAL\n");

        System.out.println("Pesos resultantes do treinamento");
        for (int i = 0; i < w.length; i++) {
            System.out.println(String.format("w[%d] = \t %.20f", i, w[i]));
        }

        System.out.println("\nEntrada x1");
        u0 = 0;
        for (int p = 1; p <= e; p++) {
            u0 = w[0] * x1[0][0] + w[1] * x1[p][0] + w[2] * x1[p][1];
            System.out.print(String.format("u0 = \t %.20f \t", u0));

            f = u0 > limiar ? 1 : 0;
            System.out.println(String.format("Saída y = %d", f));
        }

        System.out.println("\nEntrada x2");
        u0 = 0;
        for (int p = 1; p <= e; p++) {
            u0 = w[0] * x2[0][0] + w[1] * x2[p][0] + w[2] * x2[p][1];
            System.out.print(String.format("u0 = \t %.20f \t", u0));

            f = u0 > limiar ? 1 : 0;
            System.out.println(String.format("Saída y = %d", f));
        }
    }

    public double[] getW() {
        return w;
    }

}
