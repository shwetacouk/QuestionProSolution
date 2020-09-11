package com.questionPro.controller;

import com.questionPro.exception.ClientCallException;
import com.questionPro.model.response.BestStoryResponse;
import com.questionPro.service.ArticleService;
import com.questionPro.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v0")
@ComponentScan("com.questionPro")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/test")
    public String test(){
        return "Hello Shweta";
    }

    @RequestMapping(value = "/best-stories", method = RequestMethod.GET)
    @ResponseBody
    public List<BestStoryResponse> getBestStory() throws InterruptedException, ClientCallException {
        List<BestStoryResponse> responses=articleService.fetchBestStoriesOnScore();
        return responses;
    }

    @RequestMapping(value = "/past-stories", method = RequestMethod.GET)
    public String[] getFestStory() throws InterruptedException, ClientCallException {
        String[] response = articleService.fetchTopStories();
        return response;
    }

    /*@RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<BestStoryResponse> getFestStory(){
        return null;
    }*/


}
