package ca.gc.tc.hackathon.service.impl;

import ca.gc.tc.hackathon.dao.ReviewDao;
import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.factory.ReviewFactory;
import ca.gc.tc.hackathon.model.ReviewDTO;
import ca.gc.tc.hackathon.service.ReviewService;
import ca.gc.tc.hackathon.model.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao dao;

    @Autowired
    private ReviewFactory factory;

    @Override
    public Review add(ReviewVO review) {
        ReviewDTO dto = factory.getDTOFromVO(review);
        dao.addReview(dto);
        return factory.getEntityFromDTO(dto);
    }

    @Override
    public List<Review> add(List<ReviewVO> reviews) {
        List<ReviewDTO> dtoList = factory.getDTOListFromVOList(reviews);
        dao.addReviews(dtoList);
        return factory.getEntityListFromDTOList(dtoList);
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
