<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/js/fastclick.js" />"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/js/nprogress.js" />"></script>
    <!-- bootstrap-progressbar -->
    <script src="<c:url value="/resources/js/bootstrap-progressbar.min.js" />"></script>
    
    <script type="text/javascript">
            function url_base(url){ return '${pageContext.request.contextPath}' + '/' +  url ; }
    </script>
