package pl.trypuz.musicshop.musicshop.support.exception;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(Long id) {
        super(String.format("Item with id %d not found", id));
    }
}
