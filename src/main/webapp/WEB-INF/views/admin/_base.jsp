<%-- 
    Document   : principal
    Created on : 13/07/2017, 11:08:30
    Author     : Renan.Vieira
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <jsp:include page="frag/meta.jsp" />
    <jsp:include page="frag/css.jsp" />
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        
        <jsp:include page="frag/colunamenu.jsp" />  

        <!-- top navigation -->
        <jsp:include page="frag/topnavigation.jsp" />
        
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Eventos <small>lista de eventos</small></h3>
              </div>
            </div>
            <div class="clearfix"></div>
           
            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                    <a href="${pageContext.request.contextPath}/evento/novo" class="btn btn-primary">Criar Novo Evento</a>
                  </div>
                  <div class="x_content">

                    

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="frag/rodape.jsp" />

      </div>
    </div>

    <!-- jQuery -->
    <jsp:include page="frag/js.jsp" />
    
    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/js/custom.min.js" />"></script>
  </body>
</html>