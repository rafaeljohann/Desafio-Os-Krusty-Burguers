/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiohomersimpson;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class DesafioHomerSimpson {

    /**
     * @param args the command line arguments
     */
    private static Hamburguer gerenciaHamburgueres(int qtdTempoKrusty, int qtdTempoApu, int qtdTempoTotal) {
        Hamburguer hamburguerKrusty = new Hamburguer();
        Hamburguer hamburguerApu = new Hamburguer();
        
        hamburguerKrusty = CalculaKrustyBurguer(qtdTempoKrusty, qtdTempoApu, qtdTempoTotal);
        hamburguerApu = CalculaApuBurguer(qtdTempoKrusty, qtdTempoApu, qtdTempoTotal);
        
        if (hamburguerKrusty.qtdCerveja <= hamburguerApu.qtdCerveja && hamburguerKrusty.qtdMaxComida >= hamburguerApu.qtdMaxComida){
            return hamburguerKrusty;
        }else {
            return hamburguerApu;
        }
    }
    
    public static Hamburguer CalculaKrustyBurguer(int qtdTempoKrusty, int qtdTempoApu, int qtdTempoTotal){
        Hamburguer hamburguerKrusty = new Hamburguer();
        Hamburguer hamburguerApu = new Hamburguer();
        int tempoApu = qtdTempoApu;
        Hamburguer melhorHamburguer = new Hamburguer();
        int count = 0;
        
        hamburguerKrusty = hamburguerKrusty.contadorBurguer(qtdTempoKrusty, qtdTempoTotal);
        
        do{
            hamburguerKrusty.qtdMaxComida = hamburguerKrusty.getQtdComida();
            hamburguerKrusty.qtdCerveja = hamburguerKrusty.getTempoRestante();
            count++;

            if (hamburguerKrusty.qtdMaxComida <= 0) {
                melhorHamburguer = hamburguerKrusty;
                break;
            }

            if (hamburguerKrusty.getTempoRestante() > 0 
                    && hamburguerKrusty.getTempoRestante() > tempoApu) {
                hamburguerApu = hamburguerApu.contadorBurguer(tempoApu, hamburguerKrusty.getTempoRestante());
                hamburguerKrusty.qtdMaxComida += hamburguerApu.getQtdComida();
                hamburguerKrusty.qtdCerveja = hamburguerApu.getTempoRestante();
            }

            hamburguerKrusty.qtdComida--;
            hamburguerKrusty.tempoRestante = hamburguerKrusty.tempoRestante + qtdTempoKrusty;
            
            if ((count == 1 || hamburguerKrusty.qtdCerveja <= melhorHamburguer.qtdCerveja) && hamburguerKrusty.qtdMaxComida > melhorHamburguer.qtdMaxComida
                || (hamburguerKrusty.qtdCerveja == 0 && melhorHamburguer.qtdCerveja > 0)) {
                melhorHamburguer.setQtdCerveja(hamburguerKrusty.getQtdCerveja());
                melhorHamburguer.setQtdMaxComida(hamburguerKrusty.getQtdMaxComida());
            }
                
            if (hamburguerKrusty.tempoRestante >= qtdTempoTotal)
                break;
        }while(hamburguerKrusty.qtdCerveja > 0);
        
        return melhorHamburguer;
    }
    
    public static Hamburguer CalculaApuBurguer(int qtdTempoKrusty, int qtdTempoApu, int qtdTempoTotal){
        Hamburguer hamburguerKrusty = new Hamburguer();
        Hamburguer hamburguerApu = new Hamburguer();
        Hamburguer melhorHamburguer = new Hamburguer();
        int count = 0;
        
        hamburguerApu = hamburguerApu.contadorBurguer(qtdTempoApu, qtdTempoTotal);
        int tempoKrusty = qtdTempoKrusty;
        
        do{
            hamburguerApu.qtdMaxComida = hamburguerApu.getQtdComida();
            hamburguerApu.qtdCerveja = hamburguerApu.getTempoRestante();
            
            count++;
            
            if (hamburguerApu.qtdMaxComida <= 0) {
                melhorHamburguer = hamburguerApu;
                break;
            }
            
            if (hamburguerApu.getTempoRestante() > 0 
                    && hamburguerApu.getTempoRestante() > tempoKrusty) {
                hamburguerKrusty = hamburguerKrusty.contadorBurguer(tempoKrusty, hamburguerApu.getTempoRestante());
                hamburguerApu.qtdMaxComida += hamburguerKrusty.getQtdComida();
                hamburguerApu.qtdCerveja = hamburguerKrusty.getTempoRestante();
            }
            
            hamburguerApu.qtdComida--;
            hamburguerApu.tempoRestante = hamburguerApu.tempoRestante + qtdTempoApu;
            
            if ((count == 1 || hamburguerApu.qtdCerveja <= melhorHamburguer.qtdCerveja) && hamburguerApu.qtdMaxComida > melhorHamburguer.qtdMaxComida
                || (hamburguerApu.qtdCerveja == 0 && melhorHamburguer.qtdCerveja > 0)) {
                melhorHamburguer.setQtdCerveja(hamburguerApu.getQtdCerveja());
                melhorHamburguer.setQtdMaxComida(hamburguerApu.getQtdMaxComida());
            }
            
            if (hamburguerApu.tempoRestante >= qtdTempoTotal)
                break;
        }while(hamburguerApu.qtdCerveja > 0);
        
        return melhorHamburguer;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tempo para comer Krusty Burguer: ");
        int qtdTempoKrusty = sc.nextInt();
        
        System.out.println("Informe o tempo para comer Apu Burguer: ");
        int qtdTempoApu = sc.nextInt();
        
        System.out.println("Informe o tempo total disponível para comer: ");
        int tempoTotal = sc.nextInt();

        Hamburguer hamburguer = new Hamburguer();
        hamburguer = gerenciaHamburgueres(qtdTempoKrusty, qtdTempoApu, tempoTotal);
        
        if (hamburguer.qtdCerveja > 0) {
            System.out.println(hamburguer.qtdMaxComida + " " + hamburguer.qtdCerveja);
        }else {
            System.out.println(hamburguer.qtdMaxComida);
        }
    }
}