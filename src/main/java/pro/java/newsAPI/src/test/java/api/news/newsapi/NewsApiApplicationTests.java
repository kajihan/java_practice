package api.news.newsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class NewsApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTopNews_shouldReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/news/top"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getTopNews_shouldReturnTopNewsContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/news/top"))
                .andReturn().getResponse().getContentAsString();
    }
}
