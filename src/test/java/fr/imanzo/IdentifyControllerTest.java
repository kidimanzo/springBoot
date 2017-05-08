package fr.imanzo;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.NestedServletException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IdentifyControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test(expected = NestedServletException.class)
    public void identify() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/identify/tttsfgrt").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
           // .andExpect(content().string(Matchers.equalTo("Greetings from Spring Boot!")));
    }

}
