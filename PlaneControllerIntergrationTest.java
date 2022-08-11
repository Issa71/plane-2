package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaneControllerIntergrationTest {

	@Autowired
	private MockMvc mvc; // used to send our test requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Plane testPlane = new Plane("Boeing", 65, 500);
		RequestBuilder req = post("/createPlane").content(this.mapper.writeValueAsString(testPlane))
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isCreated();
		Plane testSavedPlane = new Plane(1, "Boeing", 65, 500);
		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedPlane));

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}
	
	@Test
	void testGet() throws Exception {
		List<Plane> planes = List.of(new Plane(1, "Emirates", 65, 350),
				new Plane(2, "Etihad", 52, 275));

		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(planes));
		this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
	}

	@Test
	void testGetById() throws Exception {
		ResultMatcher checkBody = content()
				.json(this.mapper.writeValueAsString(new Plane(1, "Emirates", 65, 350)));

		this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
	}
	@Test
    void testUpdate() throws Exception {

		this.mvc.perform(
                patch("/update/1")
                        .param("name", "Emirates")
                        .param("size", "65")
                        .param("cost", "350"))
        .andExpect(status().isOk())
        .andExpect(content().json(this.mapper.writeValueAsString(new Plane(1, "Emirates", 65, 350))));
}



    @Test
      void testDelete() throws Exception {
        ResultMatcher checkBody = content()
                .json(this.mapper.writeValueAsString(new Plane(1, "Emirates", 65, 350)));

        this.mvc.perform(delete("/remove/1")).andExpect(status().isOk()).andExpect(checkBody);

    }
}