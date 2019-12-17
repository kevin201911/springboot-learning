package com.mscloudmesh.springbootelasticsearch.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName EsModel
 * @author kevin
 * @Date 2019/12/14
 * @Description
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class EsModel {

    private String id;
    private Integer age;
    private String name;
    private Date date;
}
