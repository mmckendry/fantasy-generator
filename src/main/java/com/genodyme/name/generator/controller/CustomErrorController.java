package com.genodyme.name.generator.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to catch and redirect from routing errors
 */
@Controller
public class CustomErrorController implements ErrorController  {

  @RequestMapping("/error")
  public String handleError() {
    String redirectUrl = "http://www.martinmckendry.com";
    return "redirect:" + redirectUrl;
  }
}

