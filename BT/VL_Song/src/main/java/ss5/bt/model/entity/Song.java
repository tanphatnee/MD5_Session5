package ss5.bt.model.entity;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Must be not empty")
    @Size(min = 1,max = 5, message = "Must be not over 800 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Only include text and numbers")
    private String name;

    @NotEmpty(message = "Must be not empty")
    @Size(min = 1,max = 5, message = "Must be not over 300 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Only include text and numbers")
    private String singer;

    @NotEmpty(message = "Must be not empty")
    @Size(min = 1,max = 5, message = "Must be not over 1000 characters")
    @Pattern(regexp = "^[A-Za-z0-9,]+$", message = "Only include text, numbers and comma")
    private String genre;


    public Song() {
    }

    public Song(Long id, String name, String singer, String genre) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



}
