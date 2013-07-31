$(document).ready(function () {
    $('.group').hide();
    $('#option1').show();
    $('#selectMe').change(function () {
        $('.group').hide();
        $('#'+$(this).val()).show();
    })
});


	var elementCount = 0;   
    function AddElement(){     
        var TemO=document.getElementById("strata_para");     
        var newInput = document.createElement("div");      
          
        elementCount = elementCount + 1;     
          
        //动态生成id。  
        newInput.id="input"+(elementCount);     
        
        newInput.innerHTML = '<div class="one_parameter span12">' 
							+				'<div class="left">'
							+					'<select class="input-small" name="input'+elementCount+'" class="chzn-select">
							+						'<option value=""></option>'
							+						'<option value="age">Age</option>'
							+						'<option value="gender">Gender</option>'
							+					'</select>' 
							+				'</div>'
							+				'<div class="one_parameter_right">'
							+					'<ul class="para_ul left">'
							+							'<li>Male</li>'
							+							'<li>Female</li>'
							+						'</ul>'
							+               '</div>'
							+'</div>';
							
        TemO.appendChild(newInput);     
             
        var newline= document.createElement("br");   
          
        newline.id = "br"+(elementCount);   
          
        TemO.appendChild(newline);     
        /*multiple select function */
		$(".chzn-select").chosen();
    }     
    
    var elementCount1 = 0;   
    function AddElement1(){     
        var TemO=document.getElementById("strata_para1");     
        var newInput = document.createElement("div");      
          
        elementCount1 = elementCount1 + 1;     
          
        //动态生成id。  
        newInput.id="input1"+(elementCount1);     
        
        newInput.innerHTML = '<div class="one_parameter span12">' 
							+				'<div class="left">'
							+					'<select class="input-small" name="input'+elementCount1+'" class="chzn-select">'
							+						'<option value=""></option>'
							+						'<option value="age">Age</option>'
							+						'<option value="gender">Gender</option>'
							+					'</select>' 
							+				'</div>'
							+				'<div class="one_parameter_right">'
							+					'<ul class="para_ul left">'
							+							'<li>Male</li>'
							+							'<li>Female</li>'
							+						'</ul>'
							+               '</div>'
							+'</div>';
							
        TemO.appendChild(newInput);     
             
        var newline= document.createElement("br");   
          
        newline.id = "br"+(elementCount);   
          
        TemO.appendChild(newline);     
        /*multiple select function */
		$(".chzn-select").chosen();
    }     
      
    function delElement(mytype){     
        var TemO=document.getElementById("add");     
          
        if (elementCount>0){     
            var newInput = document.getElementById("input"+elementCount);      
             
            TemO.removeChild(newInput);   
     
            var newline= document.getElementById("br"+(elementCount));   
              
            elementCount = elementCount - 1;    
              
            TemO.removeChild(newline);     
        }   
    }     
