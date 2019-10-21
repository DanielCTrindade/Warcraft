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
public class Templo extends Construcao {

    /**
     * Construtor da classe Templo
     *
     * @param r a raca a qual o templo pertence
     * @param p a posicao do templo no mapa
     * @param ataque o ataque do templo(neste caso inexistente)
     * @param alcance o alcance do templo(neste caso inexistente)
     * @param pontosVitais a vida do templo
     * @param imagem a representacao grafica do templo
     * @param estado representa o estado do tempo(existente ou destruido)
     * @param p2 atributo que armazena o valor inicial da vida das unidades para
     * ser utilizado pelo sacerdote no metodo cura
     */
    public Templo(Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    //Metodo que cria as unidades especificas do templo
    public void cria(TipoUnidadeTemplo t) {

        r.verificaExtincao();

        //Aqui é feita a verificacao se a raca esta extinta, 
        //assim como se a raca dispoe de recursos e capacidade populacional para criar as unidades.
        //É vedada a criacao de andarilhos espirituais pela raca humanos.
        if (r.extinta == false) {
            switch (t) {
                case SACERDOTE:
                    if (r.ouro >= 125 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            r.listaUnidadesHumanas.add(new Sacerdote(1.0, 0, this.r, new Posicao(this.p.x, this.p.y), 0, 10, 25, "2215", true, 25));
                        } else if (r instanceof Orcs) {
                            r.listaUnidadesOrcs.add(new Sacerdote(1.0, 0, this.r, new Posicao(this.p.x, this.p.y), 0, 10, 25, "2215", true, 25));
                        }
                        System.out.println("Sacerdote criado!");
                        r.populacaoAtual++;
                        r.ouro -= 125;
                        System.out.println("Ouro: " + this.r.ouro);
                        System.out.println("População atual: " + r.populacaoAtual);
                    } else {
                        if (r.populacaoAtual == r.capacidadeDaPopulacao) {
                            System.out.println("Capacidade populacional atingida!Impossível criar esta unidade.");
                            System.out.println("População atual:" + r.populacaoAtual + " ----- Capacidade populacional:" + r.capacidadeDaPopulacao);
                        } else {
                            System.out.println("Você não tem recursos suficientes para criar esta unidade!");
                        }
                    }
                    break;
                case ANDARILHOESPIRITUAL:
                    if (r.comida >= 170 && r.ouro >= 40 && r.populacaoAtual < r.capacidadeDaPopulacao) {
                        if (r instanceof Humanos) {
                            System.out.println("Humanos não podem criar unidades do tipo Andarilho Espiritual!");
                        } else if (r instanceof Orcs) {
                            r.listaUnidadesOrcs.add(new AndarilhoEspiritual(1.0, 2, this.r, new Posicao(this.p.x, this.p.y), 2, 10, 100, "sdggf", true, 10));
                            System.out.println("Andarilho espiritual criado!");
                            r.populacaoAtual++;
                            r.ouro -= 40;
                            r.comida -= 170;
                            System.out.println("Comida: " + this.r.comida + " Ouro: " + this.r.ouro);
                            System.out.println("População atual: " + r.populacaoAtual);
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
