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

function Nombre(nombre)
{
    if (nombre.trim().replace(/\s+/gi, ' ').split(' ').length < 4) {
        return false;
    }else
    {
        return true;
    }
}

function codigoPro(codigo)
{
    if (codigo < 1) {
        return false;
    }else
    {
        return true;
    }
}

function codigoComuna(codigo)
{
    if (codigo < 100 || codigo > 999) {
        return false;
    }else
    {
        return true;
    }
}

function codigoRegion(codigo)
{
    if (codigo < 1 || codigo > 15) {
        return false;
    }else
    {
        return true;
    }
}

