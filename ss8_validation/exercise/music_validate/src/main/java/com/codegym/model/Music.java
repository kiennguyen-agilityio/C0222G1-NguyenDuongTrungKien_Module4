package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music")
    private int idMusic;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 800,message = "Không được vượt quá 800 kí tự")
//    @Pattern(regexp = "\\w")
    @Column(name = "name_music")
    private String nameMusic;

    @NotEmpty
    @Size(max = 300,message = "Không được vượt quá 300 kí tự")
//    @Pattern(regexp = "\\w")
    @Column(name = "musician")
    private String musician;

    @Size(max = 1000,message = "Không được vượt quá 1000 kí tự")
    @NotEmpty
    @Column(name = "type_of_music")
    private String typeOfMusic;
    @Column(name = "path_music")
    private String path;

    public Music() {
    }

    public Music(Integer idMusic, String nameMusic, String musician, String typeOfMusic, String path) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.musician = musician;
        this.typeOfMusic = typeOfMusic;
        this.path = path;
    }

    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
