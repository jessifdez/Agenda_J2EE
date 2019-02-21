<%-- 
    Document   : index
    Created on : 03-dic-2018, 13:35:22
    Author     : Mañanas
--%>

<%@page import="agendaweb.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String estado=(String)request.getAttribute("estado-insercion");
    if(estado==null){
        estado="";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda</title>
        <script src="js/funciones.js" ></script>
        <style>
            #ok {color:green;}
            #ko{color:red;}
        </style>
    </head>
    <body onload="cargarOyentes();">
        <%
            if(estado.equals("OK")){    
        %>
        <h1 id="ok">Todo ha ido bien</h1>
        <% } else if(estado.equals("KO")){ %>
        <h1 id="ko">Se ha producido un error</h1>
        <%} %>
        <form action="ServletContactos" method="POST" id="mi_form">
        <label for="nombre"> NOMBRE: </label>
	<br/>
	<input id="nombre" type="text" name="nombre" class="datos"/>
	<br/>
        <label for="email"> EMAIL: </label>
	<br/>
        <input id="email" type="text" name="email" class="datos"/>
	<br/><br/>
        <input type="hidden" name="accion" value="insertar"/>
        <button id="btn_grabar" disabled="disabled">Grabar contacto</button>
        </form>
        <br/>
        <form action="ServletContactos" method="POST">
        <input type="hidden" name="accion" value="vercontactos"/>
        <input type="submit" value="Ver Contactos"/>
        </form>
    </body>
</html>
