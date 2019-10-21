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
public class CentroDaCidade extends Construcao {

    /**
     * COnstrutor da classe CentroDaCidade
     *
     * @param r a raça à qual o centro da cidade pertence
     * @param p a posiçao do centro da cidade no mapa
     * @param ataque o ataque do centro da cidade
     * @param alcance o alcance do ataque do centro da cidade
     * @param pontosVitais a vida do centro da cidade
     * @param imagem a representação gráfica do centro da cidade
     * @param estado representa o estado do centro da cidade(existente ou
     * destruido)
     * @param p2 neste caso nulo.
     */
    public CentroDaCidade(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    //Este metodo cria camponeses.
    public void cria() {

        //inicialmente é feita a verificação se a raça esta extinta.
        r.verificaExtincao();

        // o campones criado assume a mesma posição no mapa do centro da cidade, assim como
        //é acrescentado 1 unidade a população assim que cada campones é criado.
        //é feita conjuntamente uma verificação de recursos e capacidade da população.
        if (r.extinta == false) {
            if (r.comida >= 50 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                if (r instanceof Humanos) {
                    r.listaUnidadesHumanas.add(new Campones(2.0, 0, this.r, new Posicao(this.p.x, this.p.y), 3, 0, 50, "2561", true, 50));
                }
                if (r instanceof Orcs) {
                    r.listaUnidadesOrcs.add(new Campones(2.0, 0, this.r, new Posicao(this.p.x, this.p.y), 3, 0, 50, "25661", true, 50));
                }
                r.populacaoAtual++;
                r.comida -= 50;
                System.out.println("Campones criado!");
                System.out.println("População atual: "+r.populacaoAtual);
                System.out.println("Comida: " + this.r.comida);
                
            } else {
                if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                    System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                    System.out.println("População atual:"+r.populacaoAtual+" ----- Capacidade populacional:"+r.capacidadeDaPopulacao);
                } else {
                    System.out.println("Você não tem recursos o suficiente para construir esta unidade!");
                }
            }
        }
    }

    // metodo ataca do centro da cidade(segue a mesma lógica das unidades que realizam ataques a distancia)
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
                System.out.println("Alcance da construção: "+this.alcance+ " Distancia:" + distancia);
            }

        }
    }

}
