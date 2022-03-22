/**

l
 * 
 */
 //const prueba = document.querySelectorAll('.prueba');
 let inputStatus = document.querySelectorAll(".status");
 let valorStatus = inputStatus.innerHTML;
 inputStatus.forEach(e => {
	if(e.innerHTML == 1){
		e.innerHTML = "en espera";
		
	}else if(e.innerHTML == 2){
		e.innerHTML = "aceptado";
	}else if(e.innerHTML ==3){
		e.innerHTML = "rechazado";
	}
	});
 /*if(valorStatus ==1){
	inputStatus.innerHTML = "activo";
	
}*/
