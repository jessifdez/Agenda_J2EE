<%-- 
    Document   : vercontactos
    Created on : 03-dic-2018, 13:51:03
    Author     : Mañanas
--%>

<%@page import="agendaweb.PintarHTML"%>
<%@page import="agendaweb.AccesoBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="agendaweb.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Contacto> lista_contactos=(ArrayList<Contacto>)request.getAttribute("contactos");
    //String html_lista=PintarHTML.crearLista(lista_contactos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista contactos</title>
    </head>
    <body>
        <table>
            <tr><th>Nombre</th><th>Email</th></tr>
            <%
                for(int i=0;i<lista_contactos.size();i++){
                Contacto c=lista_contactos.get(i);
            %>
            <tr><td><%=c.getNombre() %></td><td><%=c.getEmail() %></td></tr>
          <%} %> 
        </table>
    </body>
</html>
