package com.madicdjordje;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.get;
import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilesTest {

    private static final String HOME = "/Users/madj";

    @Test
    public void testExists() {
        Path home = get(HOME);

        assertTrue(exists(home));
    }

    @Test
    public void testNotExists() {
        Path fakeFile = get(HOME + "/fake.txt");

        assertTrue(notExists(fakeFile));
    }

    @Test
    public void testFileCheck() {
        Path home = get(HOME);

        assertFalse(isRegularFile(home));
    }

    @Test
    public void testSameFile() throws IOException {
        Path home1 = get(HOME);
        Path home2 = get(HOME);

        assertTrue(isSameFile(home1, home2));
    }

    @Test
    public void testCreateRegularFile() throws IOException {
        String fileName = "regular_file_" + randomUUID() + ".txt";
        Path file = get(HOME + "/" + fileName);

        assertTrue(notExists(file));
        createFile(file);
        assertTrue(exists(file));
        assertTrue(isRegularFile(file));

        delete(file);
    }

    @Test
    public void testCreateDir() throws IOException {
        String dirName = "dir_" + randomUUID();
        Path dir = get(HOME + "/" + dirName);

        assertTrue(notExists(dir));
        createDirectory(dir);
        assertTrue(exists(dir));
        assertTrue(isDirectory(dir));

        delete(dir);
    }

    @Test(expected = NoSuchFileException.class)
    public void testCreateSubdirFailsWhenDirDoesntExist() throws IOException {
        String dirName = "dir_" + randomUUID();
        Path dir = get(HOME + "/" + dirName);
        Path subdir = dir.resolve("subdir");

        assertTrue(notExists(subdir));
        createDirectory(subdir);
    }

    @Test
    public void testCreateDirectoriesRecursively() throws IOException {
        String dirName = "dir_" + randomUUID();
        Path dir = get(HOME + "/" + dirName);
        Path subdir = dir.resolve("subdir");

        assertTrue(notExists(dir));
        createDirectories(subdir);
        assertTrue(exists(dir));

        delete(subdir);
        delete(dir);
    }


}
