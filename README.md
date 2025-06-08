# 🌍 GeoMonitor - Fiap GlobalSolution

***Monitoramento Inteligente de Zonas de Risco: Prevenção e Resiliência***

## 📝 Introdução

O GeoMonitor é uma plataforma desenvolvida para monitoramento preditivo de áreas de risco como encostas, barragens e outras regiões suscetíveis a desastres naturais. Com integração de sensores IoT, inteligência artificial e mensageria assíncrona (RabbitMQ), o sistema permite o acompanhamento em tempo real, geração automática de alertas e mobilização ágil de equipes de resposta.

## 🎯 Objetivo

- Monitorar áreas de risco em tempo real.
- Gerar alertas automáticos com base em leituras sensoriais.
- Acionar e registrar equipes de resposta.
- Utilizar IA para apoio à análise e triagem de ocorrências.
- Disponibilizar painel de controle com histórico de alertas e dados sensoriais.

## 🗄️ Banco de Dados

O projeto suporta múltiplos bancos relacionais:

- **Desenvolvimento/Testes:** H2 (memória)
- **Produção/Opcional:** Azure SQL ou Oracle (basta descomentar e configurar em `application.properties`)

Exemplo de configuração (`src/main/resources/application.properties`):
```properties
# H2 (default)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Azure SQL (exemplo)
spring.datasource.url=jdbc:sqlserver://...;database=...
spring.datasource.username=...
spring.datasource.password=...

# Oracle (exemplo)
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=...
spring.datasource.password=...
```

## 🛠️ Tecnologias Utilizadas

- Java 21+
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- Thymeleaf (frontend)
- Spring Security
- Banco relacional (H2, Azure SQL, Oracle)
- RabbitMQ (mensageria)
- Spring AI (integração OpenAI)
- Testes: JUnit 5, Mockito, Spring Boot Test

## ⚙️ Funcionalidades

- Cadastro/gerenciamento de áreas de risco, sensores e equipes de resposta.
- Coleta periódica de dados dos sensores (manual e automática).
- Geração automática de alertas por limiares.
- Mensageria assíncrona com RabbitMQ para eventos críticos.
- Apoio de IA para classificação ou análise de ocorrências.
- Painel web (Thymeleaf) para visualização e controle.
- Testes automatizados para entidades, controllers, repositórios e serviços.

## 📁 Estrutura do Projeto

```
src/
 ├── main/
 │    ├── java/
 │    │    └── com/fiap/Java_GlobalSolution/
 │    │          ├── controller/
 │    │          ├── model/
 │    │          ├── repository/
 │    │          ├── Service/
 │    │          └── configs/
 │    └── resources/
 │         ├── application.properties
 │         ├── database/create.sql
 │         └── templates/ (views Thymeleaf)
 └── test/
      └── java/com/fiap/Java_GlobalSolution/
```

## 🚀 Como executar

### ✅ Pré-requisitos

- Java 21+  
- Maven  
- (Opcional) RabbitMQ local (pode ser via Docker)  
- (Opcional) Banco relacional para produção  
- (Opcional) Conta OpenAI para IA

### ▶️ Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/Luccas-Silva/Fiap_GlobalSolution_Java.git
   cd Fiap_GlobalSolution_Java
   ```

2. **(Opcional) Ajuste o banco**  
   O projeto já sobe com H2 em memória por padrão.  
   Para usar Azure SQL ou Oracle, edite `application.properties` conforme necessário.

3. **Inicie o RabbitMQ (opcional, mas recomendado para testes de eventos)**
   ```bash
   docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
   ```

4. **Compile e execute**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   Acesse em: [http://localhost:8080](http://localhost:8080)

5. **Acesse o H2 Console (opcional)**
   - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:testdb`, usuário: `sa`

## 🧪 Testes

Execute todos os testes automatizados:
```bash
mvn test
```

Os testes cobrem entidades, repositórios, controllers, serviços, autenticação e integração RabbitMQ.

## 📬 Integração RabbitMQ

- Configuração em `src/main/java/com/fiap/Java_GlobalSolution/configs/RabbitMQConfig.java` e `application.properties`
- Producers e consumers prontos em `Service/`
- Mensagens são trocadas entre filas configuráveis; exemplos de uso nos serviços.

## 🤖 Inteligência Artificial

- Configuração em `src/main/java/com/fiap/Java_GlobalSolution/configs/AiConfig.java` e `application.properties`
- Integração pronta para uso de modelos da OpenAI via Spring AI (necessário chave e endpoint).

## 🔐 Segurança

- Spring Security configurado para autenticação e autorização por role.

## 🗺️ Estrutura do Banco

O banco possui tabelas para:
- Usuários
- Equipes de resposta
- Áreas de risco
- Sensores
- Alertas

Diagrama exemplo:

![Relational_1](https://github.com/user-attachments/assets/75f40d2b-7d39-4206-b48d-128ba2172790)

## 📚 Referências e Ajuda

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring AI](https://docs.spring.io/spring-ai/reference/index.html)
- [Spring for RabbitMQ](https://docs.spring.io/spring-amqp/reference/index.html)
- [Thymeleaf](https://www.thymeleaf.org/documentation.html)

---

> ❓ Dúvidas? Abra uma issue ou consulte a documentação interna do projeto (HELP.md).
