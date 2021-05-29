# Romanos

Esse projeto foi desenvolvido com a finalidade de realizar um desafio técnico proposto pela Zenvia durante o processo seletivo. O desafio consiste em desenvolver um convertedor de número romanos para números decimais e vice-versa. 


## Tecnologias 
A solução foi desenvolvida no padrão **REST** com o **Java Spring Boot v2.3.4** e a ferramenta utilizada para o gerenciamento dos projetos foi o **Maven**.

## Estrutura do projeto
A estrutura do projeto segue o modelo de **MicroServices**.

Foram criados dois **end-points** para atender a necessidade do desafio:

 -  Converter Decimal  ***(GET /api/v1/converter/decimal/{numeroRomano})***
	 - Responsável por converter um número romano em um número decimal.
	  
  -  Converter Romano ***(GET /api/v1/converter/romano/{numeroDecimal})***
	 - Responsável por converter um número decimal em um número romano.

## Utilizando a aplicação

 - Importar o projeto "***romanos"***  em IDE de desenvolvimento.
 - Abrir o terminal na raiz do projeto e rodar o comando `mvn -U clean install`.
 - Rodar o projeto.
 -  Acessar o Swagger.

### Swagger
No momento o projeto não dispõe de uma interface de usuário para que as implementações sejam utilizadas. Pensando nisso foi adicionado o **swagger** para que seja possível testar a aplicação.  
*Url Swagger : *http://localhost:8080/swagger-ui.html**

