package com.questionPro.dao;

import com.questionPro.model.response.BestStoryResponse;

import java.util.List;

public interface UserDao {

    public void saveUserDetails(List<BestStoryResponse> userDetails);
}
