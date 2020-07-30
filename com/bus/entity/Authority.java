package com.bus.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Data
@ToString
public class Authority {
    private Integer authorityId;
    private String level;
    private String purl;
    private  Integer ismenu;
    private Integer parentid;
    private String pinfo;
    private HashMap<String ,Integer> map;

    private  List<Authority> list;

    public Authority() {
    }

    public Authority(Integer authorityId) {

        this.authorityId = authorityId;
    }

    public Authority(String pinfo) {
        this.pinfo = pinfo;
    }

    public Authority(Integer authorityId, String pinfo) {
        this.authorityId = authorityId;
        this.pinfo = pinfo;
    }


}
