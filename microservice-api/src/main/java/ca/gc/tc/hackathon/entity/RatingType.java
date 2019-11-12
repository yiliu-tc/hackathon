package ca.gc.tc.hackathon.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class RatingType extends ResourceSupport implements Serializable {

    @ApiModelProperty(notes = "rating type id", example = "1")
    private Integer rate_type_id;
    @ApiModelProperty(notes = "rating type description", example = "Excellent")
    private String rate_type_des;

}

