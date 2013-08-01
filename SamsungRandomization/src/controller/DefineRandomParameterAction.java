package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import formbean.RandomParameterForm;

import model.Model;
import model.RandomizationDAO;

import random.*;


public class DefineRandomParameterAction extends Action {
	private RandomizationDAO randomizationDAO;
	
	public DefineRandomParameterAction(Model model) {
		randomizationDAO = model.getRandomizationDAO();
	}
	
	@Override
	public String getName() {
		return "Define-Random-Parameter.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	RandomParameterForm form = new RandomParameterForm(request);
	        request.setAttribute("form",form);
	        
	        if (!form.isPresent()) {
	            return "define-random-parameter.jsp";
	        }
	        
//	
//	        errors.addAll(form.getValidationErrors());
//	        if (errors.size() != 0) {
//	            return "create-account.jsp";
//	        }
	        
	        Randomization r;
	        if (form.getType().equals("option2")) {
	        	r = new PermutedBlockRandomization(form);
	        } else if (form.getType().equals("option3")) {
	        	r = new StratifiedRandomization(form);
	        } else if (form.getType().equals("option4")) {
	        	r = new DynamicRandomization(form);
	        } else {
	        	r = new SimpleRandomization(form);
	        }
	       	
	       	randomizationDAO.writeRandomization(r);
	        return "Perform-Random.do";
			
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return "error.jsp";
        }
        
	}

}
