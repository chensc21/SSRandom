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
		
//		System.out.println("Enter Perform Random");
		RandomParameterForm form = new RandomParameterForm(r);
		List<Subject> subList = r.getSubjectList();
		int subListLen = subList.size();
		Subject lastSub = new Subject();
		if (subListLen > 0) lastSub = subList.get(subListLen - 1);
		
		request.setAttribute("form", form);
		request.setAttribute("subjectList", subList);
		request.setAttribute("subListLen", subListLen);
		request.setAttribute("lastSub", lastSub);
		
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	Subject sub = new Subject(request);
	        request.setAttribute("sub", sub);
	        
	        // Check whether page is displayed
	        if (!sub.isPresent()) {
	            return "enroll-new-subject.jsp";
	        }
	        
	        // Check whether subject id is duplicated.
	        for (Subject curSub : r.getSubjectList()) {
	        	if (sub.getId().equals(curSub.getId())) {
	        		errors.add("Duplicated Subject Id.");
	        	}
	        }
	        
	        // Check whether it is possible to enroll a new subject.
	        if (r.getAvailGroup() <= 0) {
	        	errors.add("All groups are full.  It is impossible to enroll any new subjects");	        	
	        }
	        
	        if (errors.size() > 0) return "enroll-new-subject.jsp";
	        
	        
	        // Perform randomization
	        r.getRandomGroup(sub);
	        randomizationDAO.writeRandomization(r);
	        
	        return "Perform-Random.do";
			
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return "error.jsp";
        }        
	}
}
