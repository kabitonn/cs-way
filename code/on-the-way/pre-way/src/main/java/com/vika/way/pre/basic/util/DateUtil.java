package com.vika.way.pre.basic.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author chenwei.tjw
 * @date 2022/8/30
 **/
public class DateUtil {
    private static final String NUMBERS_COMMAS_REGEX = "^[0-9]*$";
    private static final String CST_TIME_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static boolean dateTimeCompare(Object startTime, Object endTime,Integer day) {
        if(Objects.isNull(startTime) || Objects.isNull(endTime) ||Objects.isNull(day) ){
            ;
        }
        Long start = getLongTime(startTime);
        Long end = getLongTime(endTime);
        Long threshold = Long.valueOf(24*60*60*day*1000);

        return end-start<=threshold;
    }


    private static Long getLongTime(Object startTime) {
        Long start = null;

        if( startTime instanceof Date){
            start = ((Date) startTime).getTime();
        }else if(startTime instanceof Long) {
            start = ((Long) startTime).longValue();
        }if(startTime instanceof String){
            String time  = (String) startTime;
            try{
                //处理 时间戳 格式String
                Pattern pattern = Pattern.compile(NUMBERS_COMMAS_REGEX);
                boolean matches = pattern.matcher(time).matches();
                if(matches){

                    long longTime = Long.parseLong((String) startTime);
                    start = longTime;
                }else{
                    //处理"Wed Mar 02 10:11:58 CST 2022" 格式String
                    try{
                        DateFormat formate = new SimpleDateFormat(CST_TIME_FORMAT, Locale.ENGLISH);
                        Date date = formate.parse(time);
                        long longTime = date.getTime();
                        start = longTime;
                    }catch (Exception e){
                        //do nothing,try next
                    }
                    //处理"2022-04-16 18:28:01"  格式String


                }
            }catch (Throwable e){
                throw new RuntimeException();
            }
        }
        return start;
    }

    public static void main(String[] args) {
        boolean t = DateUtil.dateTimeCompare("Fri Aug 05 12:28:41 CST 2022", "1658370521000", 15);
        System.out.println("1661961600000".compareTo("1661961600000L"));
    }
}
