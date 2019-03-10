package ltd.idcu.mock.testapi;

import ltd.idcu.http.Req;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private LinkedMultiValueMap<String, String> params;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        params = new LinkedMultiValueMap<String, String>();
    }

    @After
    public void tearDown() {
    }

    /**
     * 1、mockMvc.perform执行一个请求
     * 2、MockMvcRequestBuilders.get("/abc")构造一个请求
     * 3、ResultActions.param("", "")添加请求传值
     * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE)设置返回类型
     * 5、ResultActions.andExpect()添加执行完成后的断言
     * 6、ResultActions.andDo()添加一个结果处理器，表述要对结果做点什么事情
     * 7、ResultActions.andReturn()表示执行完成后返回相应的信息
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        params.add("name", "idcu");
        MvcResult mvcResult = mockMvc
                .perform(Req.build("/hello", params, HttpMethod.GET, MediaType.TEXT_HTML_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("hello lyy"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

//        MvcResult mvcResult = mockMvc
//                .perform(MockMvcRequestBuilders.get("/hello")
//                .param("name", "lyy")
//                .accept(MediaType.TEXT_HTML_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("hello lyy1"))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();

        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();

        //断言，判断返回代码是否正确
        Assert.assertEquals(200, status);
        //断言，判断返回的值是否正确
        Assert.assertEquals("hello lyy", content);
    }
}