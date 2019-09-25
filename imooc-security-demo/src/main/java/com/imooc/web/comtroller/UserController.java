package com.imooc.web.comtroller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jolu
 * @create 2019-09-25 11:58
 * @package com.imooc.web.comtroller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @JsonView(User.UserSimpleView.class)
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    @GetMapping("/user")
    @GetMapping
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 0,size = 10,sort = "username,asc") Pageable pageable){
        List<User> users = new ArrayList<>(10);
        users.add(new User());
        users.add(new User());
        users.add(new User());

        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        return users;
    }



    // @PathVariable 绑定{id}=>方法参数id 如果不指定name或者value 那么参数名要一直
    //写一个正则表达式
    @JsonView(User.UserDetailView.class)
    @GetMapping("{id:\\d+}")
//    @GetMapping("/user{id}\\d+")
    //    @RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET)
    public User getInfo(@PathVariable(name = "id") String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }





}
