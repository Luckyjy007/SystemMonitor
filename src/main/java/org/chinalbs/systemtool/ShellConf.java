package org.chinalbs.systemtool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Create by jiangyun on 2018/2/11
*/
public class ShellConf {
    private static final Logger logger = LoggerFactory.getLogger(ShellConf.class);
    private static Map ShellParams = null;

    public static synchronized Map getShellParams() {
        if (ShellParams == null) {
            ShellParams = new HashMap<String, String>(10);
        }
        InputStream inputStream = ShellConf.class.getClassLoader().getResourceAsStream(Constant.SHELLLOGIN_PROP);
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error loading shell configuration file information");
            throw new RuntimeException(e);
        }
        ShellParams.putAll(p);
        return ShellParams;
    }

}
