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
public class Torre extends Construcao {

    /**
     * Construtor da classe Torre
     *
     * @param r a raca a qual a torre pertence
     * @param p a posicao da torre no mapa
     * @param ataque o ataque da torre
     * @param alcance o alcance da torre para ataques a distancia
     * @param pontosVitais a vida da torre
     * @param imagem a representacao grafica da torre
     * @param estado representa o estado da torre(existente ou destruida)
     * @param p2 atributo que armazena o valor inicial da vida das unidades para
     * ser utilizado pelo sacerdote no metodo cura.
     */
    public Torre(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    //Neste metodo é sobrescrito o metodo ataca da classe pai, pois a torre realiza ataques a distancia
    //Este codigo segue a mesma logica do codigo comentado na classe AndarilhoEspiritual
    @Override
    public void ataca(Objeto o) {

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
                        if (r instanceof Humanos) {
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        } else {
                            o.r.listaUnidadesHumanas.remove((Unidade) o);
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
                        if (r instanceof Humanos) {
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        } else {
                            o.r.listaUnidadesHumanas.remove((Unidade) o);
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
                System.out.println("Alcance da construção: "+this.alcance+ " Distancia:" + distancia);
            }

        }
    }

}
