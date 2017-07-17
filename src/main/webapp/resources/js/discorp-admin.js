jQuery(function($) {
	"use strict";
        
       $(document).on( "click", "a.btn-autorizar-evento", function() {
          var btn = $(this);
          var dados = { evento:btn.attr("data-evento"), acao:2 }
          acao(2, dados, btn);
       });
       
       $(document).on( "click", "a.btn-ativar-evento", function() {
          var btn = $(this);
          var dados = { evento:btn.attr("data-evento"), acao:2 }
          acao(2, dados, btn);
       });
        
       $(document).on( "click", "a.btn-cancelar-evento", function() {
          var btn = $(this);
          var dados = { evento:btn.attr("data-evento"), acao:1 }
          acao(1, dados, btn);
       });
       
       function  acao(acao, data, btn){
                $.ajax({
                    type:"POST",
                    url : url_base("evento/trocaestatus"),
                    data: data, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        if(ret.estatus === "sucesso"){
                            if(acao === 2){
                              sucessoAtivar(btn);
                            }else{
                              sucessoCancela(btn); 
                            }
                        }
                        console.log("SUCCESS: ", data);
                    },
                    error : function(e) { console.log("ERROR: ", e);  }
                });
       } 
       
       function sucessoCancela(btn){
           var label = $('.label-evento[data-label-evento="' + btn.attr("data-evento") + '"]');
           label.attr("class", "btn btn-danger btn-xs label-evento");
           label.text("Cancelado");
           btn.attr("class", "btn btn-info btn-xs btn-ativar-evento");
           btn.text("Ativar");
       }
       
       function sucessoAtivar(btn){
           var label = $('.label-evento[data-label-evento="' + btn.attr("data-evento") + '"]');
           label.attr("class", "btn btn-success btn-xs label-evento");
           label.text("Autorizado");
           btn.attr("class", "btn btn-danger btn-xs btn-cancelar-evento");
           btn.text("Cancelar");
       }
       
 });