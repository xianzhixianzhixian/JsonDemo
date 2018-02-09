package com.yufeng.jsondemo;

import com.yufeng.json.JsonUtil;
import net.sf.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用java读取内容未知的json数组，key不定、长度不定、内容不定
 * 钰丰 2018/2/5
 */
public class JsonDemo {

    public static void main(String[] args){
//        JSONObject jsonObject=JSONObject.fromObject("{\"items\": {\"type\": \"string\"}, \"type\": \"array\"}");
//        JsonUtil.getAllKey(jsonObject);
        List<String> list=new LinkedList<String>();
        add(list);
        System.out.println(list);
    }

    public static void add(List<String> list){
        list.add("hello");
        list.add("world");
    }
}
