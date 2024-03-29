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
@RequestMapping("/api/v1")
@Api(value="HOSA Service", description="query rating types for HOSA Service")
public class RatingTypeController {

    @Autowired
    private RatingTypeService service;

    @CrossOrigin
    @GetMapping(value="/rating-types/{id}")
    @ApiOperation(value = "Search an Rating Type with rating type ID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get result", response = RatingType.class),
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
    @GetMapping(value="/rating-types")
    @ApiOperation(value = "View a list of available rating types", response = RatingType.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Get All Rating Types", response = RatingType.class, responseContainer = "List"),
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
                    .get(rate_type_id)).withSelfRel().withMedia("application/json").withType("GET")
                    .withTitle("Get Rating Type with ID " + rate_type_id);
            ratingType.add(selfLink);
        }
    }

}
