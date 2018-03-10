package com.hosuke.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Hosuke
 * 字符串辅助类 判断是否为空
 * 辅助 DateUtil类
 */
public class StringUtil {

    public static boolean isEmpty(String str){
        if("".equals(str)|| str==null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNotEmpty(String str){
        if(!"".equals(str)&&str!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(!isNum.matches()){
            return false;
        }
        return true;
    }
}
