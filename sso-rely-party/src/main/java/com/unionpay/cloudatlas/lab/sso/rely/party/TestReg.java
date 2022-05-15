package com.lxt.lab.sso.rely.party;

import java.util.regex.Pattern;

public class TestReg {
    public static void main(String[] args) {

        String orderBy = args[0];
        System.out.println(orderBy);


        String regx = "\\s*\\w+(( |\\t)+(asc|desc|ASC|DESC))?\\s*(,\\s*\\w+(( |\\t)+(asc|desc|ASC|DESC))?\\s*)*";
        if(!Pattern.matches(regx,orderBy)){
            System.out.println("不通过");
        } else {
            System.out.println("通过");
        }
        return;
    }
}
