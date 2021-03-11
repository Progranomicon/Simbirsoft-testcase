package ru.jbeking;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class NetworkingTest {
    private static final String TEST_FILENAME = "TEST.HTML";

    @Test
    public void getPage() throws MalformedURLException {
        File f = new File(TEST_FILENAME);

        if(f.exists()) f.delete();

        Networking n = new Networking(TEST_FILENAME);

        n.getPage("https://www.simbirsoft.com/");

        f = new File(TEST_FILENAME);

        Assert.assertTrue("Файл создался", f.exists());
        //Assert.assertTrue("Размер файла не нулевой", f.length()>0);
    }
}