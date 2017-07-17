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
            <div class="page-title"></div>
            <div class="clearfix"></div>
           
            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_content">
                      <div class="row">
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Nome do Usuario</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${usuario.getNome()}</p>
                          </div>
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Login do Usuario</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${usuario.getLogin()}</p>
                          </div>
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Senha do Usuario</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                              <p>${usuario.getSenha()}</p>
                          </div>
                          
                          <div class="fa-hover col-md-3 col-sm-4 col-xs-4">
                              <p>Usa o Gerenciar</p>
                          </div>
                          <div class="fa-hover col-md-8 col-sm-8 col-xs-8">
                               <c:choose>
                                        <c:when test="${usuario.getUsaAdmin() == 1}">
                                            <p>Sim</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p>Não</p>
                                        </c:otherwise>
                                </c:choose>
                          </div>
                          
                          <div class="fa-hover col-md-12 col-sm-12 col-xs-12">
                              <div class="x_panel">
                                  <div class="x_title">
                                      <small>Lista de eventos inscrito</small>
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
                                              <c:forEach items="${reservas}" var="reserva">
                                                  <tr>
                                                    <td>${reserva.getReservaId()}</td>
                                                    <td>${reserva.getEvento().getDescricao()}</td>
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
                                                                    <a href="#" data-evento="${evento.getEvento().getEventoId()}" class="btn btn-danger btn-xs btn-cancela-reserva-admin" data-reserva="${reserva.getReservaId()}">Cancelar</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-evento="${evento.getEvento().getEventoId()}" class="btn btn-info btn-xs btn-ativar-reserva-admin" data-reserva="${reserva.getReservaId()}" >Ativar</a>
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
    <script src="<c:url value="/resources/js/discorp-usuario-a.js" />"></script>
  </body>
</html>