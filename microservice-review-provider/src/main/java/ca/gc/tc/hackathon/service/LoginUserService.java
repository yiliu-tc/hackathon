package ca.gc.tc.hackathon.service;

import ca.gc.tc.hackathon.entity.LoginUser;

import java.util.List;

public interface LoginUserService {
    public LoginUser get(Integer id);
    public List<LoginUser> list();
}
