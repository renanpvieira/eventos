<%-- 
    Document   : principal
    Created on : 24/06/2017, 21:59:23
    Author     : pc_renan
teste
--%>

 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="iso-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>UFF - Eventos</title>
	<meta name="description" content="uff, eventos, palestras, rio de janeiro" />
	<meta name="keywords" content="uff, eventos, palestras, rio de janeiro" />
	<meta name="author" content="Josimar, Renan, Victor, Wilker" />
	<!-- Favicons (created with http://realfavicongenerator.net/)-->
	<link rel="apple-touch-icon" sizes="57x57" href="img/favicons/apple-touch-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="img/favicons/apple-touch-icon-60x60.png">
	<link rel="icon" type="image/png" href="img/favicons/favicon-32x32.png" sizes="32x32">
	<link rel="icon" type="image/png" href="img/favicons/favicon-16x16.png" sizes="16x16">
	<link rel="manifest" href="img/favicons/manifest.json">
	<link rel="shortcut icon" href="img/favicons/favicon.ico">
	<meta name="msapplication-TileColor" content="#00a8ff">
	<meta name="msapplication-config" content="img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#ffffff">
	
        <!-- Normalize -->
	<link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet">
        
	<!-- Bootstrap -->
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	
        <!-- Owl -->
	<link href="<c:url value="/resources/css/owl.css" />" rel="stylesheet">
	
        <!-- Animate.css -->
	<link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
	
        <!-- Font Awesome -->
	<link href="<c:url value="/resources/fonts/font-awesome-4.1.0/css/font-awesome.min.css" />" rel="stylesheet">
        
        <!-- Elegant Icons -->
	<link href="<c:url value="/resources/fonts/eleganticons/et-icons.css" />" rel="stylesheet">
	
        <!-- Main style -->
	<link href="<c:url value="/resources/css/cardio.css" />" rel="stylesheet">
        
        <script type="text/javascript">
            function url_base(url){ return '${pageContext.request.contextPath}' + '/' +  url ; }
            
        </script>
        
        <style>
            
            #modalMReservas li {
                list-style-type:none;
                text-align: left;
                color:white;
            }
            
            #modalMReservas li p {color: white; margin-top: 20px;  }
            .btn-cancela-evento {padding: 7px; background-color: red; color: white; }
            
            #modal-item-evento p {color:white;}
            #modal-meu-alerta {color:white; font-size: 20px;}
            
        </style>
        

</head>



