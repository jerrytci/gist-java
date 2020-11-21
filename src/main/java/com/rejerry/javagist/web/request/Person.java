package com.rejerry.javagist.web.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    private String name;
    private String word;
    private String sex;
    private short age;

}
