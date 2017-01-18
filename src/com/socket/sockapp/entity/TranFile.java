package com.socket.sockapp.entity;

import java.io.Serializable;

/**
 * Created by admin on 2017/1/10.
 */
public class TranFile implements Serializable{
    private int id;
    private String name;
    private byte[] content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
