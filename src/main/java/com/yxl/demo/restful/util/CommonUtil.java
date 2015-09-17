package com.yxl.demo.restful.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;


public class CommonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

    public static String asString(InputStream in) {
        String body = "";
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(in, writer, "UTF-8");
            body = writer.toString();
            LOG.info("convert stream to string : " + body);
        } catch (IOException e) {
            LOG.error("request asString method happend error: ", e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(writer);
        }
        return body;
    }
}
