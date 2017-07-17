<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <style>
            *{padding: 0px; margin: 0px;}
            img {position: absolute; margin-top: 20px; margin-left: 20px;}
            #nome { position: absolute;  top: 190px; width:540px;
                    left:150px;
                    text-align: center;
                    font-size: 25px;
            }
            
            #curso { position: absolute;  top: 249px; width:360px;
                    left:328px;
                    text-align: center;
                    font-size: 17px;
            }
            
            #mini { position: absolute;   top: 285px; width:318px;
                    left:328px;
                    text-align: center;
                    font-size: 17px;
            }
            
            #duracao { position: absolute; top: 320px; width:52px;
                    left:462px;
                    text-align: center;
                    font-size: 17px;
            }
            
            #data { position: absolute;  top: 392px; width:180px;
                    left:410px;
                    text-align: center;
                    font-size: 17px;
            }
            
        </style>
    </head>
    <body>
        <img src="<c:url value="/resources/img/certificado.jpg" />" alt="..." class="img-circle profile_img">
        <p id="nome">${reserva.getUsuario().getNome()}</p>
        <p id="curso">${reserva.getEvento().getDescricao()}</p>
        <p id="mini">${reserva.getEvento().getPessoa()}</p>
        <p id="duracao">${reserva.getEvento().getDuracao()}</p>
        <p id="data">${reserva.getDataReservaFormatado()}</p>
    </body>
</html>
