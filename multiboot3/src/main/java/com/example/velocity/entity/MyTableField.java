package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "my_table_field")
public class MyTableField {

    private Long id;
    private String comment;
    private String field;
    private String fieldKey;
    private String fieldNull;
    private String fieldType;
    private String tableName;
    private String fieldUpCase;

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
        public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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
        public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
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
