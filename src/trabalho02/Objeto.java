package trabalho02;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniel.010191
 */
public abstract class Objeto {

    protected Raca r;
    protected Posicao p;
    protected int ataque;
    protected int alcance;
    protected int pontosVitais;
    protected String imagem;
    protected boolean estado;
    protected int p2;

    /**
     * Consrutor da classe abstrata Objeto Objeto que pode ser unidade ou
     * construcao
     *
     * @param r a raça do objeto
     * @param p a posicao do objeto no mapa
     * @param ataque o ataque do objeto
     * @param alcance o alcance do objeto(para ataques a distancia)
     * @param pontosVitais a vida do objeto
     * @param imagem a representacao grafica do objeto
     * @param estado representa o estado do objeto (vivo ou morto para unidades
     * e existente ou destruida para construcoes)
     * @param p2 atributo que armazena o valor inicial da vida para ser
     * utilizado pelo sacerdote no metodo cura das unidades
     */
    public Objeto(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        this.r = r;
        this.p = p;
        this.ataque = ataque;
        this.alcance = alcance;
        this.pontosVitais = pontosVitais;
        this.imagem = imagem;
        this.estado = estado;
        this.p2 = p2;
    }

    /**
     * Metodo que serve como base de metodo de ataque para unidades e
     * construçoes que nao realizam ataques a distancia.
     *
     * @param o o objeto a ser atacado.
     */
    public void ataca(Objeto o) {

        double distanciaX = this.p.x - o.p.x;
        double distanciaY = this.p.y - o.p.y;
        double distanciaX2 = Math.abs(distanciaX);
        double distanciaY2 = Math.abs(distanciaY);

        // aqui é feita verificação se as unidades estao a no maximo 2 de distancia uma da outra
        // caso contrario o ataque não é realizado
        if ((distanciaX2 >= 0 && distanciaX2 <= 2) && (distanciaY2 >= 0 && distanciaY2 <= 2) && (o.estado != false)) {
            if (o instanceof Unidade) {
                //Unidades que nao realizam ataques a distancia nao conseguem atacar unidades do tipo grifo.
                if (o instanceof Grifo) {
                    System.out.println("Esta unidade não ataca grifos!");
                }
                if (((Unidade) o).armadura > 0) {
                    int resto = this.ataque - ((Unidade) o).armadura;
                    ((Unidade) o).pontosVitais -= resto;
                    ((Unidade) o).armadura -= ataque;
                    System.out.println("Pontos Vitais Unidade atacada: " + ((Unidade) o).pontosVitais);
                    if (((Unidade) o).pontosVitais <= 0) {
                        System.out.println("Unidade morta!");
                        ((Unidade) o).estado = false;
                        o.r.listaUnidadesMortas.add((Unidade) o);
                        o.r.populacaoAtual--;
                        if (r instanceof Humanos) {
                            o.r.listaUnidadesOrcs.remove((Unidade) o);
                        } else {
                            o.r.listaUnidadesHumanas.remove((Unidade) o);
                        }
                    } else {
                        System.out.println("Pontos Vitais Unidade atacada: " + ((Unidade) o).pontosVitais);
                    }
                } else {
                    ((Unidade) o).pontosVitais -= this.ataque;

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
                    } else {
                        System.out.println("Pontos Vitais Unidade atacada: " + ((Unidade) o).pontosVitais);
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
                    if (o.r instanceof Humanos) {
                        o.r.listaConstrucoesHumanas.remove((Construcao) o);
                    } else {
                        o.r.listaConstrucoesOrcs.remove((Construcao) o);
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
            }
        }

    }

}
