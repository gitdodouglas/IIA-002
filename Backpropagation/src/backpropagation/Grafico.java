/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author cmari_000
 */
public class Grafico extends JPanel {

    private static String mx, mn;
    private static double maximo, minimo, passo, a, b, c, d, e, f, l, h, i, j, m;

    private double evidencia;
    private double[] t = new double[300];
    private double[] w = new double[300];
    private double[] ff = new double[600];
    private double[] fg = new double[600];

    Principal aa = new Principal();

    Grafico() {
        //
    }

    Grafico(double[] shapes) {
        ff = shapes;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        minimo = 0;
        maximo = 1;
        passo = (maximo - minimo) / 10;

        a = minimo;
        b = minimo + passo;
        c = minimo + 2 * passo;
        d = minimo + 3 * passo;
        e = minimo + 4 * passo;
        f = minimo + 5 * passo;
        l = minimo + 6 * passo;
        h = minimo + 7 * passo;
        i = minimo + 8 * passo;
        j = minimo + 9 * passo;
        m = minimo + 10 * passo;

        g.setColor(Color.lightGray);

        //linhas horizontais
        int p = 70;
        do {
            for (int i = 0; i < 320; i = i + 20) {
                g.drawLine(0, p, i, p);
            }
            p = p + 22;
        } while (p <= 340);

        //linhas verticais
        int q = 0;
        do {
            for (int i = 0; i < 200; i = i + 20) {
                g.drawLine(q, 70, q, 332);
            }
            q = q + 20;
        } while (q < 320);

        g.setColor(Color.red);
        g.drawString("*sinal 1 ", 60, 50);

        g.setColor(Color.blue);
        g.drawString("*sinal 2 ", 130, 50);

        g.setColor(Color.BLACK);
        int k = 0, escala_horizontal = 0;
        //escala horizontal
        for (int i = 0; i <= 300; i = i + 20) {
            g.drawString("" + k, escala_horizontal, 350);
            escala_horizontal = escala_horizontal + 20;
            k = k + 2;
        }
        g.drawString("(*10)", 340, 350);

        //escala vertical
        g.drawString("-1.0   ", 320, 330); //+a
        g.drawString("-0.8   ", 320, 305); //+b
        g.drawString("-0.6   ", 320, 280); //+c
        g.drawString("-0.4   ", 320, 255); //+d
        g.drawString("-0.2   ", 320, 230); //+e
        g.drawString(" 0.0   ", 320, 205); //+f
        g.drawString(" 0.2   ", 320, 180); //+l
        g.drawString(" 0.4   ", 320, 155); //+h
        g.drawString(" 0.6   ", 320, 130); //+i
        g.drawString(" 0.9   ", 320, 105); //+j
        g.drawString(" 1.0   ", 320, 80);  //+m

        ff = aa.getPesos();

        System.arraycopy(ff, 0, fg, 0, 600);

        for (int nn = 0; nn < 300; nn++) {
            t[nn] = ff[nn];
        }

        System.arraycopy(ff, 300, w, 0, 300);

        //curva: multiplicar escala x por vinte para equivalência do seno
        int xx = 0;
        double y = 0, n = 0;

        for (int z = 0; z <= 299; z++) {
            y = +203 + (-250 * t[z]) * 0.5;//+330 +(-250*t[z]);//(int)(-120*pt.x1[z]); (*0.5)
            n = +203 + (-250 * w[z]) * 0.5;//+330 +(-250*w[z]);//(int)(-120*Math.cos(x*Math.PI/180));// (*0.5)
            g.setColor(Color.red);
            g.drawLine(xx - 1, (int) y - 1, xx, (int) y);
            g.setColor(Color.blue);
            g.drawLine(xx - 1, (int) n - 1, xx, (int) n);
            xx++;
        }

    }

}
