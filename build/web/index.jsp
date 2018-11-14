<%-- 
    Document   : index
    Created on : Oct 27, 2018, 10:31:44 PM
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

        <script type="text/javascript" language="javascript">
            function checkfile(sender) {
                var validExts = new Array(".mp3");
                var fileExt = sender.value;
                fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
                if (validExts.indexOf(fileExt) < 0) {
                    alert("Invalid file selected, valid files are of " +
                            validExts.toString() + " types.");
                    sender.value = "";
                    return false;
                } else
                    return true;
            }
        </script>

    </head>
    <body>

        <div class="container">
            <div>
                <jsp:include page="navbar.jsp" />       
            </div>
            <br>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="font-italic" style="color: cornflowerblue" align="center">Welcome to Krocify</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 "></div>

                <div class="col-lg-4" align="center">
                    <div class="card" style="background-color: cornflowerblue" >
                        <img src="vinyl.png" alt="Vinyl pic">

                        <div class="card-body">
                            <h3 class="card-title" align="center">Spot a song</h3>
                            <p class="card-text" align="center">Upload a song, find the lyrics, that simple!</p>
                            <div class="row">
                                <div class="col-lg-4">
                                </div>
                                <div class="col-lg-4 ">
                                    <form method="post" action="MP3FileHandling" enctype="multipart/form-data">
                                        <div class="form-group row">
                                            <div class="col-lg-12">
                                                <input type="file" class="form-control-file" id="sender" name="file" accept=".mp3" onchange="checkfile(this);" required="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-lg-4">
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-lg-4">
                                </div>
                            </div>
                        </div> 
                    </div>
                </div>    
            </div>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    </body>

</html>
