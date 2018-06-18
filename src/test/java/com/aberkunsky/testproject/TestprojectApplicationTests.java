package com.aberkunsky.testproject;

import com.aberkunsky.testproject.controller.RegistrationController;
import com.aberkunsky.testproject.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestprojectApplicationTests {

    @Autowired
    RegistrationController registrationController;

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        assertThat(registrationController).isNotNull();
    }

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void createUser(){
        String input = "{\n" +
                "\"firstName\":\"aleksey\",\n" +
                "\"lastName\":\"berkunsky\",\n" +
                "\"userName\":\"mamoru\",\n" +
                "\"password\":\"qerqwerqe\"\n" +
                "}";
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(input, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(createURLWithPort("/userservice/register"), HttpMethod.POST, entity, String.class);
//        restTemplate.postForEntity("http://localhost:"+port+"/userservice/register/",)
        System.out.println(exchange);
        assertThat(exchange.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
