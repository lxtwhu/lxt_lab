package com.lxt.lab.fuckzhian.pojo;

import lombok.Data;

import java.util.List;

@Data
public class VulResult {
    private String code;
    private List<VulItem> data;

}
