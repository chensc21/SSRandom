/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package formbean;

import java.io.Serializable;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class Subject implements Serializable {
	private String id;
	private int group;
	private TreeMap<String, String> feature;
	private int strata;
	private String age;
	private String gender;
	private String button;
	
	public Subject() {
		this.id = "1";
		this.strata = 0;
		this.age = "Young";
		this.gender = "Male";
	}
	
	public Subject(HttpServletRequest request) {
		button = request.getParameter("enrollBtn");
		if (button != null) {
			if (request.getParameter("subjectId") != null && request.getParameter("subjectId") != "") {
				this.id = request.getParameter("subjectId");
			} else {
				this.id = "1";
			}
			
			if (request.getParameter("strataId") != null && request.getParameter("strataId") != "") {
				this.strata = Integer.parseInt(request.getParameter("strataId"));
			} else {
				this.strata = 0;
			}
			
			age = request.getParameter("age");
			gender = request.getParameter("gender");
			if (age == null || age.equals("")) age = "Young";
			if (gender == null || gender.equals("")) gender = "Male";
			
			feature = new TreeMap<String, String>();
			feature.put("Age", age);
			feature.put("Gender", gender);
		}
	}
	
	public boolean isPresent() {
		return button != null;
	}

	public String getId() {
		return id;
	}

	public int getGroup() {
		return group;
	}

	public TreeMap<String, String> getFeature() {
		return feature;
	}

	public int getStrata() {
		return strata;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public void setFeature(TreeMap<String, String> feature) {
		this.feature = feature;
	}

	public void setStrata(int strata) {
		this.strata = strata;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
