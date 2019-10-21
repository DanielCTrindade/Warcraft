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
public class Grifo extends Unidade {
    
    /**
     * Construtor da classe Grifo
     * @param velocidade a velocidade do grifo
     * @param armadura a armadura do grifo
     * @param r a raca do grifo
     * @param p a posicao do grifo no mapa
     * @param ataque o ataque do grifo
     * @param alcance o alcance do grifo para ataques a distancia
     * @param pontosVitais a vida do grifo
     * @param imagem a representaçao grafica do grifo
     * @param estado representa o estado do grifo(vivo ou morto)
     * @param p2 atributo que armazena a vida inicial do grifo para posteriormente ser utilizado pelo sacerdote no metodo cura.
     */
    public Grifo(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

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
