package ca.gc.tc.hackathon.controller;

import ca.gc.tc.hackathon.entity.RatingType;
import ca.gc.tc.hackathon.entity.Review;
import ca.gc.tc.hackathon.service.ReviewService;
import ca.gc.tc.hackathon.model.ReviewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(value="yiliu_hackathon", description="Operations review for yi liu hackathon")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @CrossOrigin
    @PostMapping(value="/review")
    @ApiOperation(value = "Add an Review", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Add"),
            @ApiResponse(code = 201, message = "Successfully Add"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public int add(@RequestBody ReviewVO review){
        return service.add(review);
    }

    @CrossOrigin
    @PostMapping(value="/reviews")
    @ApiOperation(value = "Add Reviews", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Add"),
            @ApiResponse(code = 201, message = "Successfully Add"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public boolean add(@RequestBody List<ReviewVO> reviews){
        return service.add(reviews);
    }

    @CrossOrigin
    @GetMapping(value="/reviews/{id}")
    @ApiOperation(value = "Search an Review with review ID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get result"),
            @ApiResponse(code = 201, message = "Successfully get result"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Review get(@PathVariable("id") Integer id){
        Review review = service.get(id);
        configHateoasLink(review);
        return review;
    }

    @CrossOrigin
    @GetMapping(value="/reviews")
    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Get All Reviews"),
            @ApiResponse(code = 201, message = "Successfully Get All Reviews"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Review> list(){
        List<Review> reviews = service.list();
        for (Review review : reviews) {
            configHateoasLink(review);
        }
        return reviews;
    }

    private void configHateoasLink(Review review) {
        if (review != null) {
            Link selfLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ReviewController.class)
                    .get(review.getR_id())).withSelfRel();
            review.add(selfLink);
            RatingType ratingType = review.getR_type();
            if (ratingType != null) {
                Link ratingTypeLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(RatingTypeController.class)
                        .get(ratingType.getRate_type_id())).withSelfRel();
                ratingType.add(ratingTypeLink);
            }
        }
    }

}
