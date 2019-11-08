package ca.gc.tc.hackathon.service.impl;

import ca.gc.tc.hackathon.dao.ReviewDao;
import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.service.ReviewService;
import ca.gc.tc.hackathon.model.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao dao;

    @Override
    public int add(ReviewVO review) {
        return dao.addReview(review);
    }

    @Override
    public boolean add(List<ReviewVO> reviews) {
        return dao.addReviews(reviews);
    }

    @Override
    public Review get(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Review> list() {
        return dao.findAll();
    }
}
