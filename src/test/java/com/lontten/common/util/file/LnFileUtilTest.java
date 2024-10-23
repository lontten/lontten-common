package com.lontten.common.util.file;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LnFileUtilTest {

    @Test
    void getSuffix() {
        assertEquals("txt", LnFileUtil.getSuffix("abc.txt"));
        assertEquals("", LnFileUtil.getSuffix("abc"));
    }

    @Test
    void getName() {
        assertEquals("abc", LnFileUtil.getName("abc.txt"));
        assertEquals("abc", LnFileUtil.getName("abc"));
    }

    @Test
    void testGetSuffix() {
        assertEquals("txt", LnFileUtil.getSuffix(new File("abc.txt")));
        assertEquals("", LnFileUtil.getSuffix(new File("abc")));
    }

    @Test
    void testGetName() {
        assertEquals("abc", LnFileUtil.getName(new File("abc.txt")));
        assertEquals("abc", LnFileUtil.getName(new File("abc")));
    }
}