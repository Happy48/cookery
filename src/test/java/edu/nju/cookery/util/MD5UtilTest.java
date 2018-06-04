package edu.nju.cookery.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilTest {

    @Test
    public void encode() {

        assertEquals("95579ee4c203b5074147b50deab17d69",MD5Util.encode("123456"));
    }
}