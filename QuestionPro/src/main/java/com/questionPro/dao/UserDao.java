package com.questionPro.dao;

import com.questionPro.model.response.BestStoryResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao {

    @Transactional
    public void saveUserDetails(List<BestStoryResponse> userDetails);
}
