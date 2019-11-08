package ca.gc.tc.hackathon.dao;

import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewDao {
    public int addReview(ReviewVO review);
    public boolean addReviews(List<ReviewVO> reviews);
    public Review findById(Integer id);
    public List<Review> findAll();
}
