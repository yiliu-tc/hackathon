package ca.gc.tc.hackathon.service.impl;

import ca.gc.tc.hackathon.dao.LoginUserDao;
import ca.gc.tc.hackathon.entity.LoginUser;
import ca.gc.tc.hackathon.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserDao dao;

    @Override
    public LoginUser get(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<LoginUser> list() {
        return dao.findAll();
    }
}
