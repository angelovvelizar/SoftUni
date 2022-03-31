package com.example.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserAndProductDto {
    @Expose
    private Integer usersCount;

    @Expose
    private Set<UserInfoDto> users;

    public UserAndProductDto() {
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserInfoDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserInfoDto> users) {
        this.users = users;
    }
}
