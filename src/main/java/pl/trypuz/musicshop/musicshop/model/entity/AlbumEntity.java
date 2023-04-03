package pl.trypuz.musicshop.musicshop.model.entity;

import jakarta.persistence.*;

@Entity
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artistName_id")
    private ArtistNameEntity artistName;

    private String albumName;
    private String imageUrl;
    @Column(length = 1000000000)
    private String descriptions;
    private String genreMusic;
    private String dateOfProduction;
    private String producerName;

    public AlbumEntity(ArtistNameEntity artistName, String albumName, String imageUrl, String descriptions,
                       String genreMusic, String dateOfProduction, String producerName)
    {
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageUrl = imageUrl;
        this.descriptions = descriptions;
        this.genreMusic = genreMusic;
        this.dateOfProduction = dateOfProduction;
        this.producerName = producerName;
    }

    public AlbumEntity() {
    }

    public ArtistNameEntity getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getGenreMusic() {
        return genreMusic;
    }

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public String getProducerName() {
        return producerName;
    }
}