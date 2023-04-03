package pl.trypuz.musicshop.musicshop.support;

import pl.trypuz.musicshop.musicshop.support.exception.AlbumNotFoundException;

import java.util.function.Supplier;

public class AlbumExceptionSupplier {
    public static Supplier<AlbumNotFoundException> AlbumNotFound(Long id) {
        return () -> new AlbumNotFoundException(id);
    }
}
