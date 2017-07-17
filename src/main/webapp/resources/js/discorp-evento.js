jQuery(function($) {
	"use strict";
        
       $( document ).on( "click", "a.calcula", function() {
             execCalculaReservas();
       });
       
       execCalculaReservas();
       
       function execCalculaReservas(){
            var dados = { evento:4 }
             
             $.ajax({
                    type:"POST",
                    url : url_base('evento/reservasnaocanceladas'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret);
                        if(ret.estatus === "sucesso"){
                           calculaReservas(ret.lista);
                        }
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                    }
            });
           
           
       }
       
       
       function calculaReservas(lista){
           var ocupacao = $("input[type=hidden][name=qtdocup]").val();
           console.log(lista);
           
           //
           for (var i = 0; i < lista.length; i++) {
               
               var label = $('a.reserva-label[data-label-reserva="' +  lista[i].reservaId + '"]');
               
               if(i < ocupacao){
                 label.attr("class", "btn btn-success btn-xs reserva-label");
                 label.text("Ativa");
               }else{
                 label.attr("class", "btn btn-warning btn-xs reserva-label");
                 label.text("Excedente"); 
                   
               }
            }
           
       }
       
       
       
        
        
       $( document ).on( "click", "a.salvar-evento", function() {
             
              var dados = { 
                  eventoid:$("input[type=hidden][name=EventoId]").val(),
                  descricao:$("input[type=text][name=descricao]").val(),
                  pessoa:$("input[type=text][name=pessoa]").val(),
                  descricaolonga:$("textarea[name=DescricaoLonga]").val(),
                  categoria:$("select[name=categoria]").val(),
                  ambiente:$("select[name=ambiente]").val(),
                  ocupacao:$("input[type=text][name=ocupacao]").val(),
                  duracao:$("input[type=text][name=duracao]").val(),
                  datainicio:$("input[type=text][name=DataInicio]").val(),
                  horainicio:$("input[type=text][name=HoraInicio]").val()
              }
              
              $.ajax({
                    type:"POST",
                    url : url_base('evento/salvarevento'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                           $("input[type=hidden][name=EventoId]").val(ret.id); 
                           displayFormMsg(true, "#form-evento-msg", ret.msg);
                        }else{
                           displayFormMsg(false, "#form-evento-msg", ret.msg);
                        }
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        displayFormMsg(false, "#form-evento-msg", e);
                    }
                });
       });
	 
       
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
                            atualizaQtdReservas(evento);
                            execCalculaReservas();
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
                            atualizaQtdReservas(evento);
                            execCalculaReservas();
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
       
       function atualizaQtdReservas(idevento){
           var dados = {evento:idevento}
           $.ajax({
                type:"POST",
                url : url_base('evento/getqtdreservas'),
                data: dados, 
                timeout : 100000,
                success : function(data) {
                    var ret = $.parseJSON(data);
                    var texto = ret.qtd + ' - ' + ret.perc + '% ocupado';
                    $("#barra").attr("data-transitiongoal", ret.perc);
                    $('#barra').progressbar();
                    $('#percentual').html(texto);
                    console.log("SUCCESS: ", ret.perc);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                }
            });
       }
       
       function displayFormMsg(valid, div, msg) {
    
            if(valid){
                $(div).css('color', '#6588FF');
            }else{
                $(div).css('color', '#ff5050');
            }

            $(div).html('');
            $(div).append(msg);

            $(div).delay(1500).fadeOut(2000, function () {
                //$(div).css('background-color', 'white');
                $(div).html('');
                $(div).fadeIn(1);
            });
        } 
       
      
        

    
        
       
 });