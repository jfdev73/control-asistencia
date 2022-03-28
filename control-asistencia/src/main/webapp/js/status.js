/**

l
 * 
 */
 //const prueba = document.querySelectorAll('.prueba');
 let inputStatus = document.querySelectorAll(".status");
 let valorStatus = inputStatus.innerHTML;
 
 let inputTipo = document.querySelectorAll(".tipoc");
 let valorTipo = inputTipo.innerHTML;
 
 let inputCausa = document.querySelectorAll(".causa");
 let valorCausa = inputTipo.innerHTML;
 
 console.log("valor de tipo: ",inputTipo);
 console.log("Valor de causa: ", inputCausa);
 
 inputTipo.forEach(tipo => {
	switch(tipo.innerHTML){
		case "8":{
			tipo.innerHTML = "Por autorizaci\u00F3n del superior inmediato";
			if(inputCausa == 0){
				inputCausa.innerHTML = "Hols";
			}
				break;
			}
		case "9":{
			tipo.innerHTML = "Licencias";
			break;
		}
		case "10":{
			tipo.innerHTML = "Licencias";
			break;
		}
			
		}
		
	

	});
 
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
