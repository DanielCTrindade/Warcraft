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
public class Humanos extends Raca {

    /**
     * Construtor da raça humanos
     * @param comida a comida inicial da raça
     * @param mana a mana inicial da raça
     * @param ouro o ouro inicial da raça
     * @param madeira a madeira inicial da raça
     * @param extinta boolean que representa se a raça está extinta.
     */
    public Humanos(int comida, int mana, int ouro, int madeira, boolean extinta) {
        super(comida, mana, ouro, madeira, extinta);
        //A raça ja começa com um centro da cidade e dois camponeses
        listaConstrucoesHumanas.add(new CentroDaCidade(this, new Posicao(0, 0), 10, 8, 600, "1254", true, 600));
        listaUnidadesHumanas.add(new Campones(2.0, 0, this, new Posicao(0, 0), 3, 0, 50, "2561", true, 50));
        listaUnidadesHumanas.add(new Campones(2.0, 0, this, new Posicao(0, 0), 3, 0, 50, "2561", true, 50));
        populacaoAtual = 2;
        capacidadeDaPopulacao = 10;

    }

}
