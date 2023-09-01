<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<%@ include file ="header.jsp" %>
  <body>
    <div class="container">
      <h1>
      	c:forEach 반복
      </h1> 
      <%
      	ArrayList<String> list = new ArrayList<String>();
      	list.add("홍길동");
      	list.add("이순신");
      	list.add("유관순");
      	request.setAttribute("name", list);    
      %>
      <table class="table table-hover">
      	<thead>
      		<tr>
      			<th style="width:40px">No</th>
      			<th>이름</th>
      		</tr>
      	</thead>
      	
      	<tbody>
      	<c:forEach var="n" items="${name}" varStatus="status">
      		<tr>
      			<td>${status.count}</td>
      			<td>${n}</td>
      		</tr>
      		</c:forEach>
      	</tbody>
      </table>      
    </div>
<%@ include file ="footer.jsp" %>