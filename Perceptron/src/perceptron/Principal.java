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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aplicacao app = new Aplicacao(10, 1); //normalização

        double pesos[] = {0.11, -0.33, 0.44}; //{0.11, -0.33, 0.44}
        double classe0[][] = {
            {-1, -1}, //bias
            {app.distancia(4), app.tempo(0.9)}, //16 km/h
            {app.distancia(5), app.tempo(1)}, //18 km/h
            {app.distancia(1), app.tempo(0.1)}, //36 km/h
            {app.distancia(10), app.tempo(0.9)}, //40 km/h
            {app.distancia(6), app.tempo(0.5)}, //43 km/h
            {app.distancia(2), app.tempo(0.15)}, //46 km/h
            {app.distancia(8), app.tempo(0.6)}, //48 km/h
            {app.distancia(3), app.tempo(0.22)}, //49 km/h
            {app.distancia(9), app.tempo(0.65)}, //49.8 km/h
            {app.distancia(7), app.tempo(0.5)} //50.4 km/h
        }; //classe 0
        double classe1[][] = {
            {-1, -1}, //bias
            {app.distancia(5), app.tempo(0.35)}, //51.4 km/h
            {app.distancia(1), app.tempo(0.068)}, //52.9 km/h
            {app.distancia(5), app.tempo(0.33)}, //54.5 km/h
            {app.distancia(10), app.tempo(0.6)}, //60 km/h
            {app.distancia(9), app.tempo(0.5)}, //64.8 km/h
            {app.distancia(2), app.tempo(0.1)}, //72 km/h
            {app.distancia(4), app.tempo(0.18)}, //80 km/h
            {app.distancia(6), app.tempo(0.25)}, //86.4 km/h
            {app.distancia(10), app.tempo(0.4)}, //90 km/h
            {app.distancia(8), app.tempo(0.25)} //115 km/h
        }; //classe 1
        double limiar = 0.0;
        double taxaAprendizado = 0.1;

        double x1[][] = {
            {-1, -1}, //bias
            {app.distancia(2), app.tempo(0.3)}, //24 km/h
            {app.distancia(6), app.tempo(0.7)}, //30 km/h
            {app.distancia(7), app.tempo(0.6)}, //42 km/h
            {app.distancia(4), app.tempo(0.3)}, //48 km/h
            {app.distancia(1), app.tempo(0.072)} //50 km/h
        }; //entradas x1

        double x2[][] = {
            {-1, -1}, //bias
            {app.distancia(10), app.tempo(0.7)}, //52 km/h
            {app.distancia(2), app.tempo(0.119)}, //60 km/h
            {app.distancia(8), app.tempo(0.4)}, //72 km/h
            {app.distancia(1), app.tempo(0.04)}, //90 km/h
            {app.distancia(7), app.tempo(0.25)} //100 km/h
        }; //entradas x2

        Perceptron p = new Perceptron(pesos, classe0, classe1, limiar, taxaAprendizado);

        p.interacao(812, 10); //(812, 10)
        p.verificaPerceptron(p.getW(), x1, x2, 5);

    }

}
