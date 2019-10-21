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
public class Quartel extends Construcao {

    /**
     * Construtor da classe Quartel
     *
     * @param r a raca a qual o quartel pertence
     * @param p a posicao do quartel no mapa
     * @param ataque o ataque do quartel(inexistente neste caso)
     * @param alcance o alcance do quartel(inexistente neste caso)
     * @param pontosVitais a vida do quartel
     * @param imagem a representacao grafica do quartel
     * @param estado representa o estado do quartel(existente ou destruido)
     * @param p2
     */
    public Quartel(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    //Neste metodo o quartel cria unidades para as racas 
    public void cria(TipoUnidadeQuartel t) {

        r.verificaExtincao();

        //Aqui são geradas as unidades, mas antes é feita uma verificacao de recursos e capacidade populacional da raca 
        //a unidade é gerada na mesma posicao do quartel e assim que gerada é incrementada a variavel populacaoAtual.
        //A raca Orc nao podendo criar unidades do tipo Grifo.
        if (r.extinta == false) {

            switch (t) {
                case CAVALEIRO:
                    if (r.comida >= 70 && r.ouro >= 80 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            r.listaUnidadesHumanas.add(new Cavaleiro(4.0, 3, this.r, new Posicao(this.p.x, this.p.y), 12, 0, 180, "gsg", true, 180));
                        }
                        if (r instanceof Orcs) {
                            r.listaUnidadesOrcs.add(new Cavaleiro(4.0, 3, this.r, new Posicao(this.p.x, this.p.y), 12, 0, 180, "gsasfg", true, 180));
                        }
                        r.populacaoAtual++;
                        r.comida -= 70;
                        r.ouro -= 80;
                        System.out.println("Cavaleiro Criado!!!");
                        System.out.println("População atual: " + r.populacaoAtual);
                        System.out.println("Comida: " + this.r.comida + " Ouro: " + this.r.ouro);
                    } else {
                        if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                            System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                            System.out.println("População atual:" + r.populacaoAtual + " ----- Capacidade populacional:" + r.capacidadeDaPopulacao);
                        } else {
                            System.out.println("Você não tem recursos suficientes para criar esta unidade!");
                        }
                    }
                    break;
                case GUERREIRO:
                    if (r.comida >= 35 && r.ouro >= 15 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            r.listaUnidadesHumanas.add(new Guerreiro(1.8, 2, this.r, new Posicao(this.p.x, this.p.y), 13, 0, 160, "dksgds", true, 160));
                        }
                        if (r instanceof Orcs) {
                            r.listaUnidadesOrcs.add(new Guerreiro(1.8, 2, this.r, new Posicao(this.p.x, this.p.y), 13, 0, 160, "dksgds", true, 160));
                        }
                        r.populacaoAtual++;
                        r.comida -= 35;
                        r.ouro -= 15;
                        System.out.println("Guerreiro criado!");
                        System.out.println("População atual: " + r.populacaoAtual);
                        System.out.println("Comida: " + this.r.comida + " Ouro: " + this.r.ouro);
                    } else {
                        if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                            System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                            System.out.println("População atual:" + r.populacaoAtual + " ----- Capacidade populacional:" + r.capacidadeDaPopulacao);
                        } else {
                            System.out.println("Você não tem recursos suficientes para criar esta unidade!");
                        }
                    }
                    break;
                case ARQUEIRO:
                    if (r.comida >= 40 && r.ouro >= 20 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            r.listaUnidadesHumanas.add(new Arqueiro(2.0, 0, this.r, new Posicao(this.p.x, this.p.y), 5, 7, 45, "sdgg", true, 45));
                        }
                        if (r instanceof Orcs) {
                            r.listaUnidadesOrcs.add(new Arqueiro(2.0, 0, this.r, new Posicao(this.p.x, this.p.y), 5, 7, 45, "sdgg", true, 45));
                        }
                        r.populacaoAtual++;
                        r.comida -= 40;
                        r.ouro -= 20;
                        System.out.println("Arqueiro criado!!");
                        System.out.println("População atual: " + r.populacaoAtual);
                        System.out.println("Comida: " + this.r.comida + " Ouro: " + this.r.ouro);

                    } else {
                        if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                            System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                            System.out.println("População atual:" + r.populacaoAtual + " ----- Capacidade populacional:" + r.capacidadeDaPopulacao);
                        } else {
                            System.out.println("Você não tem recursos suficientes para criar esta unidade!");
                        }
                    }
                    break;
                case GRIFO:
                    if (r.comida >= 200 && r.ouro >= 40 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            r.listaUnidadesHumanas.add(new Grifo(4.0, 7, this.r, new Posicao(this.p.x, this.p.y), 20, 7, 300, "akjfgdgs", true, 300));
                            r.comida -= 200;
                            r.ouro -= 40;
                            r.populacaoAtual++;
                            System.out.println("Grifo criado!");
                            System.out.println("População atual: " + r.populacaoAtual);
                            System.out.println("Comida: " + this.r.comida + " Ouro: " + this.r.ouro);
                        }
                        if (r instanceof Orcs) {
                            System.out.println("Orcs não podem criar unidades do tipo Grifo!");
                        }
                    } else {
                        if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                            System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                            System.out.println("População atual:" + r.populacaoAtual + " ----- Capacidade populacional:" + r.capacidadeDaPopulacao);
                        } else {
                            System.out.println("Você não tem recursos suficientes para criar esta unidade!");
                        }
                    }
                    break;
            }
        }
    }

    @Override
    public void ataca(Objeto o) {
        System.out.println("Esta construção não realiza ataques!");
    }

}
