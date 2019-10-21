/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

/**
 *
 * @author danie
 */
public class Casa extends Construcao {
    
    /**
     * 
     * Construtor da classe Casa
     * @param r a raça a qual a casa pertence
     * @param p a posicao da casa no mapa
     * @param ataque o ataque da casa(neste caso inexistente)
     * @param alcance neste caso nulo.
     * @param pontosVitais a vida da casa
     * @param imagem a representação gráfica da casa
     * @param estado representa o estado da casa(existente ou destruida)
     * @param p2 nulo.
     */
    public Casa(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    @Override
    public void ataca(Objeto o) {
        System.out.println("Esta construção não realiza ataques.");
    }

  

}
