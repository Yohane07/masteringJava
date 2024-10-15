package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class AnagrammeDetectionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Verifie si un mot est un anagramme du mot ")
    void testAnagramme() {
        // Given
        List<String> mots = List.of("abcd", "java", "spam", "mail", "cbad", "vaja", "pasm", "vjaa");

        // When
        Set<Set<String>> anagrammes = AnagrammeDetection.detecterAnagramme(mots);

        // Then
        assertNotNull(anagrammes);
        assertEquals(4, anagrammes.size(), "Nombre de caractere incorrect");
        assertEquals(
                Set.of(
                        Set.of("mail"),
                        Set.of("java", "vaja", "vjaa"),
                        Set.of("abcd", "cbad"),
                        Set.of("spam", "pasm")
                ),
                anagrammes,
                "Caracteres non identiques"
        );
    }

}