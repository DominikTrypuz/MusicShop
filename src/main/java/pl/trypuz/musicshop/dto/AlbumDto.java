package pl.trypuz.musicshop.dto;

public class AlbumDto {

    private String albumName;
    private String artistName;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public AlbumDto(String albumName, String bandName) {
        this.albumName = albumName;
        this.artistName = bandName;
    }
}
