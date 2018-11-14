<%-- 
    Document   : info
    Created on : Oct 25, 2018, 2:45:31 PM
    Author     : krocos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Krocify</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="mystyle.css">

        <style>
            #myCarousel {
                width: auto;
                height: 400px;
                max-height: 400px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div>
                <jsp:include page="navbar.jsp" />       
            </div>
            <br><br>

            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img id="myCarousel" class="d-block w-100" src="pantelidis.jpg" alt="First slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3 style="color: cornflowerblue">You add your favorite artist...</h3>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img id="myCarousel"  class="d-block w-100" src="lyrics.png" alt="Second slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3 style="color: cornflowerblue">We find the lyrics for you...</h3>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img id="myCarousel"  class="d-block w-100" src="louloudopolemos.jpg" alt="Third slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3 style="color: cornflowerblue">You enjoy...</h3>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>


            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    </body>

</html>

