FEATURE 01
A primeira feature estabelece a base do sistema de venda de produtos, criando as classes de domínio, definindo atributos, relacionamentos e implementando funcionalidades essenciais para a leitura de dados a partir de arquivos textos e operações de inclusão e recuperação de informações por meio das classes de serviço. Essa é a etapa inicial crucial para o desenvolvimento do software, que servirá como alicerce para as futuras funcionalidades do sistema. Essa feature do projeto visa estabelecer os alicerces do sistema de venda de produtos, construindo as principais estruturas de domínio e funcionalidades necessárias para o seu funcionamento inicial. Esta feature abrange as seguintes tarefas:

Criação das quatro classes de domínio de acordo com o diagrama: o primeiro passo consiste na criação das quatro classes de domínio, que foram concebidas de acordo com um diagrama previamente projetado. Estas classes representam as entidades fundamentais do sistema, como Vendedores e Produtos.
Criação de pelo menos dois atributos por classe: cada uma das quatro classes deve ser dotada de, no mínimo, dois atributos que representam informações relevantes para a entidade em questão. Os atributos existentes no diagrama podem ser considerados mas também existe a possibilidade da definição de novos.
Implementar os relacionamentos entre as classes: estabelecer os relacionamentos entre as classes é essencial para a integridade das informações no sistema. Por exemplo, um "Vendedor" está associado a vários "Produto", e existem dois tipos de produtos. Esses relacionamentos devem ser devidamente implementados.
Utilizar os quatro tipos de dados fundamentais: as classes devem empregar os quatro tipos de dados fundamentais: caractere (String), inteiro (int), real (float/double) e lógico (boolean), conforme necessário para representar os atributos e informações das classes do projeto.
Criar classes Loader para realizar a leitura de arquivos textos e popular os objetos: para facilitar a inicialização e preenchimento dos objetos a partir de dados externos, como arquivos de texto, é necessário criar classes Loader. Essas classes serão responsáveis por ler os dados desses arquivos e transformá-los em instâncias das classes de domínio.
Criar arquivos textos com as informações de cada classe com os campos separados por ";": deve ser criado um conjunto de arquivos de texto que contenham informações relevantes para cada classe, com os campos separados por um caractere delimitador, como o ponto e vírgula. Esses arquivos servirão como fonte de dados para o sistema.
Criar as classes @Service com os métodos "incluir" e "obterLista": para gerenciar as operações relacionadas às classes de domínio, como a inclusão de novos registros e a recuperação de listas de objetos, é preciso criar as classes de serviço (annotated com @Service) correspondentes a cada classe de domínio. Essas classes conterão os métodos "incluir" e "obterLista" para a manipulação dos dados.
Estes métodos devem guardar e recuperar as informações do Map: os métodos "incluir" e "obterLista" das classes @Service devem interagir com uma estrutura de dados, como um Map, para armazenar e recuperar as informações das classes de domínio. Isso permitirá o acesso eficiente e a manipulação dos dados do sistema.

FEATURE 02
A segunda feature é essencial para a consolidação do sistema, pois estabelece uma base de dados sólida, configura relacionamentos importantes entre as entidades e prepara o sistema para operações avançadas, como consultas complexas e a manutenção eficiente de dados. Isso permite ao sistema de venda de produtos gerenciar informações de maneira mais escalável e eficaz. Essa segunda feature do projeto concentra-se em estabelecer uma infraestrutura de banco de dados robusta para o sistema de venda de produtos. Ela abrange as seguintes tarefas essenciais:

