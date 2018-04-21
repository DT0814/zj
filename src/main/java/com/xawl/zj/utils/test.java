package com.xawl.zj.utils;

import org.junit.Test;

public class test {
    @Test
    public void fun1() {
        String a = "fdsa=123123";
        System.out.println(a.substring(a.indexOf("=") + 1));
    }

}
