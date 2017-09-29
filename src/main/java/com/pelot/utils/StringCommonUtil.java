package com.pelot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hongcj
 * 2017/9/29 2:04.
 */
public class StringCommonUtil {
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static void main(String[] args) {
        System.out.println(StringCommonUtil.replaceBlank("just do it!"));
    }
}
