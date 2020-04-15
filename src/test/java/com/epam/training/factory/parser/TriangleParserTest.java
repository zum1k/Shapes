package com.epam.training.factory.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserTest {
    private final String s1 = "0 0  0  3  4 0";
    private final String s2 = "0 0 0 6 8 0";
    private final String s3 = "10 12 25 32  45 44";
    private final String s4 = "123 asdad 213 1 31 a ";
    private final String s5 = "1 2 3 4 5";

    private final List<String> strings = new ArrayList<>();
    {
        strings.add(s1);
        strings.add(s2);
        strings.add(s3);
        strings.add(s4);
        strings.add(s5);
    }

    @Test
    public void testParseStrings_InitialStringsFive_ResultThree_True() {
        //given
        TriangleParser triangleParser = new TriangleParser();
        int parsedSize = 3;
        //when
        int resultSize = triangleParser.parseStrings(strings).size();
        //then
        Assert.assertEquals(parsedSize, resultSize);
    }
}