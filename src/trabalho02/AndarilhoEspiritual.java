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
public class AndarilhoEspiritual extends Unidade {

    /**
     * Construtor da classe
     *
     * @param velocidade a velocidade do Andarilho Espiritual
     * @param armadura a armadura do Andarilho Espiritual
     * @param r a raça à qual o andarilho pertence.
     * @param p a posicao do andarilho no mapa.
     * @param ataque o ataque do andarilho
     * @param alcance o alcance do ataque e das caracteristicas especiais desta
     * unidade
     * @param pontosVitais a vida do andarilho
     * @param imagem a imagem do andarilho
     * @param estado o estado vivo ou morto
     * @param p2 utilizada para armazenar a vida inicial da unidade para
     * posteriormente poder ser utilizado pelo sacerdote no metodo cura.
     */
    public AndarilhoEspiritual(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    /**
     * Metodo revive aonde o andarilho seleciona uma unidade amiga ou inimiga e
     * adiciona ela à raça de orcs.
     *
     * @param o a unidade a ser revivida
     */
    public void revive(Objeto o) {

        //Aqui é realizado o  calculo da distancia entre as duas unidades
        double distanciaX = this.p.x - o.p.x;
        double distanciaY = this.p.y - o.p.y;
        //modulo do valor encontrado em distanciax, foi feito modulo, pois poderia dar valor negativo nas operaçoes e não existe 
        //distancia negativa.
        double distanciaX2 = Math.abs(distanciaX);
        double distanciaY2 = Math.abs(distanciaY);
        double distancia = Math.sqrt((Math.pow(distanciaX2, 2) + (Math.pow(distanciaY2, 2))));

        // verificando se esta dentro da distancia aceitavel tendo em vista o alcance da unidade
        //Verificando tambem se a raça tem recursos em mana suficientes para a operaçao
        if ((distancia <= this.alcance) && r.mana >= 5 && o instanceof Unidade) {
            if (o.pontosVitais <= 0) {
                o.r = this.r;
                r.listaUnidadesOrcs.add((Unidade) o);
                o.r.listaUnidadesMortas.remove((Unidade) o);
                o.pontosVitais = o.p2;
                r.populacaoAtual++;
                r.mana -=5;
                System.out.println("Andarilho espiritual reviveu esta unidade!!");
                System.out.println("População atual:"+r.populacaoAtual+" ----- Capacidade populacional:"+r.capacidadeDaPopulacao);
            }
        } else {
            if (r.mana < 5) {
                System.out.println("A raça não possui mana o suficiente para reviver esta unidade!");
            } if(this.alcance<distancia){
                System.out.println("As unidades estão distantes entre si, impossivel reviver esta unidade!");
                System.out.println("Alcance da unidade: "+this.alcance+ " Distancia:" + distancia);
            }else{
                System.out.println("Impossivel converter este objeto!");
            }
        }
    }

    /**
     * Metodo ataca do Andarilho Espiritual
     *
     * @param o o objeto a ser atacado(podendo ser unidade ou construção) foi
     * feito o override no Andarilho, pois ele é uma das unidades que abrange
     * alcance em suas caracteristicas.
     */
    @Override
    public void ataca(Objeto o) {

        double distanciaX = this.p.x - o.p.x;
        double distanciaY = this.p.y - o.p.y;
        double distanciaX2 = Math.abs(distanciaX);
        double distanciaY2 = Math.abs(distanciaY);
        double distancia = Math.sqrt((Math.pow(distanciaX2, 2) + (Math.pow(distanciaY2, 2))));

        // aqui é feita a verificação se o objeto atacado esta dentro do alcance do andarilho, assim como se o objeto atacado esta vivo.
        if (distancia <= this.alcance && (o.estado = !false)) {
            if (o instanceof Unidade) {
                //verificando se a unidade atacada possui armadura
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
                            //caso seja humana a unidade atacada, aqui é feita a remoçao dela do arraylist
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        } else {
                            //caso seja orc a unidade atacada, aqui é feita a remoçao dela do arraylist
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
                //aqui é feito o ataque de construções
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
                // aqui é demonstrado a distancia entre os objetos.
                System.out.println("Impossivel realizar este ataque, pois os objetos estão distantes entre si!");
                System.out.println("Posição Objeto Atacante X: " + this.p.x + " Y: " + this.p.y + "\nPosição Objeto atacado X: " + o.p.x + " Y: " + o.p.y);
                System.out.println("Alcance da unidade: "+this.alcance+ " Distancia:" + distancia);
            }
        }
    }
}
