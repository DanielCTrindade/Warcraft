/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import static trabalho02.TipoConstrucao.CASA;
import static trabalho02.TipoConstrucao.QUARTEL;

/**
 *
 * @author danie
 */
public class Campones extends Unidade {

    /**
     * Construtor da classe Campones
     *
     * @param velocidade a velocidade do campones
     * @param armadura a armadura do campones
     * @param r a raçã à qual o campones pertence
     * @param p a posição do campones no mapa
     * @param ataque o ataque do campones
     * @param alcance o alcance do campones
     * @param pontosVitais a vida do campones
     * @param imagem a representação gráfica do campones
     * @param estado representa o estado do campones(vivo ou morto)
     * @param p2 atributo que guarda a vida inicial do campones para ser
     * utilizado posteriormente pelo metodo cura do sacerdote
     */
    public Campones(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    /**
     * Metodo constroi do campones
     *
     * @param p a posicao no mapa a ser construida a construção
     * @param tipo o tipo de construção a ser construida
     */
    public void constroi(Posicao p, TipoConstrucao tipo) {

        //inicialmente é feita a verificação se a raça esta extinta, caso esteja o campones, não podera construir.
        r.verificaExtincao();

        if (r.extinta == false) {
            //Switch que verifica o tipo de construção a ser construida assim, após isso é feita uma verificação de recursos da raça,
            //se a raça não possui recursos suficientes é vedada a construção.
            // assim que é realizada uma construção, são descontados da raça os custos envolvidos nesta construção.
            // assim como a construção é adicionada na respectiva arraylist da raça.
            switch (tipo) {
                case QUARTEL:
                    if (r.madeira >= 125) {
                        if (r instanceof Humanos) {
                            r.listaConstrucoesHumanas.add(new Quartel(this.r, new Posicao(p.x, p.y), 0, 0, 350, "segasdg", true, 350));
                        } else if (r instanceof Orcs) {
                            r.listaConstrucoesOrcs.add(new Quartel(this.r, new Posicao(p.x, p.y), 0, 0, 350, "segzxdbasdg", true, 350));
                        }
                        r.madeira -= 125;
                        System.out.println("Quartel construido!");
                        System.out.println("Madeira: "+this.r.madeira);
                        // ao construir em uma determinada posição no mapa, o campones assume a posição da construção
                        // pois precisou se deslocar ate a posiçao da construção no mapa.
                        this.p.x = p.x;
                        this.p.y = p.y;
                        System.out.println("Posicao campones X: " + this.p.x + " Y: " + this.p.y);
                    } else {
                        System.out.println("Não é possivel construir o quartel, pois a raça não tem recursos suficientes!");
                    }
                    break;
                case CASA:
                    if (r.madeira >= 30) {
                        if (r instanceof Humanos) {
                            r.listaConstrucoesHumanas.add(new Casa(this.r, new Posicao(p.x, p.y), 0, 0, 75, "155", true, 75));
                        } else if (r instanceof Orcs) {
                            r.listaConstrucoesOrcs.add(new Casa(this.r, new Posicao(p.x, p.y), 0, 0, 75, "155", true, 75));
                        }
                        this.p.x = p.x;
                        this.p.y = p.y;
                        r.capacidadeDaPopulacao += 2;
                        r.madeira -= 30;
                        System.out.println("Casa construida!Nova capacidade populacional:" + this.r.capacidadeDaPopulacao);
                        System.out.println("Madeira: "+this.r.madeira);
                        System.out.println("Posicao campones X: " + this.p.x + " Y: " + this.p.y);
                    } else {
                        System.out.println("Não é possivel construir a casa, pois a raça não tem recursos suficientes!");
                    }
                    break;
                case CENTRODECIDADE:
                    if (r.madeira >= 200) {
                        if (r instanceof Humanos) {
                            r.listaConstrucoesHumanas.add(new CentroDaCidade(this.r, new Posicao(p.x, p.y), 10, 8, 600, "dgjsg", true, 600));
                        } else if (r instanceof Orcs) {
                            r.listaConstrucoesOrcs.add(new CentroDaCidade(this.r, new Posicao(p.x, p.y), 10, 8, 600, "dgjsg", true, 600));
                        }
                        this.p.x = p.x;
                        this.p.y = p.y;
                        r.capacidadeDaPopulacao += 10;
                        r.madeira -= 200;
                        System.out.println("Centro de Cidade construido!Nova capacidade populacional:"+this.r.capacidadeDaPopulacao);
                        System.out.println("Madeira: "+this.r.madeira);
                        System.out.println("Posicao campones X: " + this.p.x + " Y: " + this.p.y);
                    } else {
                        System.out.println("Não é possivel construir o centro da cidade, pois a raça não tem recursos suficientes!");
                    }
                    break;
                case TORRE:
                    if (r.madeira >= 70) {
                        if (r instanceof Humanos) {
                            r.listaConstrucoesHumanas.add(new Torre(this.r, new Posicao(p.x, p.y), 20, 7, 200, "zskbgg", true, 200));
                        } else if (r instanceof Orcs) {
                            r.listaConstrucoesOrcs.add(new Torre(this.r, new Posicao(p.x, p.y), 20, 7, 200, "zskbgg", true, 200));
                        }
                        r.madeira -= 70;
                        this.p.x = p.x;
                        this.p.y = p.y;
                        System.out.println("Torre construida!");
                        System.out.println("Madeira: "+this.r.madeira);
                        System.out.println("Posicao campones X: " + this.p.x + " Y: " + this.p.y);

                    } else {
                        System.out.println("Não é possivel construir a torre, pois a raça não tem recursos suficientes!");
                    }
                    break;
                case TEMPLO:
                    if (r.madeira >= 250) {
                        if (r instanceof Humanos) {
                            r.listaConstrucoesHumanas.add(new Templo(this.r, new Posicao(p.x, p.y), 0, 0, 350, "sdgagr", true, 350));
                        } else if (r instanceof Orcs) {
                            r.listaConstrucoesOrcs.add(new Templo(this.r, new Posicao(p.x, p.y), 0, 0, 350, "sdgagr", true, 350));
                        }
                        this.p.x = p.x;
                        this.p.y = p.y;
                        r.madeira -= 250;
                        System.out.println("Templo construido!");
                        System.out.println("Madeira: "+this.r.madeira);
                        System.out.println("Posicao campones X: " + this.p.x + " Y: " + this.p.y);
                    } else {
                        System.out.println("Não é possivel construir o templo, pois a raça não tem recursos suficientes!");
                    }
                    break;
            }
        }

    }

    //Metodo colhe do campones
    public void colhe() {
        this.r.comida += 1;
        System.out.println("O campones colheu 1 unidade de comida. Comida da raça = " + r.comida);
    }

    //Metodo corta do campones
    public void corta() {
        this.r.madeira += 1;
        System.out.println("O campones cortou 1 unidade de madeira. Madeira da raça = " + r.madeira);
    }

    //Metodo minera do campones
    public void minera() {
        this.r.ouro += 1;
        System.out.println("O campones minerou 1 unidade de ouro. Ouro da raça = " + r.ouro);
    }

}
