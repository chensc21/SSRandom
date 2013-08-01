/**
 * @author Shoucong Chen
 * Jul 23, 2013
 */

package formbean;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import random.Randomization;

public class RandomParameterForm {
	private String type;
	private int groupSize = 2;
	private int blockSize = 6;
	private boolean isStatisticalIntegrity = true;
	private TreeMap<String, Integer> feature;
//	private String button;
	private int strataSize = 4;
	private String typeDesc = "Simple Randomization";
	
	public RandomParameterForm(Randomization r) {
		this.groupSize = r.getGroupSize();
		this.blockSize = r.getBlockSize();
		this.isStatisticalIntegrity = r.isStatisticalIntegrity();
		this.typeDesc = r.getTypeDesc();
	}
	public RandomParameterForm(HttpServletRequest request) {
		type = request.getParameter("randomType");
//		button = request.getParameter("saveBtn-" + type);
		if (type != null) {
			groupSize = Integer.parseInt(request.getParameter("groupSize-" + type));
			if (!type.equals("option1")) blockSize = Integer.parseInt(request.getParameter("blockSize-" + type));
		}		
	}
	
	public boolean isPresent() {
		return type != null;
	}
	public String getType() {
		return type;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public boolean isStatisticalIntegrity() {
		return isStatisticalIntegrity;
	}
	public TreeMap<String, Integer> getFeature() {
		return feature;
	}
	public int getStrataSize() {
		return strataSize;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public void setStatisticalIntegrity(boolean isStatisticalIntegrity) {
		this.isStatisticalIntegrity = isStatisticalIntegrity;
	}
	public void setFeature(TreeMap<String, Integer> feature) {
		this.feature = feature;
	}
	public void setStrataSize(int strataSize) {
		this.strataSize = strataSize;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
}
