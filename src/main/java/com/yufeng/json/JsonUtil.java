package com.yufeng.json;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Json工具类
 * 钰丰 2018/2/5
 */
public class JsonUtil {

    public static List<String> list=new LinkedList<String>();

    /**
     * 获取JsonArray
     * @return
     */
    public static String getJsonArrayStr(){
        LinkedList<LinkedList<String>> linkedList=new LinkedList<LinkedList<String>>();

        LinkedList<String> list0=new LinkedList<String>();
        list0.add("UserId");
        list0.add("0");
        list0.add("1");

        LinkedList<String> list1=new LinkedList<String>();
        list1.add("UserName");
        list1.add("Tom");
        list1.add("Jerry");
        list1.add("Kite");
        list1.add("Lucy");

        LinkedList<String> list2=new LinkedList<String>();
        list2.add("UserSex");
        list2.add("男");
        list2.add("女");

        LinkedList<String> list3=new LinkedList<String>();
        list3.add("UserAddr");
        list3.add("北京");
        list3.add("上海");
        list3.add("广州");

        linkedList.add(list0);
        linkedList.add(list1);
        linkedList.add(list2);
        linkedList.add(list3);

        return JSONArray.fromObject(linkedList).toString();
    }

    /**
     * 从未知的JsonArray中获取LinkedList
     * @return
     */
    public static LinkedList<LinkedList<String>> getLinkedListFromJsonArray(String jsonArrayStr){

        LinkedList<LinkedList<String>> linkedList=null;
        if(jsonArrayStr!=null && jsonArrayStr.length()>0){
            JSONArray jsonArray=JSONArray.fromObject(jsonArrayStr);
            linkedList=new LinkedList<LinkedList<String>>();
            for(int i=0;i<jsonArray.size();i++){
                JSONArray array=JSONArray.fromObject(jsonArray.get(i));
                LinkedList<String> internalList=new LinkedList<String>();
                for(int j=0;j<array.size();j++){
                    internalList.add(array.get(j).toString());
                }
                linkedList.add(internalList);
            }
        }
        return linkedList;
    }

    public static void getAllKey(JSONObject jsonObject){
        Iterator<String> keys=jsonObject.keys();
        while(keys.hasNext()){
            String key=keys.next();
            if(isJsonObject(jsonObject.get(key).toString())){
                if(!key.equals("properties") && !isArrayOrObject(jsonObject.get(key).toString())) {
                    System.out.println(key);
                }
                JSONObject innerObject=JSONObject.fromObject(jsonObject.get(key));
                getAllKey(innerObject);
            }
        }
    }

    public static Boolean isJsonObject(String jsonString){
        try{
            JSONObject.fromObject(jsonString);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static Boolean isArrayOrObject(String jsonObject){
        String type=JSONObject.fromObject(jsonObject).get("type").toString();
        if(type.equals("object") || type.equals("array")){
            return true;
        }else{
            return false;
        }
    }
}
