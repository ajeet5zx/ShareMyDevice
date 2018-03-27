package com.singhnextjuggernaut.ajeetkumar.sharemydevice.utils.Validations;

/**
 * Created by rahul on 23/3/18.
 */

public class Utils {

    public static boolean chkLength(String text,int minLength) {
        Boolean check=true;
        if (text.length() < minLength) {
            check=false;
        }
        return check;
    }

    public static  boolean matchPassword(String s1, String s2) {
        Boolean check = true;
        if(s1.compareTo(s1) !=0) {
            check=false;
        }
        return check;
    }
}
