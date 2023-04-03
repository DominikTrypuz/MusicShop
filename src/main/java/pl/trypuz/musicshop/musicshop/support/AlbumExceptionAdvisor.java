package pl.trypuz.musicshop.musicshop.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.trypuz.musicshop.musicshop.support.exception.AlbumNotFoundException;
import pl.trypuz.musicshop.musicshop.support.response.ErrorMessageResponse;

@ControllerAdvice
public class AlbumExceptionAdvisor {
    private static final Logger LOG = LoggerFactory.getLogger(AlbumExceptionAdvisor.class);

    @ExceptionHandler(AlbumNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse itemNotFound(AlbumNotFoundException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }
}
