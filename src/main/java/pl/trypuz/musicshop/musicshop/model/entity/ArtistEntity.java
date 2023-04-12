package pl.trypuz.musicshop.musicshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "artistName")
    private List<AlbumEntity> albums;

    private String artistName;

    public ArtistEntity(List<AlbumEntity> albums, String artistName) {
        this.albums = albums;
        this.artistName = artistName;
    }

    public ArtistEntity() {
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
