package com.voidm.odps;

import com.aliyun.odps.udf.UDF;
import com.aliyun.odps.udf.annotation.Resolve;
import com.aliyun.odps.udf.example.speech.SpeechSentenceSnrExtractor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从 JSON 字符串中抽取 listId 数组
 *
 * @author voidm
 * @date 2019/10/8
 */
@Resolve("string->array<string>")
public class ExtractListIdsInJsonStr extends UDF {
    private final static Log logger = LogFactory.getLog(SpeechSentenceSnrExtractor.class);

    public List<String> evaluate (String jsonStr) {

        System.out.println("this is out");
        System.err.println("this is error");
        logger.info("this is logger info");
        logger.error("this is logger error");

        ArrayList<String> listIds = new ArrayList<>();
        if (jsonStr != null) {
            String regex = "\"listId\":\"([0-9]+)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher macher = pattern.matcher(jsonStr);

            while (macher.find()) {

                String val = macher.group(1).trim();
                listIds.add(val);
            }
        }
        return listIds;
    }
}
