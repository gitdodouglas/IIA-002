/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaline;

import java.util.function.DoubleFunction;

/**
 *
 * @author Douglas
 */
public class Adaline {

    private double f1[], f2[], f3[], f[], t[], w[][], taxaAprendizado;

    public Adaline(double[][] w, double taxaAprendizado) {
        f1 = new double[300];
        f2 = new double[300];
        f3 = new double[300];
        f = new double[300];
        t = new double[300];
        this.w = w;
        this.taxaAprendizado = taxaAprendizado;
    }

    public void interacao(DoubleFunction f1, DoubleFunction f2, DoubleFunction f3, int n) {
        for (int x = 0; x < 300; x++) {
            this.f1[x] = (double) f1.apply(x);
            this.f2[x] = (double) f2.apply(x);
            this.f3[x] = (double) f3.apply(x);
            this.f[x] = -Math.PI + 0.565 * this.f1[x] + 2.657 * this.f2[x] + 0.674 * this.f3[x];
        }

        for (int i = 0; i < n; i++) {
            w = entradaF1(w);
            System.out.println(String.format("Pesos w = \t %.20f", w[0][0]));
            System.out.println(String.format("Pesos w = \t %.20f", w[1][0]));
            System.out.println(String.format("Pesos w = \t %.20f", w[2][0]));
            System.out.println(String.format("Pesos w = \t %.20f", w[3][0]));
            System.out.println(String.format("Número de treinamentos: %d", (i + 1)));
        }
    }

    public double[][] entradaF1(double[][] w) {
        System.out.println("\nEntrada f1");

        for (int i = 0; i < 300; i++) {
            t[i] = w[0][0] + w[1][0] * f1[i] + w[2][0] * f2[i] + w[3][0] * f3[i];
            w[0][0] = w[0][0] + taxaAprendizado * Math.pow((f[i] - t[i]), 2.0) * 0.5;
            w[1][0] = w[1][0] + taxaAprendizado * Math.pow((f[i] - t[i]), 2.0) * 0.5 * f1[i];
            w[2][0] = w[2][0] + taxaAprendizado * Math.pow((f[i] - t[i]), 2.0) * 0.5 * f2[i];
            w[3][0] = w[3][0] + taxaAprendizado * Math.pow((f[i] - t[i]), 2.0) * 0.5 * f3[i];
        }

        return w;
    }

    public double[] verificaAdaline(double[][] ww) {
        System.out.println("\n\nTESTE DA REDE NEURAL\n");

        double[] ff = new double[300];
        double[] gg = new double[600];

        System.out.println("Pesos resultantes do treinamento");
        System.out.println(String.format("Pesos w = \t %.20f", ww[0][0]));
        System.out.println(String.format("Pesos w = \t %.20f", ww[1][0]));
        System.out.println(String.format("Pesos w = \t %.20f", ww[2][0]));
        System.out.println(String.format("Pesos w = \t %.20f", ww[3][0]));

        for (int i = 0; i < 300; i++) {
            ff[i] = ww[0][0] + ww[1][0] * f1[i] + ww[2][0] * f2[i] + ww[3][0] * f3[i];
        }

        int k = 0;

        for (int i = 0; i < 300; i++) {
            gg[i] = f[i];
        }

        for (int j = 300; j < 600; j++) {
            gg[j] = ff[k];
            k++;
        }

        return gg;
    }

    public double[][] getW() {
        return w;
    }

}
