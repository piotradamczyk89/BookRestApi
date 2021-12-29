package pl.coderslab.models;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data

public class JsonResponse {

    private HttpStatus status;
    private String message;

    public JsonResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
