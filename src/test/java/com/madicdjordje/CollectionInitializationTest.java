package com.madicdjordje;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertTrue;

public class CollectionInitializationTest {

    @Test
    public void initSetDoubleBraces() {
        Set<String> countries = new HashSet<String>() {
            {
                add("Montenegro");
                add("Serbia");
                add("Croatia");
            }
        };

        assertTrue(countries.contains("Serbia"));
    }

    @Test
    public void initSetStreams() {
        Set<String> countries = Stream.of("Montenegro", "Serbia", "Croatia").collect(toSet());

        assertTrue(countries.contains("Serbia"));
    }
}
