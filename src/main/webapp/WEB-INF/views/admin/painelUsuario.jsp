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
                <h3>Usuários <small>lista de usuários</small></h3>
              </div>
            </div>
            <div class="clearfix"></div>
           
            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_content">
                    
                      <div class="fa-hover col-md-12 col-sm-12 col-xs-12">
                              <div class="x_panel">
                                  <div class="x_title">
                                      <small>Lista de Administradores</small>
                                  </div>
                                  <div class="x_content">
                                      <table class="table table-striped">
                                          <thead>
                                            <th>Nome</th>
                                            <th>Login</th>
                                            <th>CPF</th>
                                            <th>Ações</th>
                                          </thead>
                                          <tbody>
                                              <c:forEach items="${administradores}" var="administrador">
                                                  <tr>
                                                    <td>${administrador.getNome()}</td>
                                                    <td>${administrador.getLogin()}</td>
                                                    <td>${administrador.getCPF()}</td>
                                                    <td>
                                                        <c:choose>
                                                                <c:when test="${professor.getEstatus() == 1}">
                                                                    <a href="#" data-usuario="${administrador.getUsuarioId()}" class="btn btn-danger btn-xs btn-desativar-usuario">Desativar</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-usuario="${administrador.getUsuarioId()}" class="btn btn-success btn-xs btn-ativar-usuario">Ativar</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                        <a href="${pageContext.request.contextPath}/usuario/visualizar/${administrador.getUsuarioId()}" class="btn btn-primary btn-xs">Visualizar</a>
                                                    </td>
                                                  </tr>
                                              </c:forEach>
                                          </tbody>
                                      </table>
                                  </div>
                                </div>
                        </div> <!-- FIM TABELA ADMIN -->
                        
                        <div class="fa-hover col-md-12 col-sm-12 col-xs-12">
                              <div class="x_panel">
                                  <div class="x_title">
                                      <small>Lista de Professores</small>
                                  </div>
                                  <div class="x_content">
                                      <table class="table table-striped">
                                          <thead>
                                            <th>Nome</th>
                                            <th>Login</th>
                                            <th>E-mail de contato</th>
                                            <th>Ações</th>
                                          </thead>
                                          <tbody>
                                              <c:forEach items="${professores}" var="professor">
                                                  <tr>
                                                    <td>${professor.getNome()}</td>
                                                    <td>${professor.getLogin()}</td>
                                                    <td>${professor.getEmailContato()}</td>
                                                    <td>
                                                        <c:choose>
                                                                <c:when test="${professor.getEstatus() == 1}">
                                                                    <a href="#" data-usuario="${professor.getUsuarioId()}" class="btn btn-danger btn-xs btn-desativar-usuario">Desativar</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-usuario="${professor.getUsuarioId()}" class="btn btn-success btn-xs btn-ativar-usuario">Ativar</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                                    
                                                        <c:choose>
                                                                <c:when test="${professor.getUsaAdmin() == 1}">
                                                                    <a href="#" data-usuario="${professor.getUsuarioId()}" class="btn btn-danger btn-xs btn-desativarPainel-usuario">Desativar Painel</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-usuario="${professor.getUsuarioId()}" class="btn btn-success btn-xs btn-ativarPainel-usuario">Ativar Painel</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                        <a href="${pageContext.request.contextPath}/usuario/visualizar/${professor.getUsuarioId()}" class="btn btn-primary btn-xs">Visualizar</a>
                                                    </td>
                                                  </tr>
                                              </c:forEach>
                                          </tbody>
                                      </table>
                                  </div>
                                </div>
                        </div> <!-- FIM TABELA PROFESSORES -->
                        
                        <div class="fa-hover col-md-12 col-sm-12 col-xs-12">
                              <div class="x_panel">
                                  <div class="x_title">
                                      <small>Lista de Alunos</small>
                                  </div>
                                  <div class="x_content">
                                      <table class="table table-striped">
                                          <thead>
                                            <th>Nome</th>
                                            <th>Login</th>
                                            <th>Matricula</th>
                                            <th>Ações</th>
                                          </thead>
                                          <tbody>
                                              <c:forEach items="${alunos}" var="aluno">
                                                  <tr>
                                                    <td>${aluno.getNome()}</td>
                                                    <td>${aluno.getLogin()}</td>
                                                    <td>${aluno.getMatricula()}</td>
                                                    <td>
                                                         <c:choose>
                                                                <c:when test="${aluno.getEstatus() == 1}">
                                                                    <a href="#" data-usuario="${aluno.getUsuarioId()}" class="btn btn-danger btn-xs btn-desativar-usuario">Desativar</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" data-usuario="${aluno.getUsuarioId()}" class="btn btn-success btn-xs btn-ativar-usuario">Ativar</a>
                                                                </c:otherwise>
                                                        </c:choose>
                                                        <a href="${pageContext.request.contextPath}/usuario/visualizar/${aluno.getUsuarioId()}" class="btn btn-primary btn-xs">Visualizar</a>
                                                    </td>
                                                  </tr>
                                              </c:forEach>
                                          </tbody>
                                      </table>
                                  </div>
                                </div>
                        </div> <!-- FIM TABELA PROFESSORES -->
                      
                      
                      
                      
                      
                      

                    

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
    <script src="<c:url value="/resources/js/discorp-usuario.js" />"></script>
  </body>
</html>