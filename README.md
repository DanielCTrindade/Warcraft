# Warcraft
Especificação do projeto 2
Programação Orientada a Objetos I

1) Suponha que você está programando um jogo de estratégia estilo Warcraft III. No jogo, existem
diversos tipos de objetos (divididos entre unidades e construções). Seu objetivo é modelar e
programar as classes descritas abaixo usando orientação a objetos. Não é necessário criar uma
interface de interação com o usuário (menus), mas todas funcionalidades deverão poder ser testadas
diretamente na main, ou criando métodos (na classe principal) que testem as diferentes
funcionalidades especificadas. 
O mais importante é refletir sobre a modelagem do problema e fazer
bom uso de conceitos de orientação a objetos em Java.
Todas unidades e construções deverão ter os seguintes atributos:

• Posição x e y (referente à posição da unidade ou das construções no mapa). As unidades
podem ter sua posição alterada através do método mover, no entanto as construções não
podem ter suas posições modificadas depois de sua construção. As posições poderão assumir
valores de (0, 0) até (+infinito, +infinito), onde infinito é o valor máximo de representação
usado pelo tipo de dado escolhido. Ou seja, o mapa é infinito.
• Imagem: não precisa guardar uma imagem, apenas uma String que guardará um nome
fictício de um arquivo de imagem.
• Custo: quanto custa para construir esse objeto. O custo pode ser em unidades de comida,
madeira, ouro e mana.
• Estado: vivo ou morto (para construções considere existente ou destruída).
• Pontos de vida: indica quantos pontos de dano o objeto pode receber antes de ser marcado
como morto.
Outros atributos de alguns objetos (ver tabelas):
• Alcance: para unidades como arqueiro que atacam a distância. Essas unidades podem atacar
no máximo até essa distância. Lembre-se que para saber a distância entre dois objetos o1 e o2
em um mapa 2D, temos que calcular a hipotenusa: distância = sqrt((x1-x2)2+(y1-y2)2)
• Armadura: um número de pontos de danos que é removido de cada ataque feito à unidade.
Se a unidade atacada tem 200 pontos de vida, e 2 pontos de armadura e a unidade atacante
tiver um ataque de 4; após o ataque a unidade atacada terá 198 pontos de vida.
• Unidades que podem se mover terão o atributo velocidade: indica a velocidade com a qual a
unidade pode se mover (double), usada pelo método mover.
• atacar(Objeto unidadeAtacada): retira dos pontos vitais do objeto atacado o número de
pontos de ataque do objeto atacante, menos o número de pontos da armadura do objeto
atacado (caso o objeto tenha armadura). Em caso de objetos atacantes sem o atributo
alcance, o objeto atacado somente poderá sofrer o ataque se estiver à 2 unidades de distância
do objeto atacante (dica: pense em sobrescrita de métodos). Apenas objetos com ataque
diferente de zero deverão ter esse método.
Todas unidades deverão ter os seguintes métodos:
• mover(String direção): modifica a posição da unidade, adicionando a velocidade da unidade
à sua posição. Exemplo: se a posição atual é (10, 20) (ou seja, x=10 e y=20), e a direção é
“Norte”, e a velocidade da unidade é 2 (por exemplo no caso do camponês), sua posição
deve ser alterada para (10, 22), indicando que a unidade andou duas unidades para cima no
mapa. Considere que x representa o eixo leste-oeste e y representa o eixo norte-sul.
Características das raças:
• Cada raça pode ter uma certa quantidade inicial de comida, madeira, mana e ouro, que são
gastos a medida que a raça cria objetos e recuperados através dos métodos dos objetos
camponeses.
• Cada raça deverá manter um array de unidades e um array de construções que estão “vivas”.
• Cada raça deve começar com alguns camponeses e um centro da cidade.
• Quando a raça não tiver nenhuma unidade ou construção, uma mensagem deverá ser
impressa na tela e o atributo “extinta” da raça deverá ser marcado como verdadeiro. A partir
desse momento, criar qualquer tipo de unidade deverá ser impossível.
• As raças que deverão ser consideradas são: humanos e orcs.
• Cada raça tem um atributo que representa a população atual, que nunca pode ser maior que a
capacidade da população (dado pelas casas e centros de cidade, ver descrição adiante).
Tabela de unidades a serem consideradas:
Tipo Pontos vitais
Ataque Custo Alcance Armadura Velocidade
Camponeses 50 3 50C 0 0 2.0
Guerreiro 160 13 35C, 15O 0 2 1.8
Cavaleiro 180 12 70C, 80O 0 3 4.0
Arqueiro 45 5 40C, 20O 7 0 2.0
Sacerdote 25 0 125O 10 0 1.0
Andarilho
Espiritual
100 2 170C, 40O 10 2 1.0
Grifo 300 20 200C, 40O 7 7 4.0
*C indica comida, O indica ouro e M indica madeira.
Características especiais de algumas unidades:
• Sacerdotes possuem um método cura(Objeto objeto) que cura instantaneamente uma outra
unidade (com custo de 5 Mana). Além disso, sacerdotes possuem um método reza() que gera
5 unidades de mana para a raça.
• Andarilhos espirituais possuem um método revive(Objeto objeto) que revive uma unidade
morta (amiga ou inimiga) que esteja no seu alcance (custo de 5 Mana).
• O ataque da unidade Grifo danifica a unidade atacada, mas também todas unidades a uma
distância de 3 metros. Além disso, somente unidades com ataque a distância poderão atacar
unidades do tipo Grifo.
• Camponeses possuem um método:
◦ constroi(Posição p, String tipoConstrucao) que cria uma construção do tipo desejado.
◦ colhe() que gera 1 unidade de comida para a raça
◦ corta() que gera 1 unidade de madeira para a raça
◦ mineira() que gera 1 unidade de ouro para a raça
• Algumas construções têm o atributo ataque: número de pontos de dano que a unidade pode
fazer.
Tabela de construções a serem consideradas:
Tipo Pontos vitais Ataque Custo Alcance Pode criar
Casa 75 30M 0
Centro da cidade 600 10 200M 8 Camponês
Templo 350 250M 0 Sacerdote,
Andarilho Espiritual
Quartel 350 0 125M 0 Guerreiro, Cavaleiro,
Arqueiro, Grifo
Torre 200 20 70M 7
Características especiais de algumas construções:
• Cada casa permite duas unidades de capacidade de população.
• Cada centro da cidade permite 10 unidades de capacidade de população.
• Algumas construções têm o método cria() que gera uma unidade nova do tipo indicado na
tabela das construções. A unidade criada é colocada na mesma posição da construção.
Características especiais das raças:
• Apenas orcs podem gerar unidades do tipo Andarilho Espiritual
• Apenas humanos podem gerar unidades do tipo Grifo
