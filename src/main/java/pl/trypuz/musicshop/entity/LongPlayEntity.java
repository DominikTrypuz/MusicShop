package pl.trypuz.musicshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LongPlayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String albumName;
    private String bandName;

    public LongPlayEntity(String albumName, String bandName) {
        this.albumName = albumName;
        this.bandName = bandName;
    }

    public LongPlayEntity() {
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getBandName() {
        return bandName;
    }
}
