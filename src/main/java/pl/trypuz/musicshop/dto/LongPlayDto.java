package pl.trypuz.musicshop.dto;

public class LongPlayDto {

    private String albumName;
    private String bandName;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public LongPlayDto(String albumName, String bandName) {
        this.albumName = albumName;
        this.bandName = bandName;
    }
}
