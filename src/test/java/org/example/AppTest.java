package org.example;


import static java.util.Arrays.stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void testApp()
    {
        // Given
        List<String> mots = List.of("dfsfs", "qfs", "AAAAAAA");

        // When
        List<Integer> result = mots.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());

        // Then
        List<Integer> expected = List.of(5, 3, 7);
        Assertions.assertEquals(expected, result, "J'aime bien stream() " );
    }

    @Test
    public void testAppRegex(){

        //Given
        List<String> inputs = List.of("dfsfs", "qfs", "AAAAAAA", "ab");

        String input = "Ob";

        String regex = "a*b";

        Pattern pattern = Pattern.compile(regex);

        //When
        Matcher matcher = pattern.matcher(input);

        //Then
        boolean match = matcher.matches();
        Assertions.assertFalse(match);
    }

}
