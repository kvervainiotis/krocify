/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.MP3FileDAO;
import helper.FileManipulation;
import helper.Services;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Mp3Tags;

/**
 *
 * @author krocos
 */
@WebServlet(name = "MP3FileHandling", urlPatterns = {"/MP3FileHandling"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024 * 20 * 20)
public class MP3FileHandling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final Part filepart = request.getPart("file");
        Mp3Tags myMp3 = new Mp3Tags();
        myMp3 = FileManipulation.exportTags(filepart);
        if (myMp3 == null) {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", "Wrong type of mp3. The mp3 " + filepart.getName() + " does not contain tags.");
            rd.forward(request, response);
        } else {
            myMp3.setLyrics(Services.getLyrics(myMp3));
            if (myMp3.getLyrics() == null) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("error", "No lyrics found for the mp3 " + myMp3.getSongTittle() + "!!!");
                rd.forward(request, response);
            } else {
                myMp3.setImageUrl(Services.getImageUrl(myMp3));
                MP3FileDAO dao = new MP3FileDAO();
                dao.insertimageUrl(myMp3);
                dao.insertLyrics(myMp3);
                RequestDispatcher rd = request.getRequestDispatcher("myMP3.jsp");
                request.setAttribute("myMP3", myMp3);
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
