(function(){

const opcion = document.querySelectorAll('.menu__item--show');
const prueba = document.querySelectorAll('.prueba');
const h = document.querySelector('.menu__nesting');
const flecha = document.querySelector('.menu__arrow');
const list = document.querySelector('.menu__links');
const menu = document.querySelector('.menu__hamburguer')
console.log("esta es: ",h);
console.log("opcion",{opcion});

// Permite recorrer cada una de nuestras opciones
opcion.forEach(e => {

    // Añadimos un evento a cada elemento seleccionado
    e.addEventListener('click', function(e){

        // Alteranmos las clases de nuestros enlaces
        const padre = e.target.parentNode;
        console.log("padre:", padre);
        padre.children[1].classList.toggle('hola');
        console.log("segundo hijo", padre.children[1]);
        padre.parentNode.children[1].classList.toggle('hola');
        h.classList.toggle('view');
        flecha.classList.toggle('menu__90');
    });


});
menu.addEventListener('click', ()=> list.classList.toggle('menu__links--show'));

})();