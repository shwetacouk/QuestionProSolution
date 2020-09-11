package com.questionPro.client;

import com.questionPro.EventCode;
import com.questionPro.exception.ClientCallException;
import com.questionPro.model.response.BestStoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Service
public class ClientServiceImpl {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("#{'${bestStory.service.base.url}'}")
    protected String bestStoryServiceBaseUrl;

    @Value("#{'${userData.service.base.url}'}")
    protected String userDataBaseUrl;

    @Value("#{'${topStories.service.base.url}'}")
    protected String topStoriesBaseUrl;

    public ClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String[] getBestStoryIds() throws ClientCallException {

        ResponseEntity<String[]> responseEntity;

        try {

            responseEntity = restTemplate.getForEntity(URI.create(format(bestStoryServiceBaseUrl)),
                    String[].class);

        } catch (Exception exc) {
            throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
        }

        if (responseEntity != null &&
                HttpStatus.Series.valueOf(responseEntity.getStatusCode()).equals(HttpStatus.Series.SUCCESSFUL)) {
           String[] bestStoryIds =responseEntity.getBody();
            return bestStoryIds;
        } else {
            throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
        }
    }

    public List<BestStoryResponse> getUserDetailsById(String[] ids) throws ClientCallException {
        ResponseEntity<BestStoryResponse> responseEntity;
        BestStoryResponse bestStoryResponse;
        List<BestStoryResponse> userDeatils =  new ArrayList<>();
        try {
            for (String id: ids) {
                System.out.println(URI.create(format("%s/%s%s", userDataBaseUrl,id,".json")));
                responseEntity = restTemplate.getForEntity(URI.create(format("%s/%s%s", userDataBaseUrl,id, ".json")),
                        BestStoryResponse.class);
                if (responseEntity != null &&
                        HttpStatus.Series.valueOf(responseEntity.getStatusCode()).equals(HttpStatus.Series.SUCCESSFUL)) {
                    bestStoryResponse=responseEntity.getBody();
                    // return bestStoryIds;
                } else {
                    throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
                }
                userDeatils.add(bestStoryResponse);
            }
        } catch (Exception exc) {
            throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
        }
        return userDeatils;
    }


    public String[] getTopStories() throws ClientCallException {
        ResponseEntity<String[]> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(URI.create(format(topStoriesBaseUrl)),
                    String[].class);
        } catch (Exception exc) {
            throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
        }
        if (responseEntity != null &&
                HttpStatus.Series.valueOf(responseEntity.getStatusCode()).equals(HttpStatus.Series.SUCCESSFUL)) {
            String[] bestStoryIds =responseEntity.getBody();
            return bestStoryIds;
        } else {
            throw new ClientCallException(EventCode.Application.ERROR_IN_BEST_FETCHING_STORYID);
        }
    }
}
