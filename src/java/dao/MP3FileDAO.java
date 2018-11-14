/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.DBUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import model.Mp3Tags;
import servlets.MP3FileHandling;

/**
 *
 * @author krocos
 */
public class MP3FileDAO {

    public Mp3Tags insertFile(String filename, Part filepart, Mp3Tags mp3tag) {
        String sql = "INSERT INTO mp3file (filename, mp3, artist, song_tittle, album_tittle, year)  VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = null;
        int id = 0;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, filename);
            stm.setBlob(2, filepart.getInputStream());
            stm.setString(3, mp3tag.getArtist());
            stm.setString(4, mp3tag.getSongTittle());
            stm.setString(5, mp3tag.getAlbumTittle());
            stm.setString(6, mp3tag.getYear());
            stm.executeUpdate();
            mp3tag.setId(getMP3FileId(filename));
        } catch (SQLException ex) {
            Logger.getLogger(MP3FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileHandling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mp3tag;
    }

    public ArrayList<Mp3Tags> printMp3Tags() {
        ArrayList<Mp3Tags> array = new ArrayList<Mp3Tags>();
        Mp3Tags mp3Tags = null;
        Connection con = DBUtils.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id, artist, song_tittle,album_tittle,year FROM mp3file GROUP BY song_tittle;";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                mp3Tags = new Mp3Tags(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                array.add(mp3Tags);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array;
    }

    public int getMP3FileId(String filename) {
        int id = 0;
        Connection c = DBUtils.getConnection();
        ResultSet rs = null;
        Statement stm = null;
        String sql = "SELECT id FROM krocify.mp3file WHERE filename LIKE '" + filename + "' ;";
        try {
            stm = c.createStatement();
            rs = stm.executeQuery(sql);
            rs.last();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(MP3FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stm.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    public String downloadMp3(String id) {
        Connection c = DBUtils.getConnection();
        FileOutputStream output = null;
        String selectsql = "select filename, mp3 from mp3file where id = " + id + ";";
        PreparedStatement pst3;
        String filename = null;
        try {
            pst3 = c.prepareStatement(selectsql);
            ResultSet rs3;
            rs3 = pst3.executeQuery();
            rs3.last();
            filename = rs3.getString("filename");
            File file = new File("C:\\Users\\krocos\\Documents\\" + filename);
            output = new FileOutputStream(file);
            InputStream input = rs3.getBinaryStream("mp3");
            byte[] buffer = new byte[1024];
            while (input.read(buffer) > 0) {
                output.write(buffer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filename;
    }
    
    public void deleteMp3(String artist, String tittle) {
        Connection c = DBUtils.getConnection();
        //FileOutputStream output = null;
       // String selectsql = "select filename, mp3 from mp3file where artist = " + artist + " and tittle = " + tittle + ";";
        String sql = "DELETE from mp3file WHERE  (artist = '" + artist + "' AND song_tittle = '" + tittle + "');";
            try (PreparedStatement statement = c.prepareStatement(sql)) {;
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected);
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //return filename;
    }


    public void insertLyrics(Mp3Tags mp3) {
        String id = "" + mp3.getId();
        String lyrics = mp3.getLyrics().replaceAll("'", " ");
        String sql = "UPDATE `krocify`.`mp3file` SET `lyrics` = '" + lyrics + " ' WHERE (`id` = '" + id + "');";
        Connection c = DBUtils.getConnection();
        try (PreparedStatement statement = c.prepareStatement(sql)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insertimageUrl(Mp3Tags mp3) {
        String id = "" + mp3.getId();
        String sql = "UPDATE `krocify`.`mp3file` SET `imageurl` = '" + mp3.getImageUrl() + " ' WHERE (`id` = '" + id + "');";
        Connection c = DBUtils.getConnection();
        try (PreparedStatement statement = c.prepareStatement(sql)) {
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Mp3Tags> searchFile(String search) {
        ArrayList<Mp3Tags> array = new ArrayList<Mp3Tags>();
        Mp3Tags mp3Tags = null;
        Connection con = DBUtils.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id, artist, song_tittle,album_tittle,year  FROM mp3file WHERE (artist LIKE '%" + search + "%' OR song_tittle LIKE '%" + search + "%') GROUP BY song_tittle;";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                mp3Tags = new Mp3Tags(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                array.add(mp3Tags);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MP3FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array;
    }

}
