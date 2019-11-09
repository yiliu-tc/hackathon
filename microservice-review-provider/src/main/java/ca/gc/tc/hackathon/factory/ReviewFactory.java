package ca.gc.tc.hackathon.factory;

import ca.gc.tc.hackathon.entity.RatingType;
import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.model.ReviewDTO;
import ca.gc.tc.hackathon.model.ReviewVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewFactory {

    public ReviewDTO getDTOFromVO(ReviewVO vo) {

        ReviewDTO review = new ReviewDTO();
        review.setR_comment(vo.getR_comment());
        review.setR_type_id(vo.getR_type_id());

        return review;
    }

    public List<ReviewDTO> getDTOListFromVOList(List<ReviewVO> voList) {
        List<ReviewDTO> dtoList = new ArrayList<>();
        for (ReviewVO vo : voList) {
            dtoList.add(getDTOFromVO(vo));
        }
        return dtoList;
    }

    public Review getEntityFromDTO(ReviewDTO dto) {
        Review review = new Review();
        review.setR_id(dto.getR_id());
        review.setR_comment(dto.getR_comment());
        review.setR_type(new RatingType().setRate_type_id(dto.getR_type_id()));
        return review;
    }

    public List<Review> getEntityListFromDTOList(List<ReviewDTO> dtoList) {
        List<Review> reviews = new ArrayList<>();

        for (ReviewDTO dto: dtoList) {
           reviews.add(getEntityFromDTO(dto));
        }
        return reviews;
    }
}
