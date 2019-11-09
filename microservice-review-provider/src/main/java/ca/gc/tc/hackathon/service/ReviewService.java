package ca.gc.tc.hackathon.service;

import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewVO;

import java.util.List;

public interface ReviewService {
    public Review add(ReviewVO review);
    public List<Review> add(List<ReviewVO> reviews);
    public Review get(Integer id);
    public List<Review> list();
}
