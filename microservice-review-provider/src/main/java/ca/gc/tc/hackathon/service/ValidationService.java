package ca.gc.tc.hackathon.service;

import ca.gc.tc.hackathon.model.ReviewVO;

import java.util.List;

public interface ValidationService {

    public String validateReview(ReviewVO vo);

    public String validateReviews(List<ReviewVO> reviews);
}
