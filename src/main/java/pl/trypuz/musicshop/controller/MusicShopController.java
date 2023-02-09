package pl.trypuz.musicshop.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.trypuz.musicshop.entity.LongPlayEntity;
import pl.trypuz.musicshop.service.MusicShopService;

@Controller
@RequestMapping("/api")
public class MusicShopController {

    private final MusicShopService service;

    public MusicShopController(MusicShopService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @PostMapping("/longplay/{albumName}")
    public ResponseEntity<LongPlayEntity>save(@PathVariable String albumName) {
        LongPlayEntity entity = service.saveLongPlay(albumName);
        return ResponseEntity.ok().body(entity);
    }
}
