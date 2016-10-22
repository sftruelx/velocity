package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "artist")
public class Artist {

    private Long artistId;
    private String artistName;
    private String artistPath;
    private String artistImg;
    private Long albumId;
    private Long artistTraceLength;

        public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
        public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
        public String getArtistPath() {
        return artistPath;
    }

    public void setArtistPath(String artistPath) {
        this.artistPath = artistPath;
    }
        public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }
        public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
        public Long getArtistTraceLength() {
        return artistTraceLength;
    }

    public void setArtistTraceLength(Long artistTraceLength) {
        this.artistTraceLength = artistTraceLength;
    }
}
