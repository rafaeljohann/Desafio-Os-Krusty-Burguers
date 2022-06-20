/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiohomersimpson;

/**
 *
 * @author Rafael
 */
public class Hamburguer {
    public int tempoRestante;
    public int qtdComida;
    public int qtdMaxComida;
    public int qtdCerveja;
    
    public Hamburguer() {
        
    }
    
    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public int getQtdComida() {
        return qtdComida;
    }

    public void setQtdComida(int qtdComida) {
        this.qtdComida = qtdComida;
    }
    
    public int getQtdMaxComida() {
        return qtdMaxComida;
    }
    
    public void setQtdMaxComida(int qtdMaxComida) {
        this.qtdMaxComida = qtdMaxComida;
    }
    
    public int getQtdCerveja() {
        return qtdCerveja;
    }
    
    public void setQtdCerveja(int qtdCerveja) {
        this.qtdCerveja = qtdCerveja;
    }
    
    public Hamburguer contadorBurguer(int qtdTempoBurguer, int tempo) {
        int qtdComida = 0;
        
        for(int i = 1; i <= tempo; i++) {
            if (qtdTempoBurguer == 1) {
                qtdComida = tempo;
                tempo = 0;
                break;
            } else if (i == qtdTempoBurguer) {
                qtdComida++;
                tempo = tempo - qtdTempoBurguer;
                i = 1;
            }
        }
        
        this.setQtdComida(qtdComida);
        this.setTempoRestante(tempo);
        
        return this;
    }
}
