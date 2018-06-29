//validaciones del formulario de postulacion
function validarForm() {
    if (validarBlancos() && valida_rut()) {
        return true;
    }
    return false;
}


function validarBlancos() {
    var rut    = document.getElementById("Form:rut");
    var nombre = document.getElementById("Form:nombre");
    var apellP = document.getElementById("Form:apellP");
    var fecha  = document.getElementById("Form:fecnac_input");
    var estado = document.getElementById("Form:estado");
    var email  = document.getElementById("Form:email");
    var direc  = document.getElementById("Form:direc");
    var renta  = document.getElementById("Form:renta");
    var sueldo = document.getElementById("Form:sueldo");

    if (rut.value === '' || nombre.value === '' || apellP.value === '' || fecha.value === ''
            || estado.value < 2 || email.value === '' || direc.value === '' || renta.value < 2 
            || sueldo.value === '') {
        alert("Los Campos Con (*) Son Obligatorios");
        return false;
    }
    return true;

}

function valida_rut() {
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

function validarFecha(){
    
}



