package Model.Comparator;

import java.util.Comparator;

public class CompStringsCresc implements Comparator<String>{
    
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
}
