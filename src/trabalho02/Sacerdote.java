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
public class Sacerdote extends Unidade {
    
    /**
     * Construtor da classe Sacerdote
     * @param velocidade a velocidade do sacerdote
     * @param armadura a armadura da sacerdote
     * @param r a raca a qual o sacerdote pertence
     * @param p a posicao do sacerdote no mapa
     * @param ataque o ataque do sacerdote(neste caso nulo).
     * @param alcance o alcance do sacerdote 
     * @param pontosVitais a vida do sacerdote
     * @param imagem a representacao grafica do sacerdote
     * @param estado representa o estado do sacerdote(vivo ou morto)
     * @param p2 atributo que armazena o valor inicial da vida para posteriormente ser utilizado pelo sacerdote no metodo cura
     */
    public Sacerdote(double velocidade, int armadura, Raca r, Posicao p, int ataque, int alcance, int pontosVitais, String imagem, boolean estado, int p2) {
        super(velocidade, armadura, r, p, ataque, alcance, pontosVitais, imagem, estado, p2);
    }

    /**
     * Metodo cura do sacerdote
     * @param o a unidade a ser curada
     */
    public void cura(Objeto o) {

        double distanciaX = this.p.x - o.p.x;
        double distanciaY = this.p.y - o.p.y;
        double distanciaX2 = Math.abs(distanciaX);
        double distanciaY2 = Math.abs(distanciaY);
        double distancia = Math.sqrt((Math.pow(distanciaX2, 2) + (Math.pow(distanciaY2, 2))));
        
        //Aqui é feita a verificacao se a unidade a ser curada esta ao alcance do sacerdote,
        //assim como se a raça tem mana o suficiente para a realizacao da cura
        if ((distancia<=alcance && r.mana >= 5) && (o instanceof Unidade)){
            o.pontosVitais = o.p2;
            r.mana -= 5;
            System.out.println("O sacerdote curou esta unidade. Pontos Vitais = "+o.pontosVitais);
            System.out.println("Mana: "+r.mana);
        }else{
            if(o instanceof Construcao){
                System.out.println("Operação Impossivel!!");
            }
            if(r.mana<5){
                System.out.println("A raça não possui Mana o suficiente para o sacerdote realizar cura.");
            }else{
                System.out.println("As unidades estão distantes entre si, impossivel realizar a cura.");
                System.out.println("Alcance da unidade: "+this.alcance+ " Distancia:" + distancia);
            }
            
        }
    }
    
    //Este metodo gera 5 unidades de mana para a raca
    public void reza() {
        r.mana += 5;
        System.out.println("Reza do Sacerdote gerou 5 unidades de Mana para a raça. Mana: " + r.mana);
    }

    @Override
    public void ataca(Objeto o) {
        System.out.println("Esta unidade não possui ataque!");
    }
}
