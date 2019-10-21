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
public class Cavaleiro extends Unidade {

    /**
     * Construtor da classe Cavaleiro
     *
     * @param velocidade a velocidade do cavaleiro
     * @param armadura a armadura do cavaleiro
     * @param r a raça à qual o cavaleiro pertence
     * @param p a posicao do cavaleiro no mapa
     * @param ataque o ataque do cavaleiro
     * @param alcance o alcance do cavaleiro(neste caso inexistente)
     * @param pontosVitais a vida do cavaleiro
     * @param imagem a representação gráfica do cavaleiro
     * @param estado representa o estado do cavaleiro(vivo ou morto)
     * @param p2 atributo que armazena a vida inicial do cavaleiro para
     * posteriormente ser utilizado pelo sacerdote no metodo cura.
     */
    public Cavaleiro(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

}
