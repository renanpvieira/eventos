jQuery(function($) {
	"use strict";
        
       $(document).on( "click", "a.btn-desativar-usuario", function() {
          var btn = $(this);
          var dados = { usuario:btn.attr("data-usuario")}
          acao(btn, dados, 'usuario/desativar', 'success', 'ativar', 'Ativar');
       });
       
       $(document).on( "click", "a.btn-ativar-usuario", function() {
          var btn = $(this);
          var dados = { usuario:btn.attr("data-usuario")}
          acao(btn, dados, 'usuario/ativar', 'danger', 'desativar', 'Desativar');
       });
       
       $(document).on( "click", "a.btn-desativarPainel-usuario", function() {
          var btn = $(this);
          var dados = { usuario:btn.attr("data-usuario")}
          acao(btn, dados, 'usuario/desativarPainel', 'success', 'ativarPainel', 'Ativar Painel');
       });
       
       $(document).on( "click", "a.btn-ativarPainel-usuario", function() {
          var btn = $(this);
          var dados = { usuario:btn.attr("data-usuario")}
          acao(btn, dados, 'usuario/ativarPainel', 'danger', 'desativarPainel', 'Desativar Painel');
       });
       
       
       
       
       
       function  acao(btn, data, url, p1, p2, texto){
                
                var mask = 'btn btn-' + p1 + ' btn-xs btn-'+ p2 +'-usuario';
                
                $.ajax({
                    type:"POST",
                    url : url_base(url),
                    data: data, 
                    timeout : 100000,
                    success : function(data) {
                        var ret = $.parseJSON(data);
                        if(ret.estatus === "sucesso"){
                            btn.attr("class", mask);
                            btn.text(texto);
                        }
                        console.log("SUCCESS: ", ret.estatus);
                    },
                    error : function(e) { console.log("ERROR: ", e);  }
                });
                
       } 
	 
    
      
        

    
        
       
 });