<%-- 
    Document   : myMP3
    Created on : Oct 27, 2018, 10:49:42 PM
    Author     : krocos
--%>

<%@page import="model.Mp3Tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Krocify</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="mystyle.css">

    </head>
    <body>

        <div class="container">
            <div>
                <jsp:include page="navbar.jsp" />       
            </div>
            <br><br> 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="font-italic" style="color: cornflowerblue" align="center">LYRICS FOUND ! ! !</h1>
                </div>
            </div>

            <br><br> 
            <div class="row">
                <div class="col-lg-2 "></div>

                <div class="col-lg-8 ">
                    <div class="accordion" id="accordionExample">
                        <div class="card" style="background-color: cornflowerblue">
                            <div class="card-header" id="headingTwo">
                                <h5 class="mb-0">
                                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" style="color: yellow">
                                        <% Mp3Tags mp3 = (Mp3Tags) (request.getAttribute("myMP3"));%>
                                        <%= mp3.getArtist() + " - " + mp3.getSongTittle()%>
                                    </button>
                                </h5>
                            </div>
                            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                <div class="card-body">
                                    <%= mp3.getLyrics()%> 
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div><br>
            <div class="row">
                <div class="col-lg-4 "></div>
                <div class="col-lg-4 "><img src="<%= mp3.getImageUrl()%>"></div>
                <div class="col-lg-4 "></div>

            </div>
        </div>

    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</body>
</html>
