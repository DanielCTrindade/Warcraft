/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public abstract class Raca {
    
    //Aqui temos os atributos da classe raca, sendo que existem arraylists especificos para humanos e orcs.
    protected ArrayList<Unidade> listaUnidadesHumanas = new ArrayList();
    protected ArrayList<Construcao> listaConstrucoesHumanas = new ArrayList();
    protected ArrayList<Unidade> listaUnidadesOrcs = new ArrayList();
    protected ArrayList<Construcao> listaConstrucoesOrcs = new ArrayList();
    protected ArrayList<Unidade> listaUnidadesMortas = new ArrayList();
    protected int comida;
    protected int mana;
    protected int ouro;
    protected int madeira;
    //Representa a capacidade da populacao, contando o aumento em caso de construcao de casas ou centros da cidade.
    protected int capacidadeDaPopulacao;
    protected int populacaoAtual;
    protected boolean extinta;
   
    /**
     * Construtor da classe abstrata Raca
     * esta classe é pai das classes Humanos e Orcs
     * @param comida a comida inicial da raca a ser criada
     * @param mana a mana inicial da raca a ser criada
     * @param ouro o ouro inicial da raca a ser criada
     * @param madeira a madeira inicial da raca a ser criada
     * @param extinta  representa se a raca esta extinta ou nao.
     */
    public Raca(int comida, int mana, int ouro, int madeira, boolean extinta) {
        this.comida = comida;
        this.mana = mana;
        this.ouro = ouro;
        this.madeira = madeira;
        this.extinta = extinta;
    }

    //Este metodo verifica se raca analisada esta extinta, para isso checando se os arraylists da raca estao vazios.
    public void verificaExtincao() {

        if (this instanceof Humanos) {
            if (this.listaConstrucoesHumanas.isEmpty() || this.listaUnidadesHumanas.isEmpty()) {
                this.extinta = true;
                System.out.println("Está raça está extinta é impossivel criar/construir novas unidades e/ou construções.");
                
            }
        }
        if (this instanceof Orcs) {
            if (this.listaConstrucoesOrcs.isEmpty() || this.listaUnidadesOrcs.isEmpty()) {
                this.extinta = true;
                System.out.println("Está raça está extinta é impossivel criar/construir novas unidades e/ou construções.");
                
            }
        }

    }

}
