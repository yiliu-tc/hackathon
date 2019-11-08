package ca.gc.tc.hackathon.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class ReviewVO {

    @ApiModelProperty(notes = "rating type id", example = "1")
    private Integer r_type_id;
    private String r_comment;

}

