package com.imooc.dto;

/**
 * @author jolu
 * @create 2019-09-25 14:42
 * @package com.imooc.dto
 */
public class UserQueryCondition {
    private String username;
    private Integer age;
    private Integer ageTo;

    private String other;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserQueryCondition() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
