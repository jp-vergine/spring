<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring mvc</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/4-col-portfolio.css" rel="stylesheet">


</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Spring mvc  ${environment}</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
<!--             <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> -->
<!--                 <ul class="nav navbar-nav"> -->
<!--                     <li> -->
<!--                         <a href="#">About</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="#">Services</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="#">Contact</a> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

		<!-- Projects Row -->
        <div class="row">
            <div class="col-md-3 portfolio-item">
            	<h4>Rest service</h4>
            	<hr/>
            	<jsp:include page="restservice.jsp" />
            </div>
            <div class="col-md-3 portfolio-item">
            	<h4>ScheduleTask / Web Socket</h4>
            	<hr/>
                <jsp:include page="scheduleTask.jsp" />
            </div>
            <div class="col-md-3 portfolio-item">
                <h4>Device detection</h4>
            	<hr/>
                <jsp:include page="device.jsp" />
            </div>
            <div class="col-md-3 portfolio-item">
                <h4>Consuming rest</h4>
            	<hr/>
                <jsp:include page="restconsumer.jsp" />
            </div>
        </div>
        <!-- /.row -->

        <!-- Projects Row -->
        <div class="row">
            <div class="col-md-3 portfolio-item">
                <h4>Upload</h4>
            	<hr/>
                <jsp:include page="upload.jsp" />
            </div>
            <div class="col-md-3 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/750x450" alt="">
                </a>
            </div>
            <div class="col-md-3 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/750x450" alt="">
                </a>
            </div>
            <div class="col-md-3 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/750x450" alt="">
                </a>
            </div>
        </div>
        <!-- /.row -->


        <hr>

        <!-- Pagination -->
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li>
                        <a href="#">&laquo;</a>
                    </li>
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li> 
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">&raquo;</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

<script src="resources/js/jquery.js"></script >
<script type="text/javascript" src="resources/js/application.js" /></script>
</body>

</html>
