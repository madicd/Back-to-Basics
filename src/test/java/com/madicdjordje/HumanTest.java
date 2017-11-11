package com.madicdjordje;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HumanTest {

    @Test
    public void testSort() {
        List<Human> humans = Arrays.asList(
                new Human("Marco", 12),
                new Human("Ivan", 12),
                new Human("Ivan", 10)
        );

        humans.sort(comparing(Human::getName).thenComparing(Human::getAge));

        assertThat(humans.get(0), equalTo(new Human("Ivan", 10)));
    }
}