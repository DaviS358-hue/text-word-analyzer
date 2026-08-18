# 📝 Text Word Analyzer

> Uma aplicação Java via console para análise textual, cálculo de frequência de palavras e exibição de estatísticas formatadas com ordenação alfabética.

---

## 📌 Sobre o Projeto

O **Text Word Analyzer** é um programa em Java focado no processamento de texto. Ele analisa uma entrada digitada pelo usuário, realiza a limpeza e padronização dos dados (sanitização via Regex) e calcula a ocorrência individual de cada palavra, apresentando métricas gerais e percentuais em ordem alfabética.

### 🚀 Principais Funcionalidades
* **Sanitização de Texto:** Remove pontuações e caracteres especiais mantendo apenas o conteúdo alfabético.
* **Padronização:** Converte todo o texto para letras minúsculas (case-insensitive) para garantir precisão na contagem.
* **Cálculo de Frequência:** Determina a contagem absoluta de cada palavra e calcula sua porcentagem relativa no texto total.
* **Ordenação Alfabética:** Utiliza a estrutura de dados `TreeMap` para garantir que as estatísticas sejam exibidas em ordem alfabética automaticamente.

---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem:** Java (JDK 8+)
* **Estruturas de Dados:** `TreeMap` (Red-Black Tree para ordenação por chave) e Matrizes/Arrays.
* **Manipulação de Strings:** Métodos `trim()`, `split()` e substituição via Expressões Regulares (`replaceAll("[^a-zA-Z]", "")`).
* **Saída Formatada:** `System.out.printf` para formatação numérica e alinhamento do relatório final.

---

## 💻 Exemplo de Uso

### Entrada:
```text
Java is best. Python is best. Hello Java hello.
