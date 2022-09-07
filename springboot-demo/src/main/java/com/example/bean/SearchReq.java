package com.example.bean;

import lombok.Data;

@Data
public class SearchReq {
    private String searchParam;
    private int number;
    private boolean valid;
}

