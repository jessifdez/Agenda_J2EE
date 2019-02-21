/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {//Quitamos los try-catch y los ponemos como throws para obligarle a que me diga si graba o no
    public static void crearTabla() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_web?serverTimezone=UTC", "root","");
	         Statement stmt=connection.createStatement();
	         String query="CREATE TABLE  if not exists contactos "
	                +"( Nombre varchar(50), Email varchar(80))";
	         stmt.executeUpdate(query);
	         stmt.close();
	         connection.close();
		}
                
    public static void grabarContacto(Contacto c) throws ClassNotFoundException, SQLException {
        crearTabla();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_web?serverTimezone=UTC", "root","");
            Statement stmt=connection.createStatement();
            //Para insertar
            String query="INSERT INTO contactos VALUES('"+c.getNombre()+"', '"+c.getEmail()+"')";
            //Para ver el fallo puedes pedir que te imprima la query:sout(query)
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();    
    }

    public static ArrayList<Contacto> listarContactos() {
        ArrayList<Contacto> lista_contactos=new ArrayList ();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_web?serverTimezone=UTC", "root","");
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM contactos");
            while(rs.next())
            {
                String nombre=rs.getString("Nombre");
                String email=rs.getString("Email"); 
                Contacto c=new Contacto(nombre, email);
                lista_contactos.add(c);
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_contactos;
    }
}
