/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaweb;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PintarHTML {//Clase para que te muestre los contactos en una lista
    public static String crearLista(ArrayList<Contacto> lista){
        String html="<ul>";
        for (Contacto contacto : lista) {
            html+="<li>"+contacto.getNombre()+":"+contacto.getEmail()+"</li>";  
        }
        html+="</ul>";
        return html;
    }
    
}
