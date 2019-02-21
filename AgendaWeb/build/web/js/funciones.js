function cargarOyentes(){
	document.getElementById("nombre").onkeyup=function(){comprobarCampos();};
	document.getElementById("email").onkeyup=function(){comprobarCampos();};
}
function comprobarCampos(){
    var nombre=document.getElementById("nombre").value;
    var email=document.getElementById("email").value;
    var nombre_ok=verificarNombre(nombre);
    var email_ok=verificarEmail(email);
    if(email_ok && nombre_ok){
        document.getElementById("btn_grabar").disabled=false;
    }else{
        document.getElementById("btn_grabar").disabled=true;
    }
}
function verificarNombre(nombre){
        var respuesta=(nombre=="")?false:true;
        return respuesta;
}
function verificarEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
	


