# rankingDeHerois
Nesse desafio, precisei criar uma função que retornasse o resultado de uma variável com o saldo de ranking.
Comecei criando 2 variáveis (vitoria e derrota), depois há o calculo para subtrair o número de derrotas do número de vitórias.
Há a função calcularNivel, que recebe um valor inteiro e retorna o nível do jogador, cada objeto Nivel têm o nome nome do nível e uma função
condicional para verificar o saldo.
A função filter da stream filtra os níveis na condição especificada em cada objeto Nivel. O método .apply verifica se o saldo satisfaz as condições do nível.
.findFirst() obtem o primeiro nível correspondente às condições e o .map é usado para extrair o nome do nível.
