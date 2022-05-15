package com.lxt.lab.sso.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UserInfo {
    private String OAId;
    private String OALoginAccount;
    private String UserNumber;
    private String family_name;
    private String given_name;
    private String name;
    private List<String> role;
    private String sub;
}
