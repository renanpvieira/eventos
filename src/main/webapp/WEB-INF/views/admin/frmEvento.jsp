<%-- 
    Document   : frmEvento
    Created on : 13/07/2017, 14:16:01
    Author     : Renan.Vieira
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="frag/meta.jsp" />

    <!-- Bootstrap -->
    <jsp:include page="frag/css.jsp" />
    
    
    <!-- bootstrap-wysiwyg -->
    <link href="<c:url value="/resources/css/prettify.min.css" />" rel="stylesheet">
    <!-- Select2 -->
    <link href="<c:url value="/resources/css/select2.min.css" />" rel="stylesheet">
    
    <!-- Switchery -->
    <link href="<c:url value="/resources/css/switchery.min.css" />" rel="stylesheet">
    
    <!-- starrr -->
    <link href="<c:url value="/resources/css/starrr.css" />" rel="stylesheet">
    
    <!-- bootstrap-daterangepicker -->
    <link href="<c:url value="/resources/css/daterangepicker.css" />" rel="stylesheet">

    
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
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Eventos <small>formulário de cadastro de eventos</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <!--<form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">-->
                    <form:form method="POST" modelAttribute="evento" class="form-horizontal form-label-left" >
                        
                      <form:input type="hidden" path="EventoId" id="EventoId"/>

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nome do evento <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <form:input path="descricao" id="descricao" class="form-control col-md-7 col-xs-12" required="required" />
                        </div>
                      </div>
                        
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Ministrante</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <form:input path="pessoa" id="pessoa" class="form-control col-md-7 col-xs-12"  />
                        </div>
                     </div>
                        
                        
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Descrição <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <form:textarea path="DescricaoLonga" id="DescricaoLonga" required="required" data-parsley-trigger="keyup" class="form-control" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.." data-parsley-validation-threshold="10" />
                          <!-- <textarea id="message" required="required" class="form-control" name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.." data-parsley-validation-threshold="10"></textarea> -->
                        </div>
                      </div>
                        
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Categoria</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control" name="categoria" >
                            <c:forEach items="${eventoCategorias}" var="eventoCategoria">
                                <option value="${eventoCategoria.getEventoCategoriaId()}"  ${evento.getCategoria().getEventoCategoriaId() == eventoCategoria.getEventoCategoriaId() ? 'selected="selected"' : ''} >${eventoCategoria.getDescricao()}</option>
                            </c:forEach>
                          </select>
                        </div>
                      </div>
                        
                        
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Local</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control" name="ambiente" >
                            <c:forEach items="${ambientes}" var="ambiente">
                                <option value="${ambiente.getAmbienteId()}" ${evento.getAmbiente().getAmbienteId() == ambiente.getAmbienteId() ? 'selected="selected"' : ''}   >${ambiente.getDescricao()}</option>
                            </c:forEach>
                          </select>
                        </div>
                      </div>
                          
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Ocupação</label>
                        <div class="col-sm-2 col-md-2 col-xs-2">
                          <form:input path="ocupacao" id="ocupacao" class="form-control col-sm-4 col-md-6 col-xs-8"  />
                        </div>
                        <label>Ocupação</label>
                     </div>
                     
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Duração</label>
                        <div class="col-sm-2 col-md-2 col-xs-2">
                          <form:input path="duracao" id="duracao" class="form-control col-sm-4 col-md-6 col-xs-8"  />
                        </div>
                     </div>
                        
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Data do evento <span class="required">*</span>
                        </label>
                        <div class="col-md-2 col-sm-2 col-xs-6">
                          <form:input path="DataInicio" id="DataInicio" class="form-control col-md-7 col-xs-12"  />
                        </div>
                        
                       <label class="control-label col-md-2 col-sm-2 col-xs-4" for="last-name">Hora do evento <span class="required">*</span>
                        </label>
                        <div class="col-md-2 col-sm-2 col-xs-6">
                          <form:input path="HoraInicio" id="HoraInicio" class="form-control col-md-7 col-xs-12"  />
                        </div>
                     </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                           <a href="#" class="btn btn-success salvar-evento">Salvar</a>
                           <span id="form-evento-msg"></span>
                        </div>
                      </div>
                    </form:form>
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
    
    
    <!-- iCheck -->
    <script src="<c:url value="/resources/js/icheck.min.js" />"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="<c:url value="/resources/js/moment.min.js" />"></script>
    <script src="<c:url value="/resources/js/daterangepicker.js" />"></script>
    
    <!-- bootstrap-wysiwyg -->
    <script src="<c:url value="/resources/js/bootstrap-wysiwyg.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.hotkeys.js" />"></script>
    <script src="<c:url value="/resources/js/prettify.js" />"></script>
    <!-- jQuery Tags Input -->
    <script src="<c:url value="/resources/js/jquery.tagsinput.js" />"></script>
    <!-- Switchery -->
    <script src="<c:url value="/resources/js/switchery.min.js" />"></script>
    <!-- Select2 -->
    <script src="<c:url value="/resources/js/select2.full.min.js" />"></script>
    <!-- Parsley -->
    <script src="<c:url value="/resources/js/parsley.min.js" />"></script>
    <!-- Autosize -->
    <script src="<c:url value="/resources/js/autosize.min.js" />"></script>
    <!-- jQuery autocomplete -->
    <script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
    <!-- starrr -->
    <script src="<c:url value="/resources/js/starrr.js" />"></script>
    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/js/custom.min.js" />"></script>
    <script src="<c:url value="/resources/js/discorp-evento.js" />"></script>
    
    
    
	
  </body>
</html>
