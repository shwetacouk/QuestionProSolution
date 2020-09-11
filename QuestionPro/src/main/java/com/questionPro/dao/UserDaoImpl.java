package com.questionPro.dao;

import com.questionPro.model.response.BestStoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    @PersistenceContext(unitName = "JPA annotation persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void saveUserDetails(List<BestStoryResponse> userDetails) {
            //entityManager.merge();
    }
}
