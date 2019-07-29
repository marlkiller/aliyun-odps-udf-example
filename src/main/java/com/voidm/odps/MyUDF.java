package com.voidm.odps;

import com.aliyun.odps.udf.UDF;
import com.aliyun.odps.udf.local.LocalRunException;

/**
 * @author voidm
 */
public class MyUDF extends UDF {
    public String evaluate(String s) {
        return "hello world:" + s;
    }

    public static void main(String[] args) throws LocalRunException {

    }
}