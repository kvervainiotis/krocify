<%-- 
    Document   : search
    Created on : Oct 30, 2018, 12:04:42 PM
    Author     : krocos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Mp3Tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Krocify</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="mystyle.css">

    </head>
    <body>


        <div class="container">
            <div>
                <jsp:include page="navbar.jsp" />       
            </div>
            <br><br><br><br> 

            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Artist</th>
                        <th scope="col">Tittle</th>
                        <th scope="col">Album</th>
                        <th scope="col">Year</th>
                        <th scope="col">Download</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Mp3Tags> array = new ArrayList<Mp3Tags>();
                        array = (ArrayList<Mp3Tags>) (request.getAttribute("search"));
                        for (Mp3Tags t : array) {
                    %>
                <form method="post" action="DownloadMp3">
                    <tr>

                        <th scope="row"><%= t.getId()%></th>
                        <td><%= t.getArtist()%></td>
                        <td><%= t.getSongTittle()%></td>
                        <td><%= t.getAlbumTittle()%></td>
                        <td><%= t.getYear()%></td>
                        <td>
                            <div class="row">
                                <button type="submit" class="btn btn-primary"   name="id" value="<%= t.getId()%>">Download</button>
                            </div>
                        </td>
                    </tr>
                    <% }
                    %>
                </form>


                </tbody>
            </table>


            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    </body>

</html>
