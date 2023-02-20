package pl.trypuz.musicshop.model;

public class BasicError {

    private String message;
    private int status;

    public BasicError(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
