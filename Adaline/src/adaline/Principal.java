/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaline;

import java.awt.Color;
import java.util.Locale;
import java.util.function.DoubleFunction;
import javax.swing.JFrame;

/**
 *
 * @author Douglas
 */
public class Principal extends JFrame {

    private static double[] pesos = new double[300];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Grafico g = new Grafico();

        double w[][] = {{-2.4013}, {0.393}, {1.902}, {0.429}};
        double taxaAprendizado = 0.000027;

        Adaline ad = new Adaline(w, taxaAprendizado);

        //Padrão treinado
        DoubleFunction f1 = (x) -> Math.sin(x * Math.PI / 180);
        DoubleFunction f2 = (x) -> Math.cos(x * Math.PI / 180);
        DoubleFunction f3 = (x) -> x * Math.PI / 180;

        //Valores para comparação
        DoubleFunction f4 = (i) -> (Math.sin(i * Math.PI / 180)) * 0.8;
        DoubleFunction f5 = (i) -> (Math.cos(i * Math.PI / 180)) * 0.9;
        DoubleFunction f6 = (i) -> (i * Math.PI / 180) * 1.1;

        ad.interacao(f1, f2, f3, f4, f5, f6, 32);
        pesos = ad.verificaAdaline(ad.getW());

        JFrame aplicacao = new JFrame();
        aplicacao.getContentPane().setBackground(new Color(255, 255, 255));
        aplicacao.setTitle("Redes Neurais Artificiais");
        aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacao.add(g);
        aplicacao.setSize(400, 420);
        aplicacao.setLocationRelativeTo(null);
        aplicacao.setVisible(true);

    }

    public static double[] getPesos() {
        return pesos;
    }

}
