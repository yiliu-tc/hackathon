package ca.gc.tc.hackathon.dao;

import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewDao {
    public void addReview(ReviewDTO review);
    public void addReviews(List<ReviewDTO> reviews);
    public Review findById(Integer id);
    public List<Review> findAll();
}
