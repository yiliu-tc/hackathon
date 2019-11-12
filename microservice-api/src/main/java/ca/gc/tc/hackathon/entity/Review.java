package ca.gc.tc.hackathon.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Review extends ResourceSupport implements Serializable {

    @ApiModelProperty(notes = "review id", example = "1")
    private Integer r_id;
    private RatingType r_type;
    @ApiModelProperty(notes = "review comment", example = "I like this service")
    private String r_comment;
    @ApiModelProperty(notes = "review date", example = "2019-01-01")
    private Date r_date;

}

