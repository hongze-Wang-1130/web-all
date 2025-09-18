package com.atguigu.schedule.test;

import com.atguigu.schedule.util.MD5Util;
import org.junit.jupiter.api.Test;

/**
 * ClassName:TestMD5Util
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/18 3:30
 * @Version 1.0
 */
public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
