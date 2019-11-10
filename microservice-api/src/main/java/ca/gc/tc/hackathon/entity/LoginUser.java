package ca.gc.tc.hackathon.entity;

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
public class LoginUser extends ResourceSupport implements Serializable {

    private Integer client_id;
    private String client_secret;
    private String user_name;
    private String authorized_grant_type;

}

