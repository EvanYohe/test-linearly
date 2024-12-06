package com.linearly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * Maps the HTTP GET request to the root URL to the index.jte file.
     * 
     * @param Model the model object to be used in the view
     * @return String
     */
    @GetMapping("/")
    public String index(Model Model) {
        return "index";
    }

    /**
     * Maps the HTTP GET request to the /error URL to the error.jte file.
     * 
     * @param Model the model object to be used in the view
     * @return String
     */
    @GetMapping("/error")
    public String error(Model Model) {
        return "error";
    }
}
