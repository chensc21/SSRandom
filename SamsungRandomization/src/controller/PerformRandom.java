/**
 * @author Shoucong Chen
 * Jul 25, 2013
 */

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import formbean.*;

import model.Model;
import model.RandomizationDAO;

import random.*;

public class PerformRandom extends Action {
	private RandomizationDAO randomizationDAO;
	
	public PerformRandom(Model model) {
		randomizationDAO = model.getRandomizationDAO();
	}
	
	@Override
	public String getName() {
		return "Perform-Random.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		Randomization r = randomizationDAO.readRandomization();
		if (r == null) {
			return "Define-Random-Parameter.do";
		}
		
		RandomParameterForm form = new RandomParameterForm(r);
		request.setAttribute("form", form);
		request.setAttribute("subjectList", r.getSubjectList());
		
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	Subject sub = new Subject(request);
	        request.setAttribute("sub", sub);
	        
	        if (!sub.isPresent()) {
	            return "enroll-new-subject.jsp";
	        }
//	
//	        errors.addAll(form.getValidationErrors());
//	        if (errors.size() != 0) {
//	            return "create-account.jsp";
//	        }
	        
	        r.getRandomGroup(sub);
	        randomizationDAO.writeRandomization(r);
	        return "Perform-Random.do";
			
        } catch (Exception e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
        
	}
}
