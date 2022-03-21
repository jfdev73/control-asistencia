/**

l
 * 
 */
 //const prueba = document.querySelectorAll('.prueba');
 let inputStatus = document.querySelectorAll(".status");
 let valorStatus = inputStatus.innerHTML;
 inputStatus.forEach(e => {
	if(e.innerHTML == 1){
		e.innerHTML = "activo";
		
	}else if(e.innerHTML == 2){
		e.innerHTML = "inactivo";
	}
	});
 /*if(valorStatus ==1){
	inputStatus.innerHTML = "activo";
	
}*/
