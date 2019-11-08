package ca.gc.tc.hackathon.entity;

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
public class Review extends ResourceSupport implements Serializable {

    private Integer r_id;
    private RatingType r_type;
    private String r_comment;

}

