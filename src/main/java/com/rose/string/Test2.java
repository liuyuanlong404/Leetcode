package com.rose.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rose.util.BankCardDetectionUtil;
import lombok.Data;

/**
 * Created on 2021/11/4 17:53
 *
 * @author Rose
 */
public class Test2 {

    @Data
    public static class Bank{
        private String cardType;
        private String bank;
        private String key;
        private String[] messages;
        private Boolean validated;
        private String stat;
    }

    public static void main(String[] args) {

        String cardDetail = BankCardDetectionUtil.getCardDetail("6217903600001081560");
        System.out.println(cardDetail);
        Bank bank = JSONObject.parseObject(cardDetail, Test2.Bank.class);
        System.out.println(bank);
    }
}
