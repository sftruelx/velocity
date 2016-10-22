package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_role")
public class UserRole {

    private Long userId;
    private Long roleId;

        public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
        public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
