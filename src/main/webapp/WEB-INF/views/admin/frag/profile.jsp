<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="profile clearfix">
          <div class="profile_pic">
                <img src="<c:url value="/resources/img/img.jpg" />" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
            <span>Bem vindo,</span>
        <h2>${usuariologado.getNome()}</h2>
      </div>
</div>
