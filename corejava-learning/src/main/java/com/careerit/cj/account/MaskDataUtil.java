package com.careerit.cj.account;

public class MaskDataUtil {
    public static String maskAccountNumber(String accNumber){
        return "*****".concat(accNumber.substring(accNumber.length()-3));
    }
}
