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
                <h3>Visualizando o evento <br /><small>${evento.getDescricao()}</small></h3>
              </div>
            </div>
            <div class="clearfix"></div>
           
            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                      <a href="${pageContext.request.contextPath}/evento/editar/${evento.getEventoId()}" class="btn btn-primary pull-right">Editar Evento</a>
                      <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="row">
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Nome do evento</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getDescricao()}</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Ministrante</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getPessoa()}</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Evento criado por</p>
                          </div>   
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getUsuario().getNome()}</p>
                          </div>  
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Descrição do evento</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getDescricaoLonga()}</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Data do evento</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getDataInicioFormatado()}</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Duração em minutos</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getDuracao()} minutos</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Local do evento</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>
                                  ${evento.getAmbiente().getDescricao()}
                                  <br />
                                  ${evento.getAmbiente().getEndereco()}
                              </p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Categoria do evento</p>
                          </div>   
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getCategoria().getDescricao()}</p>
                          </div>
                              
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Ocupação</p>
                          </div>   
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${evento.getOcupacao()} vagas</p><input type="hidden" name="qtdocup" value="${evento.getOcupacao()}">
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Reservas efetuadas</p>
                          </div>   
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p id="percentual">${qtdreservas} - ${percentual}% ocupado</p>
                              <div class="progress progress_sm">
                                   <div id="barra" class="progress-bar bg-green" role="progressbar" data-transitiongoal="${percentual}"></div>
                              </div>
                          </div>
                          
                          
                          
                          <div class="fa-hover col-md-12 col-sm-12 col-xs-12">
                              <div class="x_panel">
                                  <div class="x_title">
                                      <small>Lista de inscritos</small>
                                  </div>
                                  <div class="x_content">
                                      <table class="table table-striped">
                                          <thead>
                                            <th>Número</th>
                                            <th>Nome</th>
                                            <th>Data da inscricão</th>
                                            <th>Estatus</th>
                                            <th>Ações</th>
                                          </thead>
                                          <tbody>
                                              <c:forEach items="${evento.getReservas()}" var="reserva">
                                                  <tr>
                                                    <td>${reserva.getReservaId()}</td>
                                                    <td>${reserva.getUsuario().getNome()}</td>
                                                    <td>${reserva.getDataReservaFormatado()}</td>
                                                    <td>
                                                        
                                                        <c:choose>
                                                                <c:when test="${reserva.getEstatus() == 1}">
                                                                    <a href="#" data-label-reserva="${reserva.getReservaId()}" class="btn btn-success btn-xs reserva-label"> Ativa </a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-label-reserva="${reserva.getReservaId()}" class="btn btn-danger btn-xs reserva-label">Cancelada</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                        
                                                        
                                                        
                                                    </td>
                                                    <td>
                                                        <c:choose>
                                                                <c:when test="${reserva.getEstatus() == 1}">
                                                                    <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-danger btn-xs btn-cancela-reserva-admin" data-reserva="${reserva.getReservaId()}">Cancelar</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-evento="${evento.getEventoId()}" class="btn btn-info btn-xs btn-ativar-reserva-admin" data-reserva="${reserva.getReservaId()}" >Ativar</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                        <a href="${pageContext.request.contextPath}/admin/certificado/${reserva.getReservaId()}" target="_blank" class="btn btn-primary btn-xs" data-reserva="${reserva.getReservaId()}" ><i class="fa fa-edit"></i> Gerar Certificado</a>
                                                    </td>
                                                  </tr>
                                              </c:forEach>
                                          </tbody>
                                      </table>
                                  </div>
                                </div>
                          </div>
                       </div>
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
    <script src="<c:url value="/resources/js/discorp-evento.js" />"></script>
  </body>
</html>