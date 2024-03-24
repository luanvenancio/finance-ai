# Automated Investment Strategies with Machine Learning
[![scikit-learn](https://img.shields.io/badge/scikit--learn-%23F7931E.svg?style=flat&logo=scikit-learn&logoColor=white)](https://img.shields.io/badge/scikitlearn-F7931E.svg?style=for-the-badge&logo=scikit-learn&logoColor=white) [![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Visão Geral

Este projeto tem como objetivo desenvolver um framework abrangente para criar e aprimorar estratégias de investimento automatizadas utilizando técnicas de Aprendizado de Máquina (ML). O foco é o mercado de ações brasileiro, com ênfase específica na ação da Localiza (RENT3). O projeto incorpora aprendizado supervisionado, métodos de _Ensemble_ e _Stacking_ para construir e refinar modelos para tomada de decisões em negociações de ações.

## Estrutura do Projecto

#### Parte 1: Estrutura de Aprendizado Supervisionado

Nesta seção, estabelecemos a base para o projeto implementando uma estrutura de aprendizado supervisionado. Os principais aspectos incluem:

1. **Definição do Problema**: Compreender os desafios do _Algorithmic trading_ e propor uma solução utilizando Aprendizado de Máquina.

2. **Definição da Solução**: Criar uma série de experimentos envolvendo as seguintes etapas:

   - **Etapa 1**: Construção de um conjunto de dados para aprendizado supervisionado.
   - **Etapa 2**: Desenvolver e analisar modelos de ML supervisionados.
   - **Etapa 3**: Criar estratégias de investimento automatizadas usando ML e analisar retornos.

3. **Requisitos e Análise de Resultados**: Implementar os seguintes requisitos para cada etapa:

   - **Etapa 1**: Construir um conjunto de dados rico em atributos para modelos de ML, incluindo preços diários de ações, indicadores técnicos, dados estatísticos e características de defasagem.
   
   - **Etapa 2**: Implementar Random Forest para classificação e Multilayer Perceptron para regressão. Utilizar diversas técnicas de validação e calcular métricas como AUC, Precisão, Revocação, MAE e RMSE.
   
   - **Etapa 3**: Simular retornos usando as saídas do modelo de ML, calcular retornos diários e gerar métricas financeiras chave.

4. **Simulador de Retornos**: Simular retornos usando as saídas do modelo.

#### Parte 2: Técnicas de _Ensemble_ e _Stacking_

A segunda parte do projeto concentra-se em aprimorar estratégias de investimento através de métodos de _ensemble_ e _stacking_. Isso envolve:

1. **Definição do Problema**: Estender o projeto para incluir técnicas de aprendizado de _ensemble_ e _stacking_ para tomada de decisões aprimorada.

2. **Definição da Solução**: Realizar experimentos com aprendizado de _ensemble_ e _stacking para regressão e classificação, utilizando modelos como Random Forest, Multilayer Perceptron, XGBoost, Naive Bayes e k-Nearest Neighbors: 

   - **Aprendizado de Conjunto**: Combinar as saídas do modelo de ML para regressão e classificação usando técnicas como média simples e média ponderada com base na precisão do modelo.
   
   - **Empilhamento**: Utilizar um modelo de _stacking_ não linear (Multilayer Perceptron) para agregar saídas de modelos individuais.

3. **Requisitos e Análise de Resultados**: Desenvolver modelos para regressão e classificação, aplicar técnicas de aprendizado de _ensemble_ e _stacking_, e calcular métricas como AUC, Precisão, Revocação, MAE e RMSE. Comparar com modelos de linha de base.

4. **Simulador de Retornos**: Simular retornos usando os modelos de _ensemble_ e _stacking_.


#### Parte 3: Validação e Melhoria Contínua

Na parte final, o projeto amplia suas capacidades introduzindo validação com janelas deslizantes. Aspectos-chave incluem:

1. **Definição do Problema**: Aprimorar o framework introduzindo validação com janelas deslizantes para melhoria contínua.

2. **Definição da Solução**: Realizar experimentos envolvendo:

   - **Validação do Modelo com Janelas Deslizantes**: Retreinar modelos em intervalos diários, semanais e mensais para melhoria contínua.
   
   - **Refinamento de _Ensemble_ e _Stacking_**: Refinar ainda mais modelos de _ensemble_ e _stacking_.

3. **Requisitos e Análise de Resultados**: Adaptar modelos para validação com janelas deslizantes, refinar modelos de  _ensemble_ e _stacking_, e calcular métricas conforme seções anteriores.

4. **Simulador de Retornos**: Simular retornos usando os modelos aprimorados.

## Conjunto de Dados

O projeto utiliza dados da ação da Localiza (RENT3) dentro do Índice Bovespa.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para contribuir e fornecer feedback.
