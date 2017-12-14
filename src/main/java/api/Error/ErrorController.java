package api.Error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    public static ResponseEntity ApiError(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
