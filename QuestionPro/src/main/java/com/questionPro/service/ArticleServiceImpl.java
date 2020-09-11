package com.questionPro.service;

import com.questionPro.client.ClientServiceImpl;
import com.questionPro.dao.UserDao;
import com.questionPro.dao.UserDaoImpl;
import com.questionPro.exception.ClientCallException;
import com.questionPro.model.response.BestStoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(value = "best-stories", key = "#root.methodName")
    public List<BestStoryResponse> fetchBestStoriesOnScore() throws ClientCallException, InterruptedException {
        Thread.sleep(3000);
        String[] bestStoryIds =clientService.getBestStoryIds();
        String[] Ids = clientService.getBestStoryIds();
        System.out.println("ID Count" +Arrays.stream(Ids).count());
        List<BestStoryResponse> userDetails = getDetailsById(Ids);
        userDao.saveUserDetails(userDetails);
        return userDetails;
    }

    @Override
    public String[] fetchTopStories() throws ClientCallException, InterruptedException {
        String[] bestStoryIds =clientService.getBestStoryIds();
        return bestStoryIds;
    }

    private List<BestStoryResponse> getDetailsById(String[] ids) throws ClientCallException {
        List<BestStoryResponse> userDetails = clientService.getUserDetailsById(ids);
        return userDetails;
    }
}
