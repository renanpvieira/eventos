jQuery(function($) {
	"use strict";
       
	 
       
       $( document ).on( "click", "a.btn-ativar-reserva-admin", function() { 
            
            var botao = $(this);
            var evento = $(this).attr("data-evento");
            var dados = { reserva:$(this).attr("data-reserva") }
            var label = $('a[class="btn btn-danger btn-xs reserva-label"][data-label-reserva="' +  $(this).attr("data-reserva") + '"]');
           
           $.ajax({
                    type:"POST",
                    url : url_base('ativaReservar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                            botao.attr("class", "btn btn-danger btn-xs btn-cancela-reserva-admin");
                            botao.text("Cancelar");
                            label.attr("class", "btn btn-success btn-xs reserva-label");
                            label.text("Ativa");
                        }
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        displayFormMsg(false, "#cancela-reserva-msg", e);
                    }
            });
            
       });
        
       
       $( document ).on( "click", "a.btn-cancela-reserva-admin", function() { 
            
           var botao = $(this);
           var evento = $(this).attr("data-evento");
           var dados = { reserva:$(this).attr("data-reserva") }
           var label = $('a[class="btn btn-success btn-xs reserva-label"][data-label-reserva="' +  $(this).attr("data-reserva") + '"]'); 
           
           $.ajax({
                    type:"POST",
                    url : url_base('cancelaReservar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                            botao.attr("class", "btn btn-info btn-xs btn-ativar-reserva-admin");
                            botao.text("Ativar");
                            label.attr("class", "btn btn-danger btn-xs reserva-label");
                            label.text("Cancelada");
                        }
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        displayFormMsg(false, "#cancela-reserva-msg", e);
                    }
            });
       });
       
       
       
      
        

    
        
       
 });