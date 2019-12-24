<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.form.js"></script>

</head>
<body>
<form action="getList.do" method="post">
<input type="checkbox" name="lawAddr" value="2">违反进入二环
<input type="checkbox" name="lawAddr" value="4">违反进入四环
<input type="checkbox" name="lawAddr" value="0">无任何违法信息
<input type="checkbox" name="lawAddr" value="1">违反单双号限行
<input type="submit" value="查询">
</form>
	<table>
  <tr>
    <th>车牌号</th>
    <th>车类型</th>
    <th>经度</th>
    <th>纬度</th>
    <th>抓拍时间</th>
    <th>车主姓名</th>
    <th>电话号</th>
     <th>违反法律内容</th>
     <th>是否单双号</th>。
      <th>违法地点</th>
  </tr>
  <c:forEach items="${list }" var="t">
  <tr>
    <td>${t.carNumber }</td>
     <td>${t.carType }</td>
      <td>${t.jd }</td>
       <td>${t.wd }</td>
        <td>${t.regdate }</td>
         <td>${t.uname }</td>
          <td>${t.phone }</td>
           <td>${t.lawMessage }</td>
            <td>${t.isodd }</td>
             <td>${t.lawAddr }</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
