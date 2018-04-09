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
public class Aplicacao {

    private double limiteDistancia;
    private double limiteTempo;

    public Aplicacao(double limiteDistancia, double limiteTempo) {
        this.limiteDistancia = limiteDistancia;
        this.limiteTempo = limiteTempo;
    }

    public double distancia(double d) {
        return d / limiteDistancia; //normaliza a distância
    }

    public double tempo(double t) {
        return t / limiteTempo; //normaliza o tempo
    }

}
