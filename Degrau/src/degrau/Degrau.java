/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degrau;

/**
 *
 * @author Douglas
 */
public class Degrau {

    private double w1, w2;
    private double x1[] = {0.0, 0.0, 1.0, 1.0};
    private double x2[] = {0.0, 1.0, 0.0, 1.0};
    private double limiar;

    public Degrau(double w1, double w2, double limiar) {
        this.w1 = w1;
        this.w2 = w2;
        this.limiar = limiar;
    }

    public int verificaDegrau(double x1, double x2) {
        return (x1 * w1 + x2 * w2) > limiar ? 1 : 0;
    }

    public double getX1(int i) {
        return x1[i];
    }

    public double getX2(int i) {
        return x2[i];
    }

}
