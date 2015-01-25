<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
    function upload(){
    var time=new Date().getTime();
    document.getElementById('img').src="<%=path %>/servlet/VerificationCodeServlet?d="+time;
    }
  
  
  
  </script>
  
  <body>
  <form action="<%=path %>/servlet/LoginServlet">
   验证码：<input name="code" type="text"></input>
       <img id="img" src="<%=path %>/servlet/VerificationCodeServlet">
       <a href="javascript:upload();">看不清楚</a>
       <br>
       <input type="submit"></input>  
      </form> 
  </body>
</html>
