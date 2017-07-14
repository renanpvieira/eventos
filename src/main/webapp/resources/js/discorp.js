jQuery(function($) {
	"use strict";
	
        /*

        $('a').on('click', function() {

            $.ajax({
                    type:"POST",
                    url : url_base('logar'),
                    data: { nome: "Renan", idade:30}, 
                    timeout : 100000,
                    success : function(data) {
                            console.log("SUCCESS: ", data);
                            
                    },
                    error : function(e) {
                            console.log("ERROR: ", e);
                            
                    },
                    done : function(e) {
                            console.log("DONE");
                    }
            });

	});
        */
       
       $('.select-perfil-cadastro').on('click', function() {
           $("input[type=hidden][name=perfil]").val($(this).attr("data-perfil"));
       });
       
       
       $('.btn-cadastrar').on('click', function() {
           
           var dados = {
               nome: $("input[type=text][name=nome]").val(),
               email:$("input[type=text][name=email]").val(),
               senha:$("input[type=password][name=senha]").val(),
               perfil:$("input[type=hidden][name=perfil]").val()
           }
           
           console.log(dados);
           
       });
        
        
        
       
 });