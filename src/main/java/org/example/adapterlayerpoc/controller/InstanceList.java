package org.example.adapterlayerpoc.controller;

import lombok.Data;

@Data
public class InstanceList {
    private String key;
    private Object value;
    public InstanceList(String key, Object value){
        this.key = key;
        this.value = value;
    }
}
