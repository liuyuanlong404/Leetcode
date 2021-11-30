package com.rose.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created on 2021/10/15 14:50
 *
 * @author Rose
 */
public class BankCardDetectionUtil {

    /**
     * TODO
     * @param cardNo 银行卡卡号
     * @return {"bank":"CMB","validated":true,"cardType":"DC","key":"(卡号)","messages":[],"stat":"ok"}
     * 2017年5月22日 下午4:35:23
     */
    public static String getCardDetail(String cardNo) {
        // 创建HttpClient实例
        StringBuffer url = new StringBuffer("https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=");
        url.append(cardNo).append("&cardBinCheck=true");
        StringBuilder sb = new StringBuilder();
        try {
            URL urlObject = new URL(url.toString());
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ( (inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
