package com.lxt.lab.fuckzhian.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VulItem {
    private String affected;
    private String createTime;
    private BigDecimal cvssScore2;
    private String filePath;
    private String mavenArtifact;
    private String mavenGroup;
    private String mavenVersion;
    private String modName;
    private String repairDeadline;
    private String serverity2;
    private String vulnerDesc;
    private String vulnerNm;
}
