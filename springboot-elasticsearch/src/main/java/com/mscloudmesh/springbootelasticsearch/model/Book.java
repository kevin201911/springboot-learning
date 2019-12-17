package com.mscloudmesh.springbootelasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Book
 * @author kevin
 * @Date 2019/12/14
 * @Description
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Book {
    String id;
    String name;
    String message;
    Double price;
    Date creatDate;

}
