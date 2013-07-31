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
	        switch (form.getType()) {
	        	case 1:
	        		r = new PermutedBlockRandomization(form);
	        		break;
	        	case 2:
	        		r = new StratifiedRandomization(form);
	        		break;
	        	case 3:
	        		r = new DynamicRandomization(form);
	        		break;
	        	default:
	        		r = new SimpleRandomization(form);
	        }
	       	
	       	randomizationDAO.writeRandomization(r);

	        return "define-random-parameter.jsp";
			
        } catch (Exception e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
        
	}

}
