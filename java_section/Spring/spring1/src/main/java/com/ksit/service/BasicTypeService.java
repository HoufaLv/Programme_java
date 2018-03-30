package com.ksit.service;

import com.ksit.dao.ProductDao;

import java.util.*;


public class BasicTypeService {

    private Integer id;
    private List<String> nameList;
    private Properties properties;
    private Set<String> nameSet;
    private Map<String,ProductDao> nameMap;

    public void showData(){
        System.out.println("id = " + id);

        for (String s :
                nameList) {
            System.out.println(s);
        }

        System.out.println("--------------");

        for (String s :
                nameSet) {
            System.out.println(s);
        }

        //遍历properties
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = properties.get(key);
            System.out.println("key: " + key + " values: " + value);
        }

        //遍历map
        for (Map.Entry<String, ProductDao> entry : nameMap.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setNameSet(Set<String> nameSet) {
        this.nameSet = nameSet;
    }

    public void setNameMap(Map<String, ProductDao> nameMap) {
        this.nameMap = nameMap;
    }
}
