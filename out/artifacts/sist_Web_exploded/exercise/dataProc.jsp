<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String bloodType = request.getParameter("bloodType");
	String name = request.getParameter("name");
	String color = "";

	if (bloodType.equals("A")) {
		color = "lightyellow";
	} else if (bloodType.equals("B")) {
		color = "lightblue";
	} else if (bloodType.equals("AB")) {
		color = "lightgreen";
	} else if (bloodType.equals("O")){
		color = "lightpink";
	} else {
		color = "black";
	}
	
	request.setAttribute("name", name);
	request.setAttribute("bloodType", bloodType);
	request.setAttribute("color", color);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("receiveData.jsp");
	dispatcher.forward(request, response);
%>