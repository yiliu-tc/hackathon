package ca.gc.tc.hackathon.controller;

import ca.gc.tc.hackathon.entity.RatingType;
import ca.gc.tc.hackathon.service.RatingTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rating-types")
@Api(value="yiliu_hackathon", description="query rating types for yi liu hackathon")
public class RatingTypeController {

    @Autowired
    private RatingTypeService service;

    @CrossOrigin
    @GetMapping(value="/{id}")
    @ApiOperation(value = "Search an Rating Type with rating type ID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get result"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<RatingType> get(@PathVariable("id") Integer id){
        RatingType ratingType = service.get(id);
        configHateoasLink(ratingType, id);
        return new ResponseEntity<>(ratingType, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value="/")
    @ApiOperation(value = "View a list of available rating types", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Get All Rating Types"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<RatingType>> list(){
        List<RatingType> ratingTypes = service.list();
        for (RatingType ratingType : ratingTypes) {
            configHateoasLink(ratingType, ratingType.getRate_type_id());
        }
        return new ResponseEntity<>(ratingTypes, HttpStatus.OK);
    }

    private void configHateoasLink(RatingType ratingType, Integer rate_type_id) {
        if (ratingType != null) {
            Link selfLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(RatingTypeController.class)
                    .get(rate_type_id)).withSelfRel();
            ratingType.add(selfLink);
        }
    }

}
