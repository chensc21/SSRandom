   //fold and unfold div boxes
   $(".script-edit").click(function(){
   		var $target = $(this).next('.box-content');
   		
   		if($target.is(':visible')) 
   			{ 
   				$('.arrow',$(this)).removeClass('icon-chevron-up').addClass('icon-chevron-down');
   				$("#validation-footer").css("margin-bottom","40px");
   			} else {
   				$('.arrow',$(this)).removeClass('icon-chevron-down').addClass('icon-chevron-up');
   				$("#validation-footer").css("margin-bottom","380px");
   			} 					   
		$target.slideToggle();
		
   });
   
   
   //java script for code.
	var editor = CodeMirror.fromTextArea(document.getElementById("code"), {  
       lineNumbers: true,  
       extraKeys: {"Ctrl-Space": function(cm) {CodeMirror.simpleHint(cm, CodeMirror.javascriptHint);}}  
   });  
   $(".CodeMirror-scroll").hover(function(){  
       $(this).get(0).style.cursor = "text";  
   });  
   
    
    //function for Sample test
    var elementCount = 0; 
	function AddLine(){     
        var TemO=document.getElementById("sample_test_input");     
        var newInput = document.createElement("tr");      
          
        elementCount = elementCount + 1;     
          
         
        newInput.id="input"+(elementCount);     
        
        newInput.innerHTML = '<tr>' 
							+	'<td>'
							+		'<select data-placeholder="Variable..." class="chzn-select">'
							+				 	'<option value=""></option>'
							+		 		 	'<option value="age">Age</option>'
							+		 		 	'<option value="gender">Gender</option>'
							+		 		 	'<option value="pregnent">Pregnent</option>'
							+		'</select>'
							+	'</td>'
							+	'<td> <input type="text"/>  <i class="icon-remove"></i> </td>'
							+	'</tr>';
             
        TemO.appendChild(newInput);     
        $(".chzn-select").chosen();
    }     