/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagation;

import java.util.function.DoubleFunction;

/**
 *
 * @author Douglas
 */
public class Backpropagation {

    private double t[], w0, v[][], w[][], v0[][], alpha, z[][], zf[][], zff[][], y[], yf[], yff[], erro[], errow[], deltaw[][], deltaw0, deltav[][], deltav0[][], zz[][], zzf[][], zzff[][], yy[], yyf[], Yamanaka[];

    public Backpropagation(double w0, double alpha) {
        t = new double[300];
        z = new double[6][1];
        zf = new double[6][1];
        zff = new double[6][1];
        y = new double[300];
        yf = new double[300];
        yff = new double[300];
        erro = new double[300];
        errow = new double[300];
        deltaw = new double[6][1];
        deltaw0 = 0.0;
        deltav = new double[6][1];
        deltav0 = new double[6][1];
        zz = new double[6][1];
        zzf = new double[6][1];
        zzff = new double[6][1];
        yy = new double[300];
        yyf = new double[300];
        Yamanaka = new double[600];

        this.w0 = w0;
        this.alpha = alpha;
    }

    public void iteracao(DoubleFunction f, double[][] v, double[][] w, double[][] v0, int num) {
        this.v = v;
        this.w = w;
        this.v0 = v0;

        for (int x = 0; x < 300; x++) {
            t[x] = (double) f.apply(x);
        }

        for (int n = 0; n < num; n++) { //treinamentos

            for (int x = 0; x < t.length; x++) {
                z[0][0] = v0[0][0] + t[x] * v[0][0];
                z[1][0] = v0[1][0] + t[x] * v[1][0];
                z[2][0] = v0[2][0] + t[x] * v[2][0];
                z[3][0] = v0[3][0] + t[x] * v[3][0];
                z[4][0] = v0[4][0] + t[x] * v[4][0];
                z[5][0] = v0[5][0] + t[x] * v[5][0];

                zf[0][0] = 2 / (1 + (Math.exp(-z[0][0]))) - 1;
                zf[1][0] = 2 / (1 + (Math.exp(-z[1][0]))) - 1;
                zf[2][0] = 2 / (1 + (Math.exp(-z[2][0]))) - 1;
                zf[3][0] = 2 / (1 + (Math.exp(-z[3][0]))) - 1;
                zf[4][0] = 2 / (1 + (Math.exp(-z[4][0]))) - 1;
                zf[5][0] = 2 / (1 + (Math.exp(-z[5][0]))) - 1;

                zff[0][0] = 0.5 * (1 + z[0][0]) * (1 - z[0][0]);
                zff[1][0] = 0.5 * (1 + z[1][0]) * (1 - z[1][0]);
                zff[2][0] = 0.5 * (1 + z[2][0]) * (1 - z[2][0]);
                zff[3][0] = 0.5 * (1 + z[3][0]) * (1 - z[3][0]);
                zff[4][0] = 0.5 * (1 + z[4][0]) * (1 - z[4][0]);
                zff[5][0] = 0.5 * (1 + z[5][0]) * (1 - z[5][0]);

                y[x] = w0 + zf[0][0] * w[0][0] + zf[1][0] * w[1][0] + zf[2][0] * w[2][0] + zf[3][0] * w[3][0] + zf[4][0] * w[4][0] + zf[5][0] * w[5][0];
                yf[x] = 2 / (1 + (Math.exp(-y[x]))) - 1;
                erro[x] = (t[x] - yf[x]);
                yff[x] = 0.5 * (1 + y[x]) * (1 - y[x]);
                errow[x] = alpha * erro[x] * yff[x];

                deltaw[0][0] = errow[x] * zf[0][0];
                deltaw[1][0] = errow[x] * zf[1][0];
                deltaw[2][0] = errow[x] * zf[2][0];
                deltaw[3][0] = errow[x] * zf[3][0];
                deltaw[4][0] = errow[x] * zf[4][0];
                deltaw[5][0] = errow[x] * zf[5][0];

                deltaw0 += alpha * erro[x];

                deltav[0][0] = deltaw[0][0] * w[0][0] * zff[0][0] * t[x];
                deltav[1][0] = deltaw[1][0] * w[1][0] * zff[1][0] * t[x];
                deltav[2][0] = deltaw[2][0] * w[2][0] * zff[2][0] * t[x];
                deltav[3][0] = deltaw[3][0] * w[3][0] * zff[3][0] * t[x];
                deltav[4][0] = deltaw[4][0] * w[4][0] * zff[4][0] * t[x];
                deltav[5][0] = deltaw[5][0] * w[5][0] * zff[5][0] * t[x];

                deltav0[0][0] = alpha * erro[x] * zf[0][0];
                deltav0[1][0] = alpha * erro[x] * zf[1][0];
                deltav0[2][0] = alpha * erro[x] * zf[2][0];
                deltav0[3][0] = alpha * erro[x] * zf[3][0];
                deltav0[4][0] = alpha * erro[x] * zf[4][0];
                deltav0[5][0] = alpha * erro[x] * zf[5][0];
            }

            w[0][0] = w[0][0] + deltaw[0][0];
            w[1][0] = w[1][0] + deltaw[1][0];
            w[2][0] = w[2][0] + deltaw[2][0];
            w[3][0] = w[3][0] + deltaw[3][0];
            w[4][0] = w[4][0] + deltaw[4][0];
            w[5][0] = w[5][0] + deltaw[5][0];

            w0 = w0 + deltaw0;

            v[0][0] = v[0][0] + deltav[0][0];
            v[1][0] = v[1][0] + deltav[1][0];
            v[2][0] = v[2][0] + deltav[2][0];
            v[3][0] = v[3][0] + deltav[3][0];
            v[4][0] = v[4][0] + deltav[4][0];
            v[5][0] = v[5][0] + deltav[5][0];

            v0[0][0] = v0[0][0] + deltav0[0][0];
            v0[1][0] = v0[1][0] + deltav0[1][0];
            v0[2][0] = v0[2][0] + deltav0[2][0];
            v0[3][0] = v0[3][0] + deltav0[3][0];
            v0[4][0] = v0[4][0] + deltav0[4][0];
            v0[5][0] = v0[5][0] + deltav0[5][0];

            System.out.println(String.format("Número de treinamentos: %d\n", n + 1));
        }
    }

