package Model.Comparator;

import java.util.Comparator;

/**
 * Classe que implementa um comparador para ordenar strings em ordem alfabética crescente.
 * O comparador lida corretamente com strings nulas e compara caractere por caractere.
 */
public class CompStringsCresc implements Comparator<String>{
    
    /**
     * Compara duas strings em ordem alfabética crescente.
     * 
     * @param s1 Primeira string a ser comparada
     * @param s2 Segunda string a ser comparada
     * @return Um valor negativo se s1 vem antes de s2 alfabeticamente,
     *         um valor positivo se s1 vem depois de s2 alfabeticamente,
     *         ou zero se as strings são iguais
     */
    @Override
    public int compare(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return -1;
        }
        if (s2 == null) {
            return 1;
        }

        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);

            if (char1 != char2) {
                return char1 - char2;
            }
        }

        // Se todas as letras até o tamanho mínimo forem iguais, a string mais longa é maior
        return s1.length() - s2.length();
    }   
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Comparator
     * 
     * @return informações sobre o Comparator
     */
    @Override
    public String toString(){
        return "Comparator que organiza strings alfabeticamente de forma crescente";
    }
}
