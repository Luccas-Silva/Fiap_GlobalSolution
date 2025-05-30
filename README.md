# *Fiap_GlobalSolution - 🌍 GeoMonitor*

**Monitoramento Inteligente de Zonas de Risco com IoT: Prevenção e Resiliência**

## 📌 Descrição

O **GeoMonitor** é um sistema Java completo com backend estruturado em **Spring Boot** e banco de dados relacional que visa o **monitoramento contínuo e em tempo real de zonas de risco**, como encostas e barragens. A solução utiliza **sensores IoT** para coletar dados ambientais e estruturais, permitindo alertas preditivos, ações rápidas e maior resiliência em cenários de desastres naturais.

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

Relacionamentos principais:
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

