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
    <meta http-equiv="Content-Type" content="text/html; charset=pt-br">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="iso-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>UFF - Eventos</title>

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

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Buscar por nome...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Buscar!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="clearfix"></div>
           
            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                    <a href="${pageContext.request.contextPath}/evento/novo" class="btn btn-primary pull-right">Criar Novo Evento</a>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <p>Lista de eventos ordernados pela data de acontecimento</p>

                    <!-- start project list -->
                    <table class="table table-striped projects">
                      <thead>
                        <tr>
                          <th style="width: 1%">#</th>
                          <th style="width: 20%">Nome do evento</th>
                          <th>Coordenador</th>
                          <th>Ocupação</th>
                          <th>Estatus</th>
                          <th style="width: 20%">#Ações</th>
                        </tr>
                      </thead>
                      <tbody>
                          
                          <c:forEach items="${eventos}" var="evento">
                               <!-- 
                                <div class="col-md-4">
                                    <div class="intro-table intro-table-hover ${evento.getCategoria().getAcronimo()}">
                                        <h5 class="white heading hide-hover evento-titulo">
                                              ${evento.getDescricao()} <br /> 
                                              <span class="evento-pessoa">${evento.getPessoa()}</span> 
                                        </h5>
                                        <div class="bottom">
                                            <a href="#" data-toggle="modal" data-target="#modalEvento${evento.getEventoId()}">
                                                <h4 class="white heading small-heading no-margin regular">${evento.getCategoria().getDescricao()}</h4>
                                                <h4 class="white heading small-pt evento-data">${evento.getDataInicioFormatado()}</h4>
                                            </a>
                                            <a href="#" data-evento="${evento.getEventoId()}"  class="btn btn-white-fill expand btn-reservar">Fazer Reserva</a>
                                        </div>
                                    </div>
                                </div>
                                -->
                                
                                <tr>
                                    <td>#</td>
                                    <td>
                                      <a>${evento.getDescricao()}</a>
                                      <br />
                                      <small>${evento.getDataInicioFormatado()}</small>
                                    </td>
                                    <td>
                                      <ul class="list-inline">
                                        <li>
                                          <img src="<c:url value="/resources/img/user.png" />" class="avatar" alt="Avatar">
                                        </li>
                                        <li>
                                          ${evento.getUsuario().getNome()}</p>
                                        </li>
                                      </ul>
                                    </td>
                                    <td class="project_progress">
                                      <div class="progress progress_sm">
                                        <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${evento.getPercentualOcupacao()}"></div>
                                      </div>
                                      <small>${evento.getPercentualOcupacao()}% Complete</small>
                                    </td>
                                    <td>
                                       <c:choose>
                                               <c:when test="${evento.getEstatus() == 1}">
                                                    <a href="#" data-label-evento="${evento.getEventoId()}" class="btn btn-danger btn-xs label-evento"> Cancelado </a>
                                               </c:when>
                                               
                                               <c:when test="${evento.getEstatus() == 2}">
                                                    <a href="#" data-label-evento="${evento.getEventoId()}" class="btn btn-success btn-xs label-evento"> Autorizado </a>
                                               </c:when>
                                                    
                                               <c:when test="${evento.getEstatus() == 0}">
                                                    <a href="#" data-label-evento="${evento.getEventoId()}" class="btn btn-warning btn-xs label-evento"> Pendente </a>
                                               </c:when>
                                       </c:choose>
                                        
                                      
                                    </td>
                                    <td>
                                      <a href="${pageContext.request.contextPath}/evento/visualizar/${evento.getEventoId()}" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> Visualizar </a>
                                      <a href="${pageContext.request.contextPath}/evento/editar/${evento.getEventoId()}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Editar </a>
                                      
                                      <c:choose>
                                          <c:when test="${evento.getEstatus() == 0}">
                                              <c:choose>
                                                    <c:when test="${usuariologado.getIsGerente()}">
                                                          <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-info btn-xs btn-autorizar-evento"> Autorizar </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                         <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-danger btn-xs btn-cancelar-evento"> Cancelar </a>
                                                    </c:otherwise>
                                              </c:choose>
                                          </c:when>
                                                   
                                          <c:when test="${evento.getEstatus() == 1}">
                                              <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-info btn-xs btn-ativar-evento"> Ativar </a>
                                          </c:when>
                                          
                                         <c:when test="${evento.getEstatus() == 2}">
                                              <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-danger btn-xs btn-cancelar-evento"> Cancelar </a>
                                          </c:when>
                                      </c:choose>
                                    </td>
                                  </tr>
                               
                                  
                                  
                            </c:forEach>
                          
                          
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                      </tbody>
                    </table>
                    <!-- end project list -->

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
    <script src="<c:url value="/resources/js/discorp-admin.js" />"></script>
  </body>
</html>
