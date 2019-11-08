package ca.gc.tc.hackathon.service;

import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewVO;

import java.util.List;

public interface ReviewService {
    public int add(ReviewVO review);
    public boolean add(List<ReviewVO> reviews);
    public Review get(Integer id);
    public List<Review> list();
}
