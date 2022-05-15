package com.lxt.lab.fuckzhian.pojo;

import lombok.Data;

import java.util.List;

@Data
public class VulProcessRequest {
    private List<VulProcessItem> vulners;
}
