/**
 * 
 */
 
$('.registerFormFcMv').bootstrapValidator({
    live: 'enabled',
    fields: {
        newinputTratFechaIni: {
            validators: {
                date: {
                    format: 'DD/MM/YYYY',
                    message: 'ESTE VALOR NO COINCIDE CON UNA FECHA'
                },
                stringLength: {
                    min: 10,
                    max: 10,
                    message: 'LA LONGITUD MÁXIMA ES DE 10 INCLUYENDO /'
                },
                regexp: {
                    regexp: /^[0-9-/]+$/,
                    message: 'LA FECHA SOLO PUEDE TENER NÚMEROS Y /'
                }
            }
        }

    }
});
 
 $('.datepicker3').datepicker({

    container: '.container-calendar',
    autoclose: false,
    multidate:true,
    todayHighlight: true,
    format: 'dd/mm/yyyy',
    language: 'es',
    daysOfWeekDisabled:"0,6",
    weekStart:0,
    startDate: new Date(""),
    //endDate: new Date("27/03/2022".replace(/-/g, "/"))
   

});