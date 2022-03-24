/**
 * 
 
let pp1e = document.getElementById('1');
let pp2e = document.getElementById('2);


/********  input type date  ********/
let dateDia = document.querySelector('.dia');
let datePeriodo = document.querySelector('.periodo');
console.log("Dia",dia);
/*10 =periodo*/

function mostrarInputDate(tipo) {
if(tipo ==10){
  dateDia.classList.add('ocultar');
  datePeriodo.classList.remove('ocultar');
  /*11 =dia*/
}else if(tipo==11){
  dateDia.classList.remove('ocultar');
  datePeriodo.classList.add('ocultar');
}
  
}

/*if(periodo.value !=null){
periodo.addEventListener('click', function tipo() {
  if(periodo.checked){
let valorPeriodo = periodo.value;
mostrarInputDate(valorPeriodo);
  }
});
}
dia.addEventListener('click', function tipo() {

  if(dia.checked){
let valorPeriodo = dia.value;
mostrarInputDate(valorPeriodo);
  }
});
*/