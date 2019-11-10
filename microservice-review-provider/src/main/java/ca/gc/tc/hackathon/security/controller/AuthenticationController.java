package ca.gc.tc.hackathon.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @CrossOrigin()
    @GetMapping(value="/login")
    public ResponseEntity<Boolean> login1() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
