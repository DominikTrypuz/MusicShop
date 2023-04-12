package pl.trypuz.musicshop.musicshop.model.entity;

import jakarta.persistence.*;

@Entity
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artistName_id")
    private ArtistEntity artistName;

    private String albumName;
    private String imageUrl;
    @Column(length = 1000000000)
    private String descriptions;
    private String genreOfMusic;
    private String dateOfProduction;
    private String producerName;

    public AlbumEntity(ArtistEntity artistName, String albumName, String imageUrl, String descriptions,
                       String genreOfMusic, String dateOfProduction, String producerName)
    {
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageUrl = imageUrl;
        this.descriptions = descriptions;
        this.genreOfMusic = genreOfMusic;
        this.dateOfProduction = dateOfProduction;
        this.producerName = producerName;
    }

    public AlbumEntity() {
    }

    public ArtistEntity getArtistName() {
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

    public String getGenreOfMusic() {
        return genreOfMusic;
    }

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setArtistName(ArtistEntity artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setGenreOfMusic(String genreOfMusic) {
        this.genreOfMusic = genreOfMusic;
    }

    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}