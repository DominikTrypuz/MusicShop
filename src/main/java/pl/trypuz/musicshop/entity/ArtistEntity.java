package pl.trypuz.musicshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artistName;
    @OneToMany
    private List<AlbumEntity> albums;

    public String getArtistName() {
        return artistName;
    }

    public ArtistEntity() {
    }

    public ArtistEntity(String artistName, List<AlbumEntity> albums) {
        this.artistName = artistName;
        this.albums = albums;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }
}
