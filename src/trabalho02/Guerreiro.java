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
public class Guerreiro extends Unidade {

    /**
     * Construtor da classe Guerreiro
     *
     * @param velocidade a velocidade do guerreiro
     * @param armadura a armadura do guerreiro
     * @param r a raça a qual o guerreiro pertence
     * @param p a posicao do guerreiro no mapa
     * @param ataque o ataque do guerreiro
     * @param alcance o alcance do guerreiro(neste caso nulo)
     * @param pontosVitais a vida do guerreiro
     * @param imagem a representacao grafica do guerreiro
     * @param estado representa o estado do guerreiro(vivo ou morto)
     * @param p2 atributo que armazena a vida inicial do guerreiro para
     * posteriomente ser utilizado pelo sacerdote no metodo cura.
     */
    public Guerreiro(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

}
