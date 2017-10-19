package com.pelot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017/9/29 2:04.
 */
public class StringCommonUtil {
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            String s = "\\s*|\t|\r|\n";
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static void main(String[] args) {
        System.out.println(StringCommonUtil.replaceBlank("just do it!"));
    }
}
