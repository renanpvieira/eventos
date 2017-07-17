<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Menu <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${pageContext.request.contextPath}/admin">Eventos</a></li>
                      <c:choose>
                        <c:when test="${usuariologado.getIsGerente()}">
                             <li><a href="${pageContext.request.contextPath}/usuario/painel">Usuários</a></li>
                        </c:when>
                      </c:choose>
                    </ul>
                  </li>
                </ul>
              </div>
</div>