Criação do banco de dados e configuração do datasource para acesso e manipulação: inicialmente, um banco de dados será criado e configurado para possibilitar o armazenamento e a recuperação de dados do sistema. Isso envolve a escolha de um sistema de gerenciamento de banco de dados (DBMS), como MySQL, PostgreSQL ou outro, e a configuração de um datasource para permitir a comunicação com o banco.
Mapeamento das classes de domínio em entidades do banco: as classes de domínio criadas na primeira feature serão mapeadas em entidades do banco de dados. Isso implica em definir como os atributos de cada classe correspondem às colunas do banco e como os relacionamentos entre as entidades serão refletidos no esquema do banco de dados.
Criar o relacionamento oneToMany entre as entidades de vendedor e de produto: será estabelecido um relacionamento "one-to-many" entre as entidades de "vendedor" e "produto". Isso significa que um vendedor pode estar associado a vários produtos, enquanto um produto pertence a apenas um vendedor.
Criar o relacionamento de herança entre a classe de produto e as suas filhas: para lidar com diferentes tipos de produtos (por exemplo, produtos físicos e produtos digitais), será estabelecido um relacionamento de herança entre a classe "Produto" e suas subclasses. Isso permite que as características específicas de cada tipo de produto sejam modeladas de forma eficiente.
Criação das interfaces @Repository para possibilitar o uso das funcionalidades de banco de dados da CrudRepository: serão criadas interfaces anotadas com @Repository para as entidades do banco de dados. Essas interfaces estenderão a CrudRepository, proporcionando operações de CRUD (Create, Read, Update, Delete) padrão para as entidades.
Atuar na injeção de dependência dos repositories nas classes de serviço: os repositórios criados na etapa anterior serão injetados nas classes de serviço correspondentes. Isso permitirá que as classes de serviço acessem o banco de dados de maneira eficiente, implementando as operações de negócios relacionadas a cada entidade.
Desconsiderar a estrutura Map após a realização da injeção de dependência dos repositories: após a injeção de dependência dos repositories, a estrutura de dados Map, usada na primeira feature para simular o armazenamento temporário, pode ser desconsiderada. As operações de armazenamento e recuperação de dados agora serão realizadas diretamente no banco de dados.
Atualizar as classes Loader para relacionar os produtos cadastrados com os vendedores existentes: as classes Loader criadas na primeira feature precisam ser atualizadas para preencher o banco de dados com dados relacionados. Isso envolve associar os produtos cadastrados aos vendedores existentes por meio dos relacionamentos definidos.

FEATURE 03
A terceira feature tem como objetivo melhorar a usabilidade da aplicação, permitindo que os usuários vejam os dados de forma organizada e compreensível, ao mesmo tempo em que se concentra na qualidade dos dados, validando e tratando exceções durante o processo. A integração com a API de CEP adiciona valor ao fornecer informações geográficas úteis para os registros dos vendedores. Certifique-se de que a interface do usuário seja amigável e intuitiva para os usuários finais.

Essa terceira feature do projeto envolve a criação de recursos de frontend e controle que permitirão a visualização dos dados armazenados nas quatro tabelas do banco de dados, juntamente com informações relevantes. Abaixo estão os principais requisitos e atividades a serem entregues nesta feature:

Tela de Visualização de Dados: crie uma interface de usuário utilizando tecnologias como JSP ou outra proposta de frontend para exibir os dados das quatro tabelas do banco de dados. Isso permitirá que os usuários visualizem os registros de forma amigável.
Visualização da Quantidade de Registros: além de exibir os dados, implemente a funcionalidade para mostrar a quantidade de registros existentes em cada uma das quatro tabelas. Isso fornece uma visão geral do tamanho de cada conjunto de dados.
Classe de Controle Única: crie uma classe de controle única que atuará como um ponto central para a navegação na aplicação. Esta classe deve conter rotas para acessar a tela de visualização e outras quatro rotas para recuperar os dados de cada uma das tabelas.
Validações de Dados: implemente validações de dados para garantir a integridade e a qualidade dos dados inseridos. Use anotações como @Size, @Pattern, @Positive, @PositiveOrZero, @NotNull, @Unique, @Default e outras, conforme necessário, para validar os campos das tabelas.
Tratamento de Exceções: atualize as classes de carga de dados (Loaders) para possibilitar o tratamento de exceções durante a inclusão de registros no banco de dados. Isso ajuda a lidar com erros de forma adequada e manter a integridade dos dados.
Classes de Controle para Exclusão: crie classes de controle separadas para implementar rotas de exclusão de registros. Isso permitirá que os usuários removam dados das tabelas de maneira controlada.
Classe para Representar o CEP do Vendedor: crie uma classe dedicada para representar o CEP do vendedor. Essa classe deve conter os campos e métodos necessários para armazenar e manipular informações de CEP.
Consumo da API de CEP: integre uma API de consulta de CEP para recuperar informações com base no número do CEP informado. Atualize os dados obtidos da API no banco de dados, associando-os aos registros dos vendedores. Isso permitirá que os dados de CEP estejam disponíveis para visualização na tela.