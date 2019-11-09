package ca.gc.tc.hackathon.service.impl;

import ca.gc.tc.hackathon.model.ReviewVO;
import ca.gc.tc.hackathon.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public String validateReview(ReviewVO vo) {
        if (vo == null) {
            return "Review can not be empty";
        }
        if (vo.getR_type_id() > 3) {
            return "Invalid r_type_id";
        }
        if (vo.getR_comment() != null && vo.getR_comment().length() > 255) {
            return "Comment Length Over Limit. MAX 255";
        }
        return null;
    }

    @Override
    public String validateReviews(List<ReviewVO> reviews) {
        int count = 0;
        for (ReviewVO vo : reviews) {
            count ++;
            String result = validateReview(vo);
            if (result != null) {
                return "Record " + count + ": " + result;
            }
        }
        return null;
    }
}
