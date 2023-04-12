<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import= "model.JavaBeans"%>
    <%@ page import= "java.util.ArrayList"%>
    
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)
    	request.getAttribute("contatos");
   
    %>
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="img/telefone.png">
</head>
<body>
 	<h1>Agenda de Contatos </h1>
 	<a href = "Novo.html" class = "Botao1">Novo Contato</a>
 	<table id = "tabela" >
		<thead> 
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-Mail</th>
				<th>Opções</th>
			</tr>
		</thead> 	
		
		<tbody>
			
			<% for(int i = 0; i < lista.size(); i++) { %>
			
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail() %></td>
					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao1">Editar</a></td>
					
				</tr>
			
			<%} %>
			
		</tbody>
 		
 	</table>
</body>
</html>