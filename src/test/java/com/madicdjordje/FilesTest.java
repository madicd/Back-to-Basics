package com.madicdjordje;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.get;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilesTest {

    private static final String HOME = "/Users/madj";

    @Test
    public void testExists() {
        Path homePath = get(HOME);

        assertTrue(exists(homePath));
    }

    @Test
    public void testNotExists() {
        Path fakeFilePath = get(HOME + "/fake.txt");

        assertTrue(notExists(fakeFilePath));
    }

    @Test
    public void testFileCheck() {
        Path homePath = get(HOME);

        assertFalse(isRegularFile(homePath));
    }

    @Test
    public void testSameFile() throws IOException {
        Path home1 = get(HOME);
        Path home2 = get(HOME);

        assertTrue(isSameFile(home1, home2));
    }
}
