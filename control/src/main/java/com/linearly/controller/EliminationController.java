package com.linearly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EliminationController {

      /**
     * Maps the HTTP GET request to the /elimination-module URL to the elimination-module.jte file.
     * 
     * @param Model the model object to be used in the view
     * @return String
     */
    @GetMapping("/elimination-module")
    public String loadEliminationModule(Model model) {
        return "elimination-module";
    }

}
