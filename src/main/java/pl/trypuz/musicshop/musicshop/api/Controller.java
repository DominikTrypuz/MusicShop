package pl.trypuz.musicshop.musicshop.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.service.Service;
import pl.trypuz.musicshop.musicshop.mapper.AlbumMapper;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/longplay", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class Controller {

    private final Service service;
    private final AlbumMapper albumMapper;

    public Controller(Service albumService, AlbumMapper albumMapper) {
        this.service = albumService;
        this.albumMapper = albumMapper;
    }

    @PostMapping()
    public AlbumDTO save(@RequestBody AlbumDTO dto) {
        AlbumEntity entity = service.save(dto);
        return albumMapper.toDTO(entity);
    }

    @GetMapping()
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<AlbumDTO> dtos = service.getAllAlbums().stream().map(albumMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{albumName}")
    public ResponseEntity<List<AlbumDTO>> findByAlbumName(@PathVariable String albumName) {
        AlbumEntity entity = service.findByAlbumName(albumName);
        return ResponseEntity.ok(Collections.singletonList(albumMapper.toDTO(entity)));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteByAlbum(@PathVariable String name) {
        service.deleteByAlbum(name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}