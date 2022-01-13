package com.bezkoder.spring.jpa.postgresql;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class JacocoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception {
        mvc.perform(get("/api/t00")
                        .param("n", "3"))
//                .andExpect((ResultMatcher) content().string("hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSingle() throws Exception {
        mvc.perform(get("/api2/6")
                        .param("id", "6")
                        .contentType(MediaType.APPLICATION_JSON)
                )

//                .andExpect((ResultMatcher) content().string("hello"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    MockHttpServletResponse response=result.getResponse();
                    log.info("Test:" + response.getContentAsString());

                })
        ;
    }



    @Test
    public void testMulti() throws Exception {
        mvc.perform(get("/api2/byTitle")
                        .param("title", "JPA")
                        .contentType(MediaType.APPLICATION_JSON)
                )

//                .andExpect((ResultMatcher) content().string("hello"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    MockHttpServletResponse response=result.getResponse();
                    log.info("Test:" + response.getContentAsString());
                })
        ;
    }

}
