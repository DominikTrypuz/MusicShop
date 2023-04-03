package pl.trypuz.musicshop.musicshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ArtistNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "artistName")
    private List<AlbumEntity> albums;

    private String artistName;

    public ArtistNameEntity(List<AlbumEntity> albums, String artistName) {
        this.albums = albums;
        this.artistName = artistName;
    }

    public ArtistNameEntity() {
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public String getArtistName() {
        return artistName;
    }
}
