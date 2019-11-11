# TrabalhoQuiz
Trabalho
Objetivo

	O objetivo deste trabalho é desenvolver um jogo de perguntas e respostas com interface gráfica.

Descrição do Trabalho

O jogo deve permitir uma batalha de 2 jogadores.
Os jogadores escolhem os personagens que já estarão cadastrados no sistema.
Deve-se definir uma política para decidir quem começará o jogo.  
O próximo jogador só começa a jogar se o outro errar.
Se o jogador errar, o tempo de vida é reduzido.
Novos atributos e novas classes podem ser adicionados conforme a necessidade.  
Um nome criativo para o jogo deve ser escolhido e mostrado na tela inicial.
Todas as situações de exceção devem ser tratadas. Exemplo: não é permitido começar uma partida sem os personagens, não é permitido ter tempo de vida negativo,... Faça todo o tratamento necessário.
Os erros de tipos também devem ser tratados. Exemplo: o atributo deve receber um inteiro e o usuário digita uma string, deve-se fazer o tratamento dessa exceção.
Use polimorfismo sempre que possível. Um bom teste para verificar o uso correto do polimorfismo em seu projeto é imaginar a inclusão de um novo tipo ao sistema, as alterações no código devem ser mínimas.
Faça comentários no formato JavaDoc para todas as classes e todos os métodos públicos. Gere uma documentação em .pdf usando este utilitário.
Para cada classe, deve-se obedecer as seguintes orientações:
• Atributos: todos devem ser privados.
• Método construtor que inicializa os atributos necessários através de parâmetros.
• Métodos get e set para obter e modificar atributos, quando necessário.
Valide data e telefone para o formato padrão. Exemplo: data: dd/mm/aaaa, telefone: (xx) xxxxx-xxxx.
O sistema deve ser claro para qualquer usuário que o utilizar.

I - Classes essenciais
Personagem
Cada  personagem tem um nome, que será utilizado para referenciá-lo durante o jogo e um tempo de vida que inicia em 100%. 
Pergunta
Cada pergunta tem um enunciado e uma lista de alternativas.
Alternativa
Cada alternativa tem um enunciado e um status (true para alternativa correta e false para incorreta.)
Jogador
Cada jogador tem um nome, apelido, email, telefone e recompensa.

II - Elementos visuais e interativos (use a criatividade)

Tela Inicial
Composta por um botão para inicializar o jogo.
Um item de menu com informações dos desenvolvedores.
 Um item de menu com a explicação do jogo.
Tela de Cadastro de Jogador
Podem ser cadastrados somente 2 jogadores por vez.
Os atributos mínimos já foram especificados no item I.
Tela de Escolha de Personagem 
Essa janela apresentará os personagens previamente cadastrados.
No mínimo 5 personagens devem ser cadastrados. 
Cada jogador pode escolher apenas um deles.  
Quando um personagem é escolhido, não pode aparecer como opção para o outro jogador.
Tela da Partida
Deve apresentar os personagens escolhidos e suas respectivas barras de vida. 
Abaixo, deve ter o enunciado em uma caixa de texto e as respostas da rodada em botões.
Quando escolhida uma resposta, uma caixa de diálogo deve ser acionada perguntando se tem certeza da resposta.
Se o jogador escolher não, volta para a tela anterior.
Se ele escolher sim e a resposta estiver correta:
Exibe uma mensagem parabenizando-o. 
O jogador recebe moedas de recompensa.
Exibe o conteúdo da pergunta seguinte.
Se ele escolher sim e a resposta estiver errada:
 A tela de erro é acionada.
Reduz a vida do personagem em 5%.
Exibe o conteúdo da pergunta seguinte se o jogo não terminar.
Deve ter um botão de parar. Mas para isso, os dois jogadores devem estar de acordo. Se o outro jogador não estiver, 15% do tempo de vida do personagem do jogador solicitante é repassado para o personagem do outro jogador. Só depois verifica quem é o vencedor (quem tem mais tempo de vida).   
O jogador pode converter suas moedas em tempo de vida para seu personagem. 
50 moedas equivalem a 5% de vida do personagem. 
O jogo termina quando a vida de um dos personagens é zerada.
Tela de Erro de Resposta: 
Acionada quando o jogador errar uma pergunta. 
Deve conter o enunciado e seu gabarito. 
Tela de Pontuação: 
Após o término da partida, apresentar a pontuação final do jogador (tempo de vida do personagem), que, considerando ser um jogo educativo, não pode ser abaixo de zero. Deve apresentar um  botão para voltar à tela inicial. 

 Definição do arquivo de Perguntas e Respostas

Para inserção das perguntas e respostas no jogo, um arquivo CSV deve ser salvo no diretório principal com o nome  “perguntas.csv”. 
Cada linha do arquivo tem uma pergunta, as alternativas (mínimo 4) e para cada alternativa o seu status (true/false). 
O caractere separador entre a questão e as alternativas deve ser a vírgula (,). 
O caractere separador entre a alternativa e o status deve ser sinal de subtração (-). 
 Exemplo do formato do arquivo:
PERGUNTA 1, ALT1-true,ALT2-false,ALT3-false,ALT4-false
PERGUNTA 2, ALT1-false,ALT2-false,ALT3-true,ALT4-false
PERGUNTA 3, ALT1-false,ALT2-false,ALT3-false,ALT4-true

O arquivo deve possuir codificação UTF-8 para leitura dos acentos e pontuação de maneira adequada.
O arquivo deve ter no mínimo 20 perguntas relacionadas a Programação Orientada à Objetos.
Deixe o código flexível para adição de novas perguntas.

Sistema de Recompensas

Cada pergunta deve valer uma recompensa que deve ser melhorada a cada pergunta.
Defina um cálculo para a melhora dessa recompensa.
 Exemplo: primeira pergunta valendo  X moedas. 
                                                 segunda pergunta valendo  X*2 moedas. 
