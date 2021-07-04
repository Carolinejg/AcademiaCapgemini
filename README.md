# Pré-requisitos para rodar o sistema da Calculadora: 
- Ter o Java JDK instalado
- Ter o Eclipse IDE for Enterprise Java Developers instalado 

## O problema

A agência Divulga Tudo precisa de um programa para gerenciar os seus anúncios online. O objetivo dos anúncios faz parte de uma campanha nas redes sociais. O sistema de gerenciamento permitirá a gestão do anúncio e o rastreio dos resultados da campanha.

Este programa será composto de duas partes:
- 1ª Parte – Uma calculadora de alcance de anúncio online.
- 2ª Parte - Um sistema de cadastro de anúncios.


## 1ª Parte: Sistema da calculadora 
O sistema foi desenvolvido utilizando os seguintes seguintes dados:
- a cada 100 pessoas que visualizam o anúncio 12 clicam nele.
- a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
- cada compartilhamento nas redes sociais gera 40 novas visualizações.
- 30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
- o mesmo anúncio é compartilhado no máximo 4 vezes em sequência.

### Como executar  o sistema calculadora
- Clone este repositório usando: git clone https://github.com/Carolinejg/academiacapgemini/
- Importe o projeto no Eclipse 
- Identifique o arquivo ***calculadora.java*** no seguinte diretório

 ![](https://github.com/Carolinejg/academiacapgemini/blob/master/Parte%201/calculadora/img/calculadora.png)

- Com o Eclipse na perspectiva Java execute o arquivo 
- Entre com a informação do valor do investimento 
- O resultado é uma projeção da quantidade máxima e mínima de pessoas que visualizaram o mesmo anúncio 

![](https://github.com/Carolinejg/academiacapgemini/blob/master/Parte%201/calculadora/img/calculadora_terminal.png)

# Pré-requisitos para rodar o sistema  Cadastro e Visualização de Relatórios: 
- Ter o Java JDK instalado
- Ter o Eclipse IDE for Enterprise Java Developers instalado 
- Ter o servidor Tomcat instalado e configurado no Eclipse  
 Obs: Para maiores informações de como instalar e configurar o TomCat segue um link que me ajudou :blush: : 
   https://www.devmedia.com.br/instalacao-e-configuracao-do-apache-tomcat-no-eclipse/27360
- Criar uma base de dados no PostgreSQL com as seguintes informações: 
  - Nome da base: anunciodb
  - E a tabela criada com os seguintes campos: 
  ![](https://github.com/Carolinejg/academiacapgemini/blob/master/Parte%202/img/calculadora_terminal.png)

