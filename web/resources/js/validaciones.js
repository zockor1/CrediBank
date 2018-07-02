//validaciones del formulario de postulacion
function validarForm() {
    if (validarBlancos() && valida_rut() && valEmail()) {
        return true;
    }
    return false;
}

function validaBuscar(){
    if (valida_rut()) {
        return true;
    }
    return false;
}


function validarBlancos() {
    //Valida los espacios en blancos obligatorios
    var rut    = document.getElementById("Form:rut");
    var nombre = document.getElementById("Form:nombre");
    var apellP = document.getElementById("Form:apellP");
    var fecha  = document.getElementById("Form:fecnac_input");
    var estado = document.getElementById("Form:estado");
    var email  = document.getElementById("Form:email");
    var direc  = document.getElementById("Form:direc");
    var renta  = document.getElementById("Form:renta");
    var sueldo = document.getElementById("Form:sueldo");
    var telefono = document.getElementById("Form:telefono");
    var comuna = document.getElementById("Form:comuna");
    var educacion = document.getElementById("Form:educacion");

    if (rut.value === '' || nombre.value === '' || apellP.value === '' || fecha.value === ''
            || estado.value < 2 || email.value === '' || direc.value === '' || renta.value < 2 
            || sueldo.value === '' || telefono.value === '' || comuna.value < 1 || educacion.value < 2) {
        alert("Los Campos Con (*) Son Obligatorios");
        return false;
    }
    return true;

}

function valida_rut() {
    //Validador RUT chileno, sin formato
        var Objeto = document.getElementById("Form:rut");
	var tmpstr = "";
	var intlargo = Objeto.value;
	if (intlargo.length> 0)
	{
		crut = Objeto.value;
		largo = crut.length;
		if ( largo <2 )
		{
			alert('rut inválido');
			Objeto.focus();
			return false;
		}
		for ( i=0; i <crut.length ; i++ )
		if ( crut.charAt(i) !== ' ' && crut.charAt(i) !== '.' && crut.charAt(i) !== '-' )
		{
			tmpstr = tmpstr + crut.charAt(i);
		}
		rut = tmpstr;
		crut=tmpstr;
		largo = crut.length;
 
		if ( largo> 2 )
			rut = crut.substring(0, largo - 1);
		else
			rut = crut.charAt(0);
 
		dv = crut.charAt(largo-1);
 
		if ( rut === null || dv === null )
		return 0;
 
		var dvr = '0';
		suma = 0;
		mul  = 2;
 
		for (i= rut.length-1 ; i>= 0; i--)
		{
			suma = suma + rut.charAt(i) * mul;
			if (mul === 7)
				mul = 2;
			else
				mul++;
		}
 
		res = suma % 11;
		if (res===1)
			dvr = 'k';
		else if (res===0)
			dvr = '0';
		else
		{
			dvi = 11-res;
			dvr = dvi + "";
		}
 
		if ( dvr !== dv.toLowerCase() )
		{
			alert('El Rut Ingreso es Invalido');
			return false;
		}
		return true;
	}
}
     
function valNumber(){
    //Permite solo ingresos de números
    var key = window.event ? event.keyCode : event.which;
    if ( key < 48 || key > 57) {
        return false;
    }else {
        return true;
    }
}

function valIngresoRut() {
       //Permite solo ingresos de números y letra K
    var key = window.event ? event.keyCode : event.which;
    if ( event.keyCode === 75 || event.keyCode === 107) {
        return true;
    } else  if (key < 48 || key > 57) {
        return false;
    } else {
        return true;
    } 
}

function valLetter(){
    //Permite solo ingresos de letras y caracter: (')
    var key = window.event ? event.keyCode : event.which;
    if (event.keyCode === 39){
        return true;
    } else if ( key < 65 || key > 90 && key < 97 || key > 122 ) {
        return false;
    } else {
        return true;
    } 
}

function valEmail() {
    //Valida el formato del email ingresado
    var email = document.getElementById("Form:email");
    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
    if (pattern.test(email.value)) {
        return true;
    } else {
        alert('Formato incorrecto: ' + email.value);
        return false;
    }
}

function validarLogin() {
    if (validarBlancosLogin()) {
        return true;
    }
    return false;
}

function validarBlancosLogin() {
    //Valida los espacios en blancos obligatorios
    var usuario    = document.getElementById("FormLogin:usuario");
    var pass    = document.getElementById("FormLogin:clave");

    if (usuario.value === '' ||pass.value === '') {
        alert("Los campos no pueden quedar en blanco");
        return false;
    }
    return true;

}

