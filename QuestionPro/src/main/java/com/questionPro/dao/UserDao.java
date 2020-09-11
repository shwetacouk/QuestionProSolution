package com.questionPro.dao;

import com.questionPro.model.response.BestStoryResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public void saveUserDetails(List<BestStoryResponse> userDetails);
}
