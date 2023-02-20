package pl.trypuz.musicshop.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.trypuz.musicshop.exception.AlbumNotFoundException;
import pl.trypuz.musicshop.model.BasicError;

@ControllerAdvice
public class MusicShopExceptionHandler {

    @ExceptionHandler(value = AlbumNotFoundException.class)
    public ResponseEntity<BasicError> handleAlbumNotFound(RuntimeException exception) {
        //TODO: Coś do zrobienia
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        BasicError error = new BasicError(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }
}
