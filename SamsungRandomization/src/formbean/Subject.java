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
	private int id;
	private int group;
	private TreeMap<String, Integer> feature;
	private int strata;
	private String age;
	private String gender;
	private String button;
	
	public Subject(HttpServletRequest request) {
		button = request.getParameter("enrollBtn");
		if (button != null) {
			if (request.getParameter("subjectId") != null) {
				this.id = Integer.parseInt(request.getParameter("subjectId"));
			} else {
				this.id = 1;
			}
			
			if (request.getParameter("strataId") != null) {
				this.strata = Integer.parseInt(request.getParameter("strataId"));
			} else {
				this.strata = 0;
			}
			
			this.age = request.getParameter("age");
			this.gender = request.getParameter("gender");
			if (this.age == null) this.age = "Young";
			if (this.gender == null) this.gender = "Male";
		}
	}
	
	public boolean isPresent() {
		return button != null;
	}

	public int getId() {
		return id;
	}

	public int getGroup() {
		return group;
	}

	public TreeMap<String, Integer> getFeature() {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public void setFeature(TreeMap<String, Integer> feature) {
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
