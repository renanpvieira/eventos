<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="${pageContext.request.contextPath}/admin" class="site_title"><i class="fa fa-graduation-cap"></i> <span>UFF - Eventos</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <jsp:include page="profile.jsp" />
            
            <!-- sidebar menu -->
            <jsp:include page="menu.jsp" />
            
            <!-- /menu footer buttons -->
            <jsp:include page="menufooter.jsp" />
            
            <!-- /menu footer buttons -->
          </div>
</div>
