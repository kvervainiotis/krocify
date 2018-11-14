/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author krocos
 */
public class Mp3Tags {

    private int id;
    private String artist;
    private String songTittle;
    private String albumTittle;
    private String year;
    private String lyrics;
    private String imageUrl;

    public Mp3Tags() {
    }

    public Mp3Tags(String artist, String songTittle, String albumTittle, String year) {
        this.artist = artist;
        this.songTittle = songTittle;
        this.albumTittle = albumTittle;
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Mp3Tags(int id, String artist, String songTittle, String albumTittle, String yearReleased) {
        this.id = id;
        this.artist = artist;
        this.songTittle = songTittle;
        this.albumTittle = albumTittle;
        this.year = yearReleased;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTittle() {
        return songTittle;
    }

    public void setSongTittle(String songTittle) {
        this.songTittle = songTittle;
    }

    public String getAlbumTittle() {
        return albumTittle;
    }

    public void setAlbumTittle(String albumTittle) {
        this.albumTittle = albumTittle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String yearReleased) {
        this.year = yearReleased;
    }

    @Override
    public String toString() {
        return "Mp3Tags{" + "id=" + id + " \n artist=" + artist + " \n songTittle=" + songTittle + " \n albumTittle=" + albumTittle + " \n yearReleased=" + year + '}';
    }

}
