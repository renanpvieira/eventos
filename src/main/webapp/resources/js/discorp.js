jQuery(function($) {
	"use strict";
	

        $('a').on('click', function() {

            $.ajax({
                  url : url_base('ajaxtest'),
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
        
       
 });