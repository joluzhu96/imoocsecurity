package com.imooc.web.comtroller;

import com.jayway.jsonpath.JsonPath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 25, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenQuerySucess() {
        try {
            String contentAsString = mockMvc.perform(
                    MockMvcRequestBuilders.get("/user")
                            .param("username", "zjl")
                            .param("age", "18")
                            .param("ageTo", "100")
                            .param("other", "man")
//                            .param("size", "15")
//                            .param("page", "3")
//                            .param("sort", "age,desc")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                    .andReturn().getResponse().getContentAsString();

            System.out.println(contentAsString);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGetInfoSucess(){
        try {
            String contentAsString = mockMvc.perform(
                    MockMvcRequestBuilders.get("/user/1")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)

            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                    .andReturn().getResponse().getContentAsString();

            System.out.println(contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGetInfoFail(){
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/user/a")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
            ).andExpect(MockMvcResultMatchers.status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreateSuccess() {
        String content = "{\"username\":\"tom\",\"password\":\"1688\"}";
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/user")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath(".jd").value("1"));
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
