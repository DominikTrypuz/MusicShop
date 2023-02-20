package pl.trypuz.musicshop.entity;

import jakarta.persistence.*;

@Entity
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String albumName;

    @ManyToOne
    private ArtistEntity artist;

    public AlbumEntity(String albumName, ArtistEntity artistEntity) {
        this.albumName = albumName;
        this.artist = artistEntity;
    }

    public AlbumEntity() {
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArtistEntity getArtist() {
        return artist;
    }
}
