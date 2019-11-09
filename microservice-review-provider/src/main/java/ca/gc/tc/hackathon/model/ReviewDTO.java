package ca.gc.tc.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class ReviewDTO {

    private Integer r_id;
    private Integer r_type_id;
    private String r_comment;
}
