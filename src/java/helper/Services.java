/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mp3Tags;
import org.json.JSONObject;
import servlets.MP3FileHandling;

/**
 *
 * @author krocos
 */
public class Services {

    public static String getLyrics(Mp3Tags myMp3) {
        String lyrics = null;
        String artist = myMp3.getArtist();
        String tittle = myMp3.getSongTittle();
        artist = FileManipulation.replace(artist);
        tittle = FileManipulation.replace(tittle);
        try {
            URL url = new URL("https://api.lyrics.ovh/v1/" + artist + "/" + tittle);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                return lyrics;
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                String k = "";
                while ((s = br.readLine()) != null) {
                    k = k + s;
                }
                JSONObject obj = new JSONObject(k);
                lyrics = obj.getString("lyrics");
                return lyrics;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lyrics;
    }

    public static String getImageUrl(Mp3Tags myMp3) {
        String imageUrl = null;
        String artist = myMp3.getArtist();
        artist = artist.replaceAll(" ", "%20");
        String u = "https://album-art-o2s77e5c7ryz.runkit.sh/?search=" + artist;
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                return imageUrl;
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                String k = "";
                while ((s = br.readLine()) != null) {
                    k = k + s;
                }
                imageUrl = (k.substring(1, k.length() - 1));
                return imageUrl;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MP3FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP3FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageUrl;
    }

}
