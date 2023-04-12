package pl.trypuz.musicshop.musicshop.model;

public class AlbumDTO {

    private final String artistName;
    private final String albumName;
    private final String imageUrl;
    private final String descriptions;
    private final String genreOfMusic;
    private final String dateOfProduction;
    private final String producerName;

    public AlbumDTO(String artistName, String albumName, String imageUrl, String descriptions, String genreOfMusic, String dateOfProduction, String producerName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageUrl = imageUrl;
        this.descriptions = descriptions;
        this.genreOfMusic = genreOfMusic;
        this.dateOfProduction = dateOfProduction;
        this.producerName = producerName;
    }

    public String getArtistName() {
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

}
