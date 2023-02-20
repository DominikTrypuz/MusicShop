package pl.trypuz.musicshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.trypuz.musicshop.dto.AlbumDto;
import pl.trypuz.musicshop.entity.AlbumEntity;
import pl.trypuz.musicshop.mapper.AlbumMapper;
import pl.trypuz.musicshop.service.MusicShopService;

import java.util.List;

@Controller
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicShopController {

    private final AlbumMapper longPlayMapper;

    private final MusicShopService service;

    public MusicShopController(AlbumMapper longPlayMapper, MusicShopService service) {
        this.longPlayMapper = longPlayMapper;
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @PostMapping("/longplay")
    public ResponseEntity<AlbumDto> save(@RequestBody AlbumDto dto) {
        AlbumEntity entity = service.saveLongPlay(dto);
        return ResponseEntity.ok(longPlayMapper.toDto(entity));
    }

    @GetMapping("/longplay")
    public ResponseEntity<List<AlbumDto>> getAll() {
        List<AlbumDto> dtos = service.getAllLongPlays().stream().map(longPlayMapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/longplay/{albumName}")
    public ResponseEntity <AlbumDto> findByAlbumName(@PathVariable String albumName) {
        AlbumEntity entity = service.findByAlbumName(albumName);
        return ResponseEntity.ok(longPlayMapper.toDto(entity));
    }
}
