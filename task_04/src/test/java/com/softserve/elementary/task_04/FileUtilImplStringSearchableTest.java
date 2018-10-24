package com.softserve.elementary.task_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtilImplStringSearchableTest {

    private static final String PATH_TEST_FILE = "test.txt";
    private static final String TEST_COUNT_STRING = "Git";
    private static final String TEST_TEST = "If you can read only one chapter to get going with Git, this is it. " +
            "This chapter covers every basic command you need to do the vast majority of the things you’ll " +
            "eventually spend your time doing with Git. By the end of the chapter, you should be able to " +
            "configure and initialize a repository, begin and stop tracking files, and stage and commit changes." +
            " We’ll also show you how to set up Git to ignore certain files and file patterns, how to undo mistakes" +
            " quickly and easily, how to browse the history of your project and view changes between commits, " +
            "and how to push and pull from remote repositories.";

    private FileUtilImplStringSearchable fileUtilImplStringSearchable = new FileUtilImplStringSearchable();

    @Before
    public void writeSomeText() throws IOException {
        FileWriter fileWriter = new FileWriter(PATH_TEST_FILE);
        fileWriter.write(TEST_TEST);
        fileWriter.close();
    }

    @After
    public void deleteFile(){
        File file = new File(PATH_TEST_FILE);
        file.delete();
    }

    @Test
    public void countString() throws IOException {
        //GIVEN
        int expected = 3;
        //WHEN
        int res = fileUtilImplStringSearchable.countString(PATH_TEST_FILE, TEST_COUNT_STRING);
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void replaceString() throws IOException {
        int expected = 3;
        //WHEN
        fileUtilImplStringSearchable.replaceString(PATH_TEST_FILE, TEST_COUNT_STRING, "XXXXX");
        int res = fileUtilImplStringSearchable.countString(PATH_TEST_FILE, "XXXXX");
        //THEN
        Assert.assertEquals(expected, res);


    }
}