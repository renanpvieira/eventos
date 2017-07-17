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
       
       /* TEMPLATE DESGRAÇADO */
        $(document).on( "click", "label.mcheckbox", function() { 
            //var checado = $('#mydiv').data('data-checado',20);
            var checado = $(this).attr('data-checado');
            if(checado === "0"){
                $("input[type=checkbox][name=concordada]").prop( "checked", true);
                $(this).attr('data-checado', "1");
            }else{
                $("input[type=checkbox][name=concordada]").prop( "checked", false);
                $(this).attr('data-checado', "0"); 
            }
        });
       
       
       $('.btn-cadastrar').on('click', function() {
           
           /*  FAZER DEPOIS
           if (!$('input[type=checkbox][name=concordada]').is(":checked"))
           {
             displayFormMsg(false, "#form-cadastro-msg", 'Você precisa concordar com os termos!');
             return
           }
           */
           
           var dados = {
               nome: $("input[type=text][name=nome]").val(),
               email:$("input[type=text][name=email]").val(),
               senha:$.trim($("input[type=password][name=senhaCadastro]").val()),
               perfil:$("input[type=hidden][name=perfil]").val()
           }

          $.ajax({
                    type:"POST",
                    url : url_base('cadastrar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                           displayFormMsg(true, "#form-cadastro-msg", ret.msg);
                        }else{
                           displayFormMsg(false, "#form-cadastro-msg", ret.msg);
                        }
                    },
                    error : function(e) {
                        displayFormMsg(false, "#form-cadastro-msg", 'Ocorreu um erro desconhecido!');
                        console.log("ERROR: ", e);
                    }
            });
           
       });
       
       
       $('.btn-logar').on('click', function() {
           
           var dados = {
               login:$.trim($("input[type=text][name=login]").val()),
               senha:$.trim($("input[type=password][name=senha]").val())
           }
           
           $.ajax({
                    type:"POST",
                    url : url_base('logar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                           displayFormMsg(true, "#form-login-msg", ret.msg);
                           setTimeout(function() {
                                window.location = url_base('/'); 
                            }, 2500);
                        }else{
                           displayFormMsg(false, "#form-login-msg", ret.msg);
                        }
                    },
                    error : function(e) {
                        displayFormMsg(false, "#form-login-msg", 'Ocorreu um erro desconhecido!');
                        console.log("ERROR: ", e);
                    }
            });
       });
       /* FIM LOGIN   */
        
        
       $('.btn-reservar').on('click', function() {
            var dados = {
               reserva:$(this).attr("data-evento")
            }
            
            $.ajax({
                    type:"POST",
                    url : url_base('reservar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        $('#lista-meus-eventos ul').append(novaLinhaReserva(ret.nome, ret.reserva));
                        $('#modalAlert .modal-dialog .modal-content').html(ret.msg);
                        $('#modalAlert').modal('show', {backdrop: 'static'});
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        $('#modalAlert .modal-dialog .modal-content').html(e);
                        $('#modalAlert').modal('show', {backdrop: 'static'});
                    }
            });
       });
       
       $( document ).on( "click", ".btn-cancela-evento", function() { 
            var linha =  $('li[data-linha-reserva="' +  $(this).attr("data-reserva") + '"]');
            
            var dados = {
               reserva:$(this).attr("data-reserva")
            }
            
            $.ajax({
                    type:"POST",
                    url : url_base('cancelaReservar'),
                    data: dados, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        console.log("SUCCESS: ", ret.msg);
                        if(ret.estatus === "sucesso"){
                            linha.remove();
                            displayFormMsg(true, "#cancela-reserva-msg", ret.msg);
                        }else{
                            displayFormMsg(false, "#cancela-reserva-msg", ret.msg);
                        }
                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        displayFormMsg(false, "#cancela-reserva-msg", e);
                    }
            });
       });
        
        
       function displayFormMsg(valid, div, msg) {
    
            if(valid){
                $(div).css('color', '#d9edf7');
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
        
       function novaLinhaReserva(nome, reserva ){
            return '<li data-linha-reserva="' + reserva +'"><p>' + nome + '<a href="#" data-reserva="' + reserva  +'" class="btn btn-primary btn-sm btn-cancela-evento">Cancelar</a></p></li> ';
        }
        
        
       
 });