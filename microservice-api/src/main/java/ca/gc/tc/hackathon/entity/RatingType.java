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
public class RatingType extends ResourceSupport implements Serializable {

    private Integer rate_type_id;
    private String rate_type_des;

}

