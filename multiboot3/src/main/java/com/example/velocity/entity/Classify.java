package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "classify")
public class Classify {

    private Long id;
    private Long parentId;
    private Long level;
    private String title;
    private String imgUrl;
    private String imgPath;
    private Date createTm;
    private String end;

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
        public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
        public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
        public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
        public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
        public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }
        public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
