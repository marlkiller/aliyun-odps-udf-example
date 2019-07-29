package com.aliyun.odps.examples.udf.test;

import com.aliyun.odps.examples.TestUtil;
import com.aliyun.odps.udf.local.LocalRunException;
import com.aliyun.odps.udf.local.runner.BaseRunner;
import com.aliyun.odps.udf.local.runner.UDFRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author voidm
 * @date 2019-07-29
 */
public class MyUDFTest {

    @BeforeClass
    public static void initWarehouse() {
        TestUtil.initWarehouse();
    }


    @Test
    public void test () throws LocalRunException {

        BaseRunner runner = new UDFRunner(null, "com.voidm.odps.MyUDF");
        runner.feed(new Object[] { "one"}).feed(new Object[] { "three" });
        List<Object[]> out = runner.yield();
        for (Object[] objects : out) {
            System.out.println(Arrays.toString(objects));
        }
    }
}