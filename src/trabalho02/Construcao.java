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
public abstract class Construcao extends Objeto {
    
    /**
     * Construtor da classe abstrata Construcao
     * @param r a raça a qual a construção pertence
     * @param p a posicao da construçao
     * @param ataque o ataque da construcao
     * @param alcance o alcance da construçao
     * @param pontosVitais a vida da construcao
     * @param imagem a representação grafica da construcao
     * @param estado represnte o estado da construcao(existente ou destruida)
     * @param p2  nulo;
     */
    public Construcao(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }


}