    public double[] testeBackpropagation(double[][] vv0, double[][] vv, double ww0, double[][] ww) {
        System.out.println(String.format("Peso w0    = \t %.20f", ww0));

        for (int j = 0; j <= 5; j++) {
            System.out.println(String.format("Peso v0[%d] = \t %.20f", j, vv0[j][0]));
            System.out.println(String.format("Peso v[%d]  = \t %.20f", j, vv[j][0]));
            System.out.println(String.format("Peso w[%d]  = \t %.20f", j, ww[j][0]));
        }

        for (int x = 0; x < t.length; x++) {
            zz[0][0] = v0[0][0] + t[x] * v[0][0];
            zz[1][0] = v0[1][0] + t[x] * v[1][0];
            zz[2][0] = v0[2][0] + t[x] * v[2][0];
            zz[3][0] = v0[3][0] + t[x] * v[3][0];
            zz[4][0] = v0[4][0] + t[x] * v[4][0];
            zz[5][0] = v0[5][0] + t[x] * v[5][0];

            zzf[0][0] = 2 / (1 + (Math.exp(-zz[0][0]))) - 1;
            zzf[1][0] = 2 / (1 + (Math.exp(-zz[1][0]))) - 1;
            zzf[2][0] = 2 / (1 + (Math.exp(-zz[2][0]))) - 1;
            zzf[3][0] = 2 / (1 + (Math.exp(-zz[3][0]))) - 1;
            zzf[4][0] = 2 / (1 + (Math.exp(-zz[4][0]))) - 1;
            zzf[5][0] = 2 / (1 + (Math.exp(-zz[5][0]))) - 1;

            zzff[0][0] = 0.5 * (1 + zz[0][0]) * (1 - zz[0][0]);
            zzff[1][0] = 0.5 * (1 + zz[1][0]) * (1 - zz[1][0]);
            zzff[2][0] = 0.5 * (1 + zz[2][0]) * (1 - zz[2][0]);
            zzff[3][0] = 0.5 * (1 + zz[3][0]) * (1 - zz[3][0]);
            zzff[4][0] = 0.5 * (1 + zz[4][0]) * (1 - zz[4][0]);
            zzff[5][0] = 0.5 * (1 + zz[5][0]) * (1 - zz[5][0]);

            yy[x] = w0 + zzf[0][0] * w[0][0] + zzf[1][0] * w[1][0] + zzf[2][0] * w[2][0] + zzf[3][0] * w[3][0] + zzf[4][0] * w[4][0] + zzf[5][0] * w[5][0];
            yyf[x] = 2 / (1 + (Math.exp(-yy[x]))) - 1;
        }

        int k = 0;

        for (int i = 0; i < 300; i++) {
            Yamanaka[i] = t[i];
        }

        for (int j = 300; j < 600; j++) {
            Yamanaka[j] = yyf[k];
            k++;
        }

        return Yamanaka;
    }

    public double getW0() {
        return w0;
    }

    public double[][] getV() {
        return v;
    }

    public double[][] getW() {
        return w;
    }

    public double[][] getV0() {
        return v0;
    }

}
