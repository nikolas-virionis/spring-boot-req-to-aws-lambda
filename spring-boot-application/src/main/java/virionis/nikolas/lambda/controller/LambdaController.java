package virionis.nikolas.lambda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import virionis.nikolas.lambda.client.LambdaClient;
import virionis.nikolas.lambda.model.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Nikolas B Virionis (nikolas.virionis@sptech.school)
 */
@RestController
@RequestMapping("/lambda")
public class LambdaController {

    @Autowired
    private LambdaClient lambdaClient;

    /**
     * example of request sent into this endpoint
     * {
     * "info": "Request From lambda"
     * }
     * 
     * @param test {@link Test}
     * @return
     */
    @PostMapping("/old")
    public ResponseEntity<Object> postMethodName(@RequestBody Test test) {
        // Lambda Function URL (can get it in the AWS Lambda console)
        String url = "<LAMBDA FUNCTION URL>";

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Request Body (JSON)
        Map<String, Object> map = new HashMap<>();
        map.put("info", test.getInfo());

        // The request itself and its response
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Test> response = new RestTemplate().postForEntity(url, entity, Test.class);

        // getting information from the body of the response from lambda
        Test testResult = response.getBody();

        return ResponseEntity.status(200).body(testResult);
    }

    /**
     * example of request sent into this endpoint
     * {
     * "info": "Request From lambda"
     * }
     * 
     * @param test {@link Test}
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> postFeign(@RequestBody Test test) {

        Test response = lambdaClient.test(test);

        // getting information from the body of the response from lambda

        return ResponseEntity.status(200).body(response);
    }

}
