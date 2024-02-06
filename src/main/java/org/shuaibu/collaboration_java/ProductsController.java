package org.shuaibu.collaboration_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/")
    public String greeting(){
        return "Hello,  Coders";
    }
}
