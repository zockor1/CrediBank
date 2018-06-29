//validaciones del formulario de postulacion
function validarForm() {
    if (validarBlancos()) {
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

function Rut(rut){
 var suma=0;
 var arrRut = rut.split("-");
 var rutSolo = arrRut[0];
 var verif = arrRut[1];
 var continuar = true;
 for(i=2;continuar;i++){
  suma += (rutSolo%10)*i;
  rutSolo = parseInt((rutSolo /10));
  i=(i==7)?1:i;
  continuar = (rutSolo == 0)?false:true;
 }
 resto = suma%11;
 dv = 11-resto;
 if(dv==10){
  if(verif.toUpperCase() == 'K')
   return true;
 }
 else if (dv == 11 && verif == 0)
  return true;
 else if (dv == verif)
  return true;
 else
  return false;
}



