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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Degrau ld = new Degrau(1.0, 1.0, 1.5); //AND
        //Degrau ld = new Degrau(1.0, 1.0, 0.9); //OR
        //Degrau ld = new Degrau(-1.0, -1.0, -1.5); //NAND
        //Degrau ld = new Degrau(-1.0, -1.0, -0.9); //NOR

        System.out.println("A  B  F");
        System.out.println(String.format("%.0f  %.0f  %d", ld.getX1(0), ld.getX2(0), ld.verificaDegrau(ld.getX1(0), ld.getX2(0))));
        System.out.println(String.format("%.0f  %.0f  %d", ld.getX1(1), ld.getX2(1), ld.verificaDegrau(ld.getX1(1), ld.getX2(1))));
        System.out.println(String.format("%.0f  %.0f  %d", ld.getX1(2), ld.getX2(2), ld.verificaDegrau(ld.getX1(2), ld.getX2(2))));
        System.out.println(String.format("%.0f  %.0f  %d", ld.getX1(3), ld.getX2(3), ld.verificaDegrau(ld.getX1(3), ld.getX2(3))));

    }

}
