package com.example.bean;

import org.junit.jupiter.api.Test;

public class SearchReqTest {

    @Test
    public void testBean(){
        SearchReq searchReq = new SearchReq();
        System.out.println(searchReq.getSearchParam());
        System.out.println(searchReq.getNumber());
        System.out.println(searchReq.isValid());
    }
}

