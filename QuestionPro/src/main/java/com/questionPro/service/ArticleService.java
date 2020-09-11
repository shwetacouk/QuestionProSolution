package com.questionPro.service;

import com.questionPro.exception.ClientCallException;
import com.questionPro.model.response.BestStoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleService {

    List<BestStoryResponse> fetchBestStoriesOnScore() throws ClientCallException, InterruptedException;
    String[] fetchTopStories() throws ClientCallException, InterruptedException;
}
