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
abstract public class Unidade extends Objeto {

    protected double velocidade;
    protected int armadura;

    /**
     * Construtor da classe abstrata Unidade Esta classe serve de base para
     * todas as unidades que serao criadas
     *
     * @param velocidade a velocidade da unidade a ser criada
     * @param armadura a armadura da unidade a ser criada
     * @param r a raca a qual a unidade a ser criada pertence
     * @param p a posicao no mapa da unidade criada
     * @param ataque o ataque da unidade criada
     * @param alcance o alcance da unidade criada
     * @param pontosVitais a vida da unidade criada
     * @param imagem a representacao grafica da unidade criada
     * @param estado o estado da unidade criada (viva ou morta)
     * @param p2 este atributo armazena o valor inicial da vida das unidades
     * para posteriormente ser utlizado pelo sacerdote no metodo cura
     */
    public Unidade(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
        this.velocidade = velocidade;
        this.armadura = armadura;
    }

    /**
     * Metodo mover da classe abstrata Unidade este metodo é utilizado por todas
     * as unidades, sem a necessidade de sobrescrita em nenhuma das classes
     * filha.
     *
     * @param direcao a direcao a ser realizado o movimento
     */
    public void mover(Direcao direcao) {

        //Aqui é realizado um switch verificando qual foi a direcao de movimento escolhida
        //Caso a opcao seja Leste ou norte é somente somada a posicao atual no eixo correspondente com a velocidade da unidade
        //Caso a opcao seja Oeste ou Sul necessario que ocorra uma verificacao se a unidade nao ira para posicoes negativas no mapa.
        switch (direcao) {
            case LESTE:
                p.x += velocidade;
                System.out.println("Nova posicao em X: " + p.x);
                break;
            case OESTE: {
                double diferenca = p.x - velocidade;
                if (diferenca >= 0) {
                    p.x -= velocidade;
                    System.out.println("Nova posicao em X: " + p.x);
                } else {
                    p.x = 0.0;
                    System.out.println("Nova posicao em X: " + p.x);
                }
                break;
            }
            case NORTE:
                p.y += this.velocidade;
                System.out.println("Nova posição em Y: " + p.y);
                break;
            case SUL: {
                double diferenca = p.y - velocidade;
                if (diferenca >= 0) {
                    p.y -= velocidade;
                    System.out.println("Nova posição em Y: " + p.y);
                } else {
                    p.y = 0.0;
                    System.out.println("Nova posição em Y: " + p.y);
                }
                break;
            }
            default:
                break;
        }
    }
}
