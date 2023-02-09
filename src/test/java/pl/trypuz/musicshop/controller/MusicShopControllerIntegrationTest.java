package pl.trypuz.musicshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.trypuz.musicshop.repository.LongPlayRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class MusicShopControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LongPlayRepository repo;

    @Test
    public void shouldReturnHello() throws Exception {
        // given
        String expectedContent = "hello";

        // when
        MvcResult mcvResult = this.mockMvc.perform(get("/api/hello")).andReturn();

        // then
        MockHttpServletResponse response = mcvResult.getResponse();
        String content = response.getContentAsString();
        int status = response.getStatus();

        assertEquals(expectedContent, content);
        assertEquals(200, status);
    }

    @Test
    public void shouldSaveLongPlay() throws Exception {
        //when
        MvcResult mcvResult = this.mockMvc.perform(post("/api/longplay/MuddyGrooze")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mcvResult.getResponse().getStatus();

        //then
        assertEquals(200, status);
        assertEquals(1, repo.findAll().size());
    }
}
