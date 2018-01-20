package com.ny.foo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.ny.StartServer;
import com.ny.service.BarService;
import com.ny.service.FooService;
import com.ny.service.entity.FooEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartServer.class)
public class FooTest {

    Logger logger = LoggerFactory.getLogger(FooTest.class);

    @Autowired
    FooService fooService;

    @Autowired
    BarService barService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    //@Test
    //    @Transactional
    public void testList() {
        List<FooEntity> foos = fooService.findByName("test");
        foos.forEach(e -> {
                logger.debug("Foo, name:{}, createDate:{}", e.getName(), e.getCreateDate());
        });
    }

    @Test
    public void testGet() {
        FooEntity foo = fooService.get("0ec129d9-6814-4f1b-96bb-78231ceae1c3");
        logger.debug("foo.remark:{}", foo.getRemark());
    }

    //    @Test
    public void testAdd() {
        String id = fooService.add(null, null);
        FooEntity foo = fooService.get(id);
        Assert.notNull(foo, "foo not found");
    }

//    @Test
    public void testMvc() throws Exception {
        this.mockMvc.perform(get("/val?name=test&age=1"))
                .andExpect(status().isOk());
//                .andExpect(result -> System.out.println(result.getResponse().get));
    }

}
