package pl.camelsoftware.robotic_code_representation.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.camelsoftware.robotic_code_representation.repository.RcrStorage;

import java.util.Map;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CommandControllerTest {
    @Autowired
    private CommandController commandController;

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private RcrStorage rcrStorage;

    @Captor
    private ArgumentCaptor<Map<String, String>> captor;

    @Test
    public void shouldSaveProperCommands() throws Exception {
        String jsonRequest = "{ \"commands\": [\"LEFT\", \"GRAB\", \"LEFT\", \"BACK\", \"LEFT\", \"BACK\", \"LEFT\"] }";

        mockMvc.perform(post("/commands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());

        verify(rcrStorage, atLeastOnce()).save(captor.capture());
        Map<String, String> actual = captor.getValue();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(3, actual.size());
        Assertions.assertEquals("1", actual.get("LEFT"));
        Assertions.assertEquals("01", actual.get("BACK"));
        Assertions.assertEquals("00", actual.get("GRAB"));
    }
}