package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "my_table")
public class MyTable {

    private Long id;
    private String tablesInTest;
    private String module;
    private String tableNameUpCase;
    private String tableName;

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public String getTablesInTest() {
        return tablesInTest;
    }

    public void setTablesInTest(String tablesInTest) {
        this.tablesInTest = tablesInTest;
    }
        public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
        public String getTableNameUpCase() {
        return tableNameUpCase;
    }

    public void setTableNameUpCase(String tableNameUpCase) {
        this.tableNameUpCase = tableNameUpCase;
    }
        public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
