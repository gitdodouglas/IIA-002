/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagation;

import java.awt.Color;
import java.util.Locale;
import javax.swing.JFrame;

/**
 *
 * @author Douglas
 */
public class Principal extends JFrame {

    private static double[] pesos = new double[600];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Grafico g = new Grafico();

        double w0 = 0.02074;
        double[][] v = {{0.9}, {-0.9}, {0.8}, {-0.7}, {0.99}, {-0.88}};
        double[][] w = {{0.9}, {-0.9}, {0.8}, {-0.7}, {0.99}, {-0.88}};
        double[][] v0 = {{0.9}, {-0.9}, {0.8}, {-0.7}, {0.99}, {-0.88}};
        double alpha = 0.000068;

        Backpropagation backp = new Backpropagation(w0, alpha);

        backp.iteracao(v, w, v0, 109000);
        pesos = backp.testeBackpropagation(backp.getV0(), backp.getV(), backp.getW0(), backp.getW());

        JFrame aplicacao = new JFrame();
        aplicacao.getContentPane().setBackground(new Color(255, 255, 255));
        aplicacao.setTitle("Redes Neurais Artificiais");
        aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacao.add(g);
        aplicacao.setSize(500, 480);
        aplicacao.setLocationRelativeTo(null);
        aplicacao.setVisible(true);

    }

    public static double[] getPesos() {
        return pesos;
    }

}
