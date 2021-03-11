package ru.jbeking;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import java.util.HashMap;

public class ParseTest {
    private static final String TEST_FILENAME = "TEST.HTML";

    @Test
    public void go() throws IOException {
        Networking n = new Networking(TEST_FILENAME);
        n.getPage("https://www.simbirsoft.com");
        Parse p = new Parse(TEST_FILENAME);
        HashMap<String, Long> h =  p.go();
        Long expected =  h.get("года");
        Assert.assertTrue("года - 3", expected == 3); //Я знаю, не надёжно опираться на данные чужого сайта, но это мой первый тест
    }
}