<body>
	<div class="preloader">
		<img src="<c:url value="/resources/img/loader.gif" />" alt="Preloader image">
        </div>
	<nav class="navbar">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="<c:url value="/resources/img/logo.png" />" data-active-url="<c:url value="/resources/img/logo-active.png" />" alt=""></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right main-nav">
					<li><a href="#intro">Eventos</a></li>
					<li><a href="#services">Fa�a seu evento na UFF</a></li>
					<li><a href="#" data-toggle="modal" data-target="#modalContato">Contato</a></li>
					                                        
                                        <c:choose>
						<c:when test="${logado}">
                                                    <li><a href="#" data-toggle="modal" data-target="#modalMReservas">Reservas</a></li>
                                                    <c:choose>
                                                        <c:when test="${usaadmin}">
                                                            <li><a href="${pageContext.request.contextPath}/admin/painel" class="btn btn-blue">Gerenciador</a></li>    
                                                        </c:when>
                                                    </c:choose>
                                                    <li><a href="${pageContext.request.contextPath}/sair" >Sair</a></li>
						</c:when>
                                                <c:otherwise>
                                                    <li><a href="#" data-toggle="modal" data-target="#modalCadastro">Cadastro</a></li>
                                                    <li><a href="#" data-toggle="modal" data-target="#modalLogin" class="btn btn-blue">Login</a></li>
						</c:otherwise>
					</c:choose>
                                        
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<header id="intro">
		<div class="container">
			<div class="table">
				<div class="header-text">
					<div class="row">
						<div class="col-md-12 text-center">
							<h3 class="light white">Universidade Federal Fluminense</h3>
							<h1 class="white typed">Os melhores eventos est�o aqui!</h1>
							<span class="typed-cursor">|</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section>
		<div class="cut cut-top"></div>
		<div class="container">
			<div class="row intro-tables">
                            <c:forEach items="${eventos}" var="evento">
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
                            </c:forEach>
			</div> <!-- FIM DIV LISTA DE EVENTOS  -->
		</div>
	</section> <!-- FIM SESSAO EVENTOS  -->
	
	
	<!-- MODEL LOGIN   -->
	<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<h3 class="white">Login</h3>
				<form action="" class="popup-form">
					<input type="text" name="login" class="form-control form-white" placeholder="Login / E-mail">
					<input type="password" name="senha" class="form-control form-white" placeholder="Senha">
					<a href="#" class="btn btn-submit btn-logar">Logar</a>
				</form>
                                <div id="form-login-msg"></div>
			</div>
		</div>
	</div>

        <!-- MODEL CADASTRO -->
	<div class="modal fade" id="modalCadastro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<h3 class="white">Cadastro</h3>
				<form action="" class="popup-form">
                                        <input type="hidden" name="perfil" value="1">
					<input type="text" name="nome" class="form-control form-white" placeholder="Nome">
					<input type="text" name="email" class="form-control form-white" placeholder="E-mail">
					<input type="password" name="senhaCadastro" class="form-control form-white" placeholder="Senha">
					<div class="dropdown">
						<button id="dLabel" class="form-control form-white dropdown" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Selecione seu perfil
						</button>
						<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
                                                        <li class="animated lightSpeedIn"><a href="#" data-perfil="1" class="select-perfil-cadastro">Aluno de Gradua��o</a></li>
							<li class="animated lightSpeedIn"><a href="#" data-perfil="2" class="select-perfil-cadastro">Aluno de P�s-Gradua��o</a></li>
							<li class="animated lightSpeedIn"><a href="#" data-perfil="3" class="select-perfil-cadastro">Professor</a></li>
						</ul>
					</div>

					<div class="checkbox-holder text-left">
						<div class="checkbox">
							<input type="checkbox" value="concordada" id="squaredOne" name="check" />
							<label data-checado="0" class="mcheckbox" for="squaredOne"><span>Eu concordo com todos os termos.</span></label>
						</div>
					</div>
                                        <a href="#" class="btn btn-submit btn-cadastrar">Salvar</a>
				</form>
                                <div id="form-cadastro-msg"></div>
			</div>
		</div>
	</div>
        
        <!-- MODEL CONTATO   -->
        <div class="modal fade" id="modalContato" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<h3 class="white">Contato</h3>
				<form action="" class="popup-form">
					<input type="text" class="form-control form-white" placeholder="Nome">
					<input type="text" class="form-control form-white" placeholder="E-mail">
                                        <textarea class="form-control form-white" placeholder="Mensagem"></textarea>
					<button type="submit" class="btn btn-submit">Enviar</button>
				</form>
			</div>
		</div>
	</div>
        
        <!-- MODEL RESERVAS   -->
         <div class="modal fade" id="modalMReservas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
				<h3 class="white">Minhas Reservas</h3>
                                <br />
                                <div id="lista-meus-eventos" >
                                    <ul>
                                    <c:forEach items="${reservas}" var="reserva">
                                        <li data-linha-reserva="${reserva.getReservaId()}">
                                            <p>${reserva.getEvento().getDescricao()}</p>
                                            <a href="#" data-reserva="${reserva.getReservaId()}" class="btn-cancela-evento">Cancelar</a>
                                        </li>    
                                    </c:forEach>
                                    </ul>    
                                </div>
                                <div id="cancela-reserva-msg"></div>
                       </div>
		</div>
	</div>
        
        <!-- MODEL ALERT   -->
        <div class="modal fade" id="modalAlert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
                    <div id="modal-meu-alerta" class="modal-content modal-popup"></div>
		</div>
	</div>
        
        <!-- MODEL DINAMICO EVENTOS   -->
        <c:forEach items="${eventos}" var="evento">
            <div class="modal fade" id="modalEvento${evento.getEventoId()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div id="modal-item-evento" class="modal-content modal-popup">
				<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
                                <br />
                                <p>${evento.getDescricao()}</p>
                                <p>${evento.getCategoria().getDescricao()}</p>
                                <p>${evento.getDataInicioFormatado()}</p>
                                <p>${evento.getPessoa()}</p>
                                <p>${evento.getDescricaoLonga()}</p>
                                <p>${evento.getAmbiente().getDescricao()}</p>
                                <p>${evento.getAmbiente().getEndereco()}</p>
                                <p>${evento.getDuracao()} minutos</p>
			</div>
		</div>
            </div>
        </c:forEach>





	<footer>
		<div class="container">
			<div class="row">
				<div class="col-sm-6 text-center-mobile">
					<h3 class="white">Universidade Federal Fluminense</h3>
					<h5 class="light regular light-white">Sistema de Eventos da Universidade Federal Fluminense</h5>
					<a href="#" class="btn btn-blue ripple trial-button">Acesse o Site</a>
				</div>
				<div class="col-sm-6 text-center-mobile">
					<h3 class="white">Pr�ximos Eventos <span class="open-blink"></span></h3>
					<div class="row opening-hours">
                                            <c:forEach items="${proximoeventos}" var="evento">
                                                <div class="col-sm-6 text-center-mobile">
							<h5 class="light-white light">${evento.getDescricao()}</h5>
							<h3 class="regular white pvento-data-menor">${evento.getDataInicioFormatado()}</h3>
						</div>
                                            </c:forEach>
                                        </div>
				</div>
			</div>
			<div class="row bottom-footer text-center-mobile">
				<div class="col-sm-8">
					<p>&copy; 2017 Todos os direitos reservados. Desenvolvido por <a href="http://www.phir.co/"> Grupo Stark </a> exclusivo para <a href="http://tympanus.net/codrops/">UFF</a></p>
				</div>
				<div class="col-sm-4 text-right text-center-mobile">
					<ul class="social-footer">
						<li><a href="http://www.facebook.com/pages/Codrops/159107397912"><i class="fa fa-facebook"></i></a></li>
						<li><a href="http://www.twitter.com/codrops"><i class="fa fa-twitter"></i></a></li>
						<li><a href="https://plus.google.com/101095823814290637419"><i class="fa fa-google-plus"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!-- Holder for mobile navigation -->
	<div class="mobile-nav">
		<ul>
		</ul>
		<a href="#" class="close-link"><i class="arrow_up"></i></a>
	</div>
	<!-- Scripts -->
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/wow.min.js" />"></script>
        <script src="<c:url value="/resources/js/typewriter.js" />"></script>
        <script src="<c:url value="/resources/js/jquery.onepagenav.js" />"></script>
        <script src="<c:url value="/resources/js/main.js" />"></script>
        <script src="<c:url value="/resources/js/discorp.js" />"></script>
        
        
        
	
</body>

</html>


