package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "role")
public class Role {

    private Long id;
    private String description;
    private String name;
    private Long user;

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
