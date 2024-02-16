# Venda de ingressos - Cinema
Projeto criado em Java em 2021 para simular o funcionamento de um sistema de vendas de ingressos para filmes de um cinema. Na época, o intuito era apenas para treinamento e para entender conceitos como classes ,classes abstratas, herança, polimorfismo, relacionamentos, interfaces e toda a estrutura da orientação a objetos. 

## Tipos de relacionamento: 

### HERANÇA 
Filme, Show e Partida herdam de Eventos Presenciais. InterfaceUsuario, InterfaceAdm
e InterfaceRelatorio herdam de InterfaceGeral. 

### COMPOSIÇÃO: 
Administracao é parte de CompraIngresso, InterfaceGeral. EventosPresencias é parte 
de Administracao, Relatorio. Ingresso é parte de Sessão e CompraIngresso. Sessao é parte de 
EventosPresenciais. CompraIngresso é parte de InterfaceUsuario. Administracao, também tem
um atributo do tipo Grafico, que não foi adicionada ao diagrama por ser uma classe disponibilizada
pelo professor e só ser utilizada ali. Administracao também um atributo do tipo EstatisticaEvento

* Algumas dessas relações poderiam ser pensadas também como Agregação, também do tipo
"Todo-Parte", mas com a parte tendo sua "vida" controlada pelo Todo. Como os objetos
do sistema são mais abstratos, fica mais difícil fazer essa visualização e assim, 
preferi manter como Composição. 

### IMPLEMENTAÇÃO: 
EventosPresenciais implementa Eventos e EstatisticaEvento. É importante mencionar
que várias classes implementam a Interface Serializable, que permite salvar dados binários. 

### ASSOCIAÇÃO: 
Relação pensada entre as classes FIlme, Show, e Partida com a classe Administracao.
Pensei desse modo pois, são chamadas em Administracao, mas não são explicitamente atributos dessa classe. 

Para as classes que contém relacionamentos, os atributos desse tipo não foram colocados no diagrama. 
Por exemplo, a classe sessão tem um atributo do tipo Ingresso. Ele não aparece como atributo no 
diagrama, mas a seta de relacionamento mostra que ele existe.

## SOBRE FUNCIONALIDADES

Primeiramente, o organizador pode cadastrar quantos eventos necessários em
InterfaceAdm. Ao cadastrar um evento, ele pode depois, também cadastrar
quantas sessões necessárias para eventos do tipo Filme e Show (Partidas só
cadastra 1 sessão). A classe Sessão tem um atributo nome, que recebe como 
parâmetro o nome do evento ao qual se deseja associar uma sessão. Por exemplo,
na interface, a opção 2 corresponde ao cadastro de uma sessão. A interface pede
o nome do evento e associa esse nome ao atributo nome do objeto Sessão. Após
os cadastros necessários, deve-se pedir para que o sistema salve as alterações.

A InterfaceUsuario, carrega os valores que foram salvos em InterfaceAdm e mostra
suas informações ao usuário. Se ele desejar, pode obter mais informações sobre 
determinado evento, comprar e imprimir os ingressos. A opção Imprimir ingressos, 
além de gerar um .txt com os ingressos, também salva os ingressos comprados. 
Desse modo, ao entrar novamente em InterfaceUsuario, os valores de Ingressos Vendidos
estarão atualizados. Existe também um sistema que verifica se a cadeira desejada 
está ocupada. 

A InterfaceRelatorio, se relaciona com o módulo de Adminstracao, mas ligada às
estatísticas de venda. Possui métodos que permitem ver as métricas por tipo de 
evento e por evento específico.
