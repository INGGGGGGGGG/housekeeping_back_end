package com.example.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageQueryDTO implements Serializable {

    private int page;

    private int pageSize;

    private String name;

    private Integer serviceCategory;

}
