package com.example.workship.entity;

import javax.persistence.*;

/**
 * Created by Larry on 2016/10/22.
 *           System.out.println(rs.getString("Field") + "\t:\t" + rs.getString("Comment"));
 System.out.println(rs.getString("type"));
 System.out.println(rs.getString("key"));
 System.out.println(rs.getString("null"));
 */
@Entity
public class MyTableField {

    private Long id;
    private String field;
    private String fieldUpCase;
    private String fieldType;
    private String fieldKey;
    private String fieldNull;
    private String tableName;
    private String comment;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldNull() {
        return fieldNull;
    }

    public void setFieldNull(String fieldNull) {
        this.fieldNull = fieldNull;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldUpCase() {
        return fieldUpCase;
    }

    public void setFieldUpCase(String fieldUpCase) {
        this.fieldUpCase = fieldUpCase;
    }
}
