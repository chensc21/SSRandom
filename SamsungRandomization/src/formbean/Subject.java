/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package formbean;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class Subject {
	private int id;
	private int group;
	private TreeMap<String, Integer> feature;
	private int strata;
	
	public Subject(HttpServletRequest request) {
		this.id = id;
		this.feature = feature;
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
}
