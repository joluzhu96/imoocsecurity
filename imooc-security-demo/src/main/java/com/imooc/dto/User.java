package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author jolu
 * @create 2019-09-25 14:28
 * @package com.imooc.dto
 */
public class User {
    //通过接口实现jsonview

    public  interface UserSimpleView{};
    public  interface UserDetailView extends UserSimpleView{};

    @JsonView(value = UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
