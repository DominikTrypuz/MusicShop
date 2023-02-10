package pl.trypuz.musicshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.trypuz.musicshop.dto.LongPlayDto;
import pl.trypuz.musicshop.entity.LongPlayEntity;
import pl.trypuz.musicshop.mapper.LongPlayMapper;
import pl.trypuz.musicshop.service.MusicShopService;

import java.util.List;

@Controller
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicShopController {

    private final MusicShopService service;

    public MusicShopController(MusicShopService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


    @PostMapping("/longplay/{albumName}/{bandName}")
    public ResponseEntity<LongPlayDto> save(
            @PathVariable String albumName,
            @PathVariable String bandName
    ) {
        LongPlayEntity entity = service.saveLongPlay(albumName, bandName);
        return ResponseEntity.ok(LongPlayMapper.toDto(entity));
    }

    @GetMapping("/longplay")
    public ResponseEntity<List<LongPlayDto>> getAll() {
        List<LongPlayDto> dtos = service.getAllLongPlays().stream().map(LongPlayMapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/longplay/{bandName}")
    public ResponseEntity<List<LongPlayDto>> findByBandName(@PathVariable String bandName) {
        List<LongPlayDto> dtos = service.findByBandName(bandName).stream().map(LongPlayMapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }
}
