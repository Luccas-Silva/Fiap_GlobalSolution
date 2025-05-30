# 🌍 GeoMonitor - Fiap GlobalSolution

**Monitoramento Inteligente de Zonas de Risco com IoT: Prevenção e Resiliência**

## Introdução

Em um cenário global de eventos extremos cada vez mais frequentes, a capacidade de prever e mitigar desastres naturais torna-se crucial. Encostas instáveis, barragens e outras zonas de risco representam ameaças significativas à vida humana e ao meio ambiente. Este projeto propõe uma solução inovadora baseada em Sensores de Internet das Coisas (IoT) para o monitoramento contínuo e em tempo real dessas áreas, transformando o desafio em uma oportunidade de proteção e resiliência.

## O Desafio: Vulnerabilidade e Resposta Lenta

Atualmente, muitas áreas de risco são monitoradas de forma manual ou com tecnologias limitadas, resultando em dados intermitentes e respostas tardias. Deslizamentos de terra, rompimentos de barragens e inundações repentinas podem ocorrer com pouca ou nenhuma advertência. A falta de informações precisas e em tempo real impede a evacuação preventiva e a tomada de decisões eficazes.

## A Solução: Sensores IoT para Monitoramento Preditivo

Propomos a implementação de uma rede inteligente de sensores IoT estrategicamente posicionados em encostas, barragens e outras zonas de risco. Esta rede coletará dados ambientais e estruturais de forma contínua, transmitindo-os para uma plataforma centralizada para análise, acionamento de alertas e apoio à tomada de decisão.

## 🎯 Objetivo

Oferecer uma plataforma inteligente e automatizada para:
- Monitorar áreas de risco em tempo real.
- Gerar alertas com base em dados coletados por sensores.
- Acionar equipes de resposta com agilidade.
- Registrar e acompanhar a atuação em campo.

## 🧱 Estrutura do Banco de Dados

O sistema é composto por seis entidades principais:

- **USUARIO**: Cadastro de usuários do sistema.
- **EQUIPE_DE_RESPOSTA**: Grupos responsáveis por atender alertas.
- **AREA_DE_RISCO**: Locais sensíveis monitorados pelo sistema.
- **SENSOR**: Dispositivos IoT instalados nas áreas de risco.
- **ALERTA**: Ocorrências geradas automaticamente com base em leituras críticas.

Principais relacionamentos:
- Um sensor está associado a uma área de risco.
- Um alerta está vinculado a uma área de risco e pode ser respondido por uma equipe.
- Uma equipe está associada a um usuário responsável.

## Diagrama Model de Banco

![Relational_1](https://github.com/user-attachments/assets/75f40d2b-7d39-4206-b48d-128ba2172790)

## 🔧 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- Banco de dados relacional (PostgreSQL ou MySQL)
- Thymeleaf (caso tenha frontend)
- Sensores simulados ou reais via API/Mock

## 🚨 Funcionalidades

- Cadastro e gerenciamento de áreas de risco e sensores.
- Coleta periódica de dados dos sensores (manual ou automática).
- Geração automática de alertas com base em limiares definidos.
- Gestão de equipes de resposta e suas atuações.
- Painel de controle com histórico de alertas e dados sensoriais.

## 📁 Estrutura do Projeto

Descreva aqui a estrutura dos diretórios e principais arquivos do projeto, por exemplo:

```
src/
 ├── main/
 │    ├── java/
 │    │    └── com/fiap/globalSolution/
 │    │          ├── controller/
 │    │          ├── model/
 │    │          ├── repository/
 │    │          ├── service/
 │    │          └── ...
 │    └── resources/
 │         ├── application.properties
 │         └── ...
 └── test/
```

## Conclusão

A aplicação de sensores IoT para o monitoramento de encostas, barragens e zonas de risco é um exemplo claro de como a tecnologia, aliada à criatividade e ao propósito, pode transformar desafios em soluções que salvam vidas e protegem nosso planeta. Ao investir em sistemas de monitoramento preditivo, não apenas mitigamos os impactos dos eventos extremos, mas também construímos um futuro mais seguro e resiliente para todos.
