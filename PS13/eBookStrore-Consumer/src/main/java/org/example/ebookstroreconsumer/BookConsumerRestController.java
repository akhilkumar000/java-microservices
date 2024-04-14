package org.example.ebookstroreconsumer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class BookConsumerRestController {
    private final RestTemplate restTemplate;

    public BookConsumerRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public  String getBooks(){
        String bookServiceUrl="http://book-service/books/1";
        return restTemplate.getForObject(bookServiceUrl,String.class);
    }
}
