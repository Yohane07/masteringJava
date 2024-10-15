package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagrammeDetection {
    public static Set<Set<String>> detecterAnagramme(List<String> mots) {
        Map<String, Set<String>> anagrammes = new HashMap<>();

        for (String mot : mots) {
            char[] lettres = mot.toCharArray();
            Arrays.sort(lettres);
            String motTrie = new String(lettres);

            anagrammes
                    .computeIfAbsent(motTrie, k -> new HashSet<>())
                    .add(mot);
        }

        return new HashSet<>(anagrammes.values());
    }
}
