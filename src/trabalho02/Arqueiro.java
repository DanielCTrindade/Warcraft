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
public class Arqueiro extends Unidade {

    /**
     * Construtor da classe arqueiro
     *
     * @param velocidade a velocidade do arqueiro
     * @param armadura a armadura do arqueiro
     * @param r a raça do arqueiro
     * @param p a posiçao do arqueiro no mapa
     * @param ataque o ataque do arqueiro
     * @param alcance o alcance do arqueiro
     * @param pontosVitais a vida do arqueiro
     * @param imagem a representação gráfica do arqueiro
     * @param estado representa um boolean que diz se o arqueiro esta vivo ou
     * morto
     * @param p2 guarda a vida inteira do arqueiro para ser utilizado pelo
     * sacerdote no metodo cura
     */
    public Arqueiro(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    /**
     * Metodo ataca do arqueiro precisou ser sobrescrito, pois ele é uma das
     * unidades que realiza ataque a distancia
     *
     * @param o o objeto a ser atacado
     */
    @Override
    public void ataca(Objeto o) {

        // este codigo segue a mesma logica do comentado no andarilho espiritual
        double distanciaX = this.p.x - o.p.x;
        double distanciaY = this.p.y - o.p.y;
        double distanciaX2 = Math.abs(distanciaX);
        double distanciaY2 = Math.abs(distanciaY);
        double distancia = Math.sqrt((Math.pow(distanciaX2, 2) + (Math.pow(distanciaY2, 2))));

        if (distancia <= this.alcance && (o.estado = !false)) {
            if (o instanceof Unidade) {
                if (((Unidade) o).armadura > 0) {
                    int resto = this.ataque - ((Unidade) o).armadura;
                    ((Unidade) o).pontosVitais -= resto;
                    ((Unidade) o).armadura -= ataque;
                    System.out.println("Pontos Vitais Unidade atacada: " + ((Unidade) o).pontosVitais);
                    if (((Unidade) o).pontosVitais <= 0) {
                        System.out.println("Unidade morta!");
                        ((Unidade) o).estado = false;
                        o.r.populacaoAtual--;
                        o.r.listaUnidadesMortas.add((Unidade) o);
                        if (o.r instanceof Humanos) {
                            o.r.listaUnidadesHumanas.remove((Unidade) o);
                        } else {
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        }
                    }
                } else {
                    ((Unidade) o).pontosVitais -= this.ataque;
                    System.out.println("Pontos Vitais Unidade atacada: " + ((Unidade) o).pontosVitais);
                    if (((Unidade) o).pontosVitais <= 0) {
                        System.out.println("Unidade morta!");
                        ((Unidade) o).estado = false;
                        o.r.populacaoAtual--;
                        o.r.listaUnidadesMortas.add((Unidade) o);
                        if (o.r instanceof Humanos) {
                            o.r.listaUnidadesHumanas.remove((Unidade) o);
                        } else {
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        }
                    }
                }
            } else {
                o.pontosVitais -= this.ataque;
                if (o.pontosVitais <= 0) {
                    if (((Construcao) o) instanceof Casa) {
                        o.r.capacidadeDaPopulacao -= 2;
                    }
                    if (((Construcao) o) instanceof CentroDaCidade) {
                        o.r.capacidadeDaPopulacao -= 10;
                    }
                    System.out.println("Construção destruida!");
                    o.estado = false;
                    o.r.populacaoAtual--;
                    if (r instanceof Humanos) {
                        o.r.listaConstrucoesOrcs.remove((Construcao) o);
                    } else {
                        o.r.listaConstrucoesHumanas.remove((Construcao) o);
                    }
                } else {
                    System.out.println("Pontos Vitais da construção atacada: " + o.pontosVitais);
                }
            }
        } else {
            if (o.estado == false) {
                System.out.println("Ataque impossivel! Objeto já está morto/destruido!");
            } else {
                System.out.println("Impossivel realizar este ataque, pois os objetos estão distantes entre si!");
                System.out.println("Posição Objeto Atacante X: " + this.p.x + " Y: " + this.p.y + "\nPosição Objeto atacado X: " + o.p.x + " Y: " + o.p.y);
                System.out.println("Alcance da unidade: " + this.alcance + " Distancia:" + distancia);
            }

        }
    }

}
