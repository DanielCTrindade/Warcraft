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
public class Orcs extends Raca {
    
    /**
     * Construtor da raca Orcs
     * @param comida a comida inicial da raca
     * @param mana a mana inicial da raca
     * @param ouro o ouro inicial da raca
     * @param madeira a madeira inicial da raca
     * @param extinta boolean que representa se a raça esta extinta ou nao.
     */
    public Orcs(int comida, int mana, int ouro, int madeira, boolean extinta) {
        super(comida, mana, ouro, madeira, extinta);
        listaConstrucoesOrcs.add(new CentroDaCidade(this, new Posicao(100, 100), 10, 8, 600, "1254", true, 600));
        listaUnidadesOrcs.add(new Campones(2.0, 0, this, new Posicao(100, 100), 3, 0, 50, "2561", true, 50));
        listaUnidadesOrcs.add(new Campones(2.0, 0, this, new Posicao(100, 100), 3, 0, 50, "2561", true, 50));
        populacaoAtual = 2;
        capacidadeDaPopulacao = 10;
    }

 
}
