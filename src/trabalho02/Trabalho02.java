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
public class Trabalho02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Criando duas raças.
        Humanos hi = new Humanos(3000, 3000, 3000, 3000, false);
        Orcs or = new Orcs(600, 300, 300, 3000, false);

        //Construindo construcoes humanas
        //Criando unidades humanas
        ((Campones) (hi.listaUnidadesHumanas.get(1))).constroi(new Posicao(8, 8), TipoConstrucao.QUARTEL);
        ((Quartel) hi.listaConstrucoesHumanas.get(1)).cria(TipoUnidadeQuartel.ARQUEIRO);
        ((Campones) (hi.listaUnidadesHumanas.get(1))).constroi(new Posicao(9, 9), TipoConstrucao.TEMPLO);
        ((Templo) hi.listaConstrucoesHumanas.get(2)).cria(TipoUnidadeTemplo.SACERDOTE);
        //verificando se humanos podem construir andarilhos espirituais
        ((Templo) hi.listaConstrucoesHumanas.get(2)).cria(TipoUnidadeTemplo.ANDARILHOESPIRITUAL);
        ((Quartel) hi.listaConstrucoesHumanas.get(1)).cria(TipoUnidadeQuartel.CAVALEIRO);
        ((Campones) (hi.listaUnidadesHumanas.get(1))).constroi(new Posicao(12, 12), TipoConstrucao.TORRE);
        System.out.println("----------------------------------------------------------------------------------------------");

        //trabalhando com a raca de orcs
        //construindo quartel e templo e criando unidades
        ((Campones) (or.listaUnidadesOrcs.get(0))).constroi(new Posicao(2.0, 2.0), TipoConstrucao.QUARTEL);
        ((Quartel) or.listaConstrucoesOrcs.get(1)).cria(TipoUnidadeQuartel.ARQUEIRO);
        //verificando se orcs podem criar unidades do tipo grifo
        ((Quartel) or.listaConstrucoesOrcs.get(1)).cria(TipoUnidadeQuartel.GRIFO);
        //verificando o ataque de uma unidade que realiza ataques a distancia
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaConstrucoesHumanas.get(1));
        //utilizando o metodo mover para aproximar a unidade atacante do objeto atacado.
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.NORTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.NORTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        //Atacando uma construcao
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaConstrucoesHumanas.get(1));
        ((Campones) (or.listaUnidadesOrcs.get(0))).constroi(new Posicao(2.0, 2.0), TipoConstrucao.TEMPLO);
        ((Templo) or.listaConstrucoesOrcs.get(2)).cria(TipoUnidadeTemplo.ANDARILHOESPIRITUAL);
        //Realizando ataques na unidade inimiga até eliminar ela
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(2));
        //utilizando o metodo revive do andarilho para resviver a unidade inimiga morta e adiciona-la a raça de orcs
        ((AndarilhoEspiritual) (or.listaUnidadesOrcs.get(3))).revive(hi.listaUnidadesMortas.get(0));
        //utilizando a unidade revivida(agora pertencente aos orcs para atacar uma unidade humana)
        ((Arqueiro) (or.listaUnidadesOrcs.get(4))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(4))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(4))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(4))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        System.out.println("--------------");
        //utilizando o metodo cura do sacerdote na unidade humana.Ao custo de 5 de mana.
        ((Sacerdote) (hi.listaUnidadesHumanas.get(2))).cura(hi.listaUnidadesHumanas.get(1));
        //utilizando o metodo reza do sacerdote.Acrescentando 5 de mana para a raca.
        ((Sacerdote) (hi.listaUnidadesHumanas.get(2))).reza();

        //Criando camponeses no centro da cidade orc
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        //verificando se é possivel criar mais unidades apesar de a populacao atual estar no maximo da capacidade populacional.
        ((CentroDaCidade) or.listaConstrucoesOrcs.get(0)).cria();
        ((Campones) (or.listaUnidadesOrcs.get(5))).colhe();
        ((Campones) (or.listaUnidadesOrcs.get(5))).corta();
        ((Campones) (or.listaUnidadesOrcs.get(5))).minera();
        ((Campones) (or.listaUnidadesOrcs.get(5))).constroi(new Posicao(110, 110), TipoConstrucao.CASA);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.SUL);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.SUL);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.OESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.OESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.OESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.NORTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.NORTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.NORTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).mover(Direcao.LESTE);
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        //Atacando uma unidade que possui armadura. Neste caso Arqueiro(ataque de 5) ataca Cavaleiro que possui armadura de 3.
        ((Arqueiro) (or.listaUnidadesOrcs.get(2))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Quartel) or.listaConstrucoesOrcs.get(1)).cria(TipoUnidadeQuartel.GUERREIRO);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.NORTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.NORTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.NORTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.LESTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.LESTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.LESTE);
        //Como esta unidade esta menos de 2 unidades de distancia do objeto a ser atacado o ataque sera possivel.
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(1));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.NORTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.NORTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.LESTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).mover(Direcao.LESTE);
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaUnidadesHumanas.get(0));
        //A construcao dos humanos tipo torre realiza ataque no guerreiro dos orcs
        ((Torre) hi.listaConstrucoesHumanas.get(3)).ataca(or.listaUnidadesOrcs.get(10));
        ((Torre) hi.listaConstrucoesHumanas.get(3)).ataca(or.listaUnidadesOrcs.get(10));
        ((Torre) hi.listaConstrucoesHumanas.get(3)).ataca(or.listaUnidadesOrcs.get(10));
        ((Torre) hi.listaConstrucoesHumanas.get(3)).ataca(or.listaUnidadesOrcs.get(10));
        //Guerreiro ataca a construcao torre dos humanos
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        System.out.println("COnstruçoes humanas: "+hi.listaConstrucoesHumanas.toString());
        //aqui o guerreiro consegue destruir a torre humana
        ((Guerreiro) (or.listaUnidadesOrcs.get(10))).ataca(hi.listaConstrucoesHumanas.get(3));
        
        
        
        System.out.println("Populacao: " + hi.populacaoAtual);
//        Quando a raça não tiver nenhuma unidade ou construção, uma mensagem deverá ser
//         impressa na tela e o atributo “extinta”da raça deverá ser marcado como verdadeiro.
//         A partir desse momento, criar qualquer tipo de unidade deverá ser impossível.
        ((Quartel) hi.listaConstrucoesHumanas.get(1)).cria(TipoUnidadeQuartel.CAVALEIRO);


    }

}
