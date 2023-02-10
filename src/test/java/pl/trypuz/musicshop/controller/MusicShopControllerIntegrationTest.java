package pl.trypuz.musicshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.trypuz.musicshop.dto.LongPlayDto;
import pl.trypuz.musicshop.entity.LongPlayEntity;
import pl.trypuz.musicshop.repository.LongPlayRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class MusicShopControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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
        // when
        MvcResult mvcResult = this.mockMvc.perform(post("/api/longplay/Grooze/MuddyGrooze")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        // then
        assertEquals(200, status);
        assertEquals(1, repo.findAll().size());
    }

    @Test
    public void shouldGetAllSavedEntities() throws Exception {
        // given
        repo.save(new LongPlayEntity("Bandera", "PoBandzie"));

        // when
        MvcResult mvcResult = this.mockMvc.perform(get("/api/longplay")).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<LongPlayDto> dtos = Arrays.asList(objectMapper.readValue(contentAsString, LongPlayDto[].class));

        // then
        assertEquals(1, dtos.size());
        assertEquals("Bandera", dtos.stream().findFirst().get().getAlbumName());
    }
}
