import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // --- FLUXO 1: LEITURA DA ENTRADA ---
        // Inicializa o leitor para capturar a linha de texto digitada pelo usuário
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        // --- FLUXO 2: DIVISÃO EM FRASES E ARMAZENAMENTO ---
        // Divide o texto original em frases utilizando o ponto final (.) como delimitador
        String[] sentences = text.split("\\.");
        
        // Matriz (array 2D) para armazenar as palavras de cada frase separadamente
        String[][] textArray = new String[sentences.length][];
        
        // TreeMap armazena os pares (palavra -> frequência).
        // A escolha do TreeMap garante que as chaves (palavras) fiquem ordenadas alfabeticamente.
        Map<String, Integer> wordCount = new TreeMap<>();
        
        // --- FLUXO 3: PROCESSAMENTO E SANITIZAÇÃO DAS PALAVRAS ---
        // Loop externo: percorre cada frase obtida no split
        for (int i = 0; i < sentences.length; i++) {
            // Remove espaços nas extremidades e divide a frase em palavras usando o espaço (" ")
            textArray[i] = sentences[i].trim().split(" ");

            // Loop interno: percorre cada palavra da frase atual
            for (int j = 0; j < textArray[i].length; j++) {
                
                // Sanitização: remove caracteres não alfabéticos (pontuações, símbolos) 
                // e converte para minúsculas para padronizar a contagem
                String word = textArray[i][j].replaceAll("[^a-zA-Z]", "").toLowerCase();

                // Garante que strings vazias (oriundas de espaços extras/pontuações) não sejam contadas
                if (!word.isEmpty()) {
                    // Atualiza a contagem: se a palavra já existe, pega o valor atual e soma 1;
                    // se não existe, inicia com 0 e soma 1.
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // --- FLUXO 4: CÁLCULO DE MÉTRICAS GERAIS ---
        int totalWords = 0;
        int maxCount = 0; 
        int uniqueWords = wordCount.size(); // O tamanho do Map representa a quantidade de palavras únicas

        // Soma todas as ocorrências para obter o total geral de palavras 
        // e identifica a maior frequência encontrada
        for (int count : wordCount.values()) { 
            totalWords += count; 
            if (maxCount < count) { 
                maxCount = count; 
            } 
        } 

        // --- FLUXO 5: EXIBIÇÃO DOS RESULTADOS ---
        // Imprime o cabeçalho com os totais calculados
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Word statistics:");

        // Percorre cada entrada do TreeMap (já ordenado alfabeticamente)
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) { 
            String word = entry.getKey();
            int count = entry.getValue();
            
            // Calcula a porcentagem relativa que a palavra representa no texto total
            double percentage = (double) count / totalWords * 100;
            
            // Imprime no formato: "palavra: quantidade (porcentagem%)"
            System.out.printf("%s: %d (%.2f%%)%n", word, count, percentage);
        }
        
        // --- FLUXO 6: FINALIZAÇÃO ---
        // Fecha o scanner para liberar o recurso
        scanner.close();
    }
}
