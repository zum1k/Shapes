package com.epam.training.factory.filemanager;

import com.epam.training.exception.FileManagerException;
import org.junit.rules.ExpectedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FileManagerImplTest {
    private final FileManagerImpl fileManager = new FileManagerImpl();

    @Test
    public void testReadStrings() throws FileManagerException {
        //given
        String path = "src/test/resources/Points.txt";
        int fileStrings = 7;
        //when
        List<String> list = fileManager.readStrings(path);
        int resultSize = list.size();
        //then
        Assert.assertEquals(fileStrings, resultSize);
    }

    @Test(expectedExceptions = FileManagerException.class)
    public void testTestReadStrings() throws FileManagerException {
        //given
        String path = "src/test/resources/qwe.txt";
        //when
        List<String> list = fileManager.readStrings(path);


    }
}