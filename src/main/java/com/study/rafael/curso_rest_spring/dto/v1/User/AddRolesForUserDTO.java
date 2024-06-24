package com.study.rafael.curso_rest_spring.dto.v1.User;

import java.util.UUID;

public class AddRolesForUserDTO {

    private String userId;
    private Long permissionId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
