package codegym.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music")
    private int idMusic;
    @Column(name = "name_music")
    private String nameMusic;
    @Column(name = "musician")
    private String musician;
    @Column(name = "type_of_music")
    private String typeOfMusic;
    @Column(name = "path_music")
    private String path;
//        @Column(name = "status" , columnDefinition = "bit")
//        @ColumnDefault("0")
//        private int status ;

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
