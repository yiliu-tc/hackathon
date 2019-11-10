package ca.gc.tc.hackathon.dao;

import ca.gc.tc.hackathon.entity.LoginUser;
import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginUserDao {
    public LoginUser findById(Integer id);
    public List<LoginUser> findAll();
}
