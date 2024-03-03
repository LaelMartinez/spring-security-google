# Spring Security with Google Identity Provider

Este projeto demonstra uma aplicação Spring Boot que utiliza o Spring Security para integração com o provedor de identidade Google. A aplicação contém rotas públicas e privadas, e informações sobre o usuário autenticado são exibidas nas rotas privadas.

## Como Executar

Certifique-se de ter o Java e o Maven instalados na sua máquina.

1. Clone este repositório:

   ```bash
   git clone https://github.com/LaelMartinez/spring-security-google.git

2. Navegue até o diretório do projeto:
   ```bash
   cd spring-security-google

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

Rotas da API
Rota Pública
 * GET /public
    - Descrição: Rota pública acessível a todos.
    - Exemplo: http://localhost:8080/public

Rota Privada
 * GET /private
    - Descrição: Rota privada que exige autenticação com Google. Exibe informações do usuário autenticado.
    - Exemplo: http://localhost:8080/private

Rota JWT
  * GET /jwt
    - Descrição: Rota que exibe informações do JWT (JSON Web Token) do usuário autenticado.
    - Exemplo: http://localhost:8080/jwt

Configurações
  Provedor de Identidade
    O provedor de identidade utilizado é o Google. Certifique-se de configurar corretamente as credenciais e as configurações de OAuth2 no console de desenvolvedor do Google.

  Configurações do Projeto
    As configurações do projeto estão em src/main/resources/application.yaml.

  Observações
    Este projeto utiliza Spring Security e Spring OAuth2 para integração com o provedor de identidade Google.

  A aplicação contém rotas de exemplo que ilustram o uso de dados do usuário autenticado.

Contribuindo
Sinta-se à vontade para contribuir com melhorias ou correções. Abra uma issue ou envie um pull request!   


   
   
