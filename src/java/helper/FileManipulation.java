/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dao.MP3FileDAO;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import model.Mp3Tags;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1_1;
import org.farng.mp3.id3.ID3v2_4;

/**
 *
 * @author krocos
 */
public class FileManipulation {

    public static String replace(String str) {
        String[] words = str.split(" ");
        StringBuffer sentence = new StringBuffer();
        for (String w : words) {
            sentence.append(w);
            sentence.append("%20");
        }
        return sentence.toString();
    }

    public static Mp3Tags exportTags(Part filepart) {
        MP3File mp3file;
        MP3FileDAO mp3fdao = new MP3FileDAO();
        Mp3Tags mp3tags = null;
        final String filename = filepart.getSubmittedFileName();
        try {
            filepart.write("C:\\Users\\krocos\\Documents\\bootcamp\\filesUploaded\\" + filename);
            File f = new File("C:\\Users\\krocos\\Documents\\bootcamp\\filesUploaded\\" + filename);
            RandomAccessFile raf = new RandomAccessFile(f, "rwd");
            mp3file = new MP3File(f);
            ID3v1_1 tag = new ID3v1_1(raf);;
            mp3tags = new Mp3Tags(tag.getLeadArtist(), tag.getSongTitle(), tag.getAlbumTitle(), tag.getYear());
            mp3tags = mp3fdao.insertFile(filename, filepart, mp3tags);
        } catch (IOException ex) {
            Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);     //an den exei IDV1.1
        } catch (TagException ex) {
            return mp3tags;
        }
        return mp3tags;
    }

}
