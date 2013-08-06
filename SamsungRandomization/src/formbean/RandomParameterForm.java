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
	private boolean isImbalanceCorrected = false;
	private String imbalanceDesc = "No";
	private TreeMap<String, Integer> feature;
	private int strataSize = 6;
	private String typeDesc = "Simple Randomization";
	private String[] featureList = {"Age", "Gender"};
	
	public RandomParameterForm(Randomization r) {
		this.groupSize = r.getGroupSize();
		this.blockSize = r.getBlockSize();
		this.isImbalanceCorrected = r.isImbalanceCorrected();
		this.typeDesc = r.getTypeDesc();
		this.imbalanceDesc = isImbalanceCorrected ? "Yes" : "No";
	}
	
	public RandomParameterForm(HttpServletRequest request) {
		type = request.getParameter("randomType");
		if (type != null) {
			groupSize = Integer.parseInt(request.getParameter("groupSize-" + type));
			if (type.equals("option2") || type.equals("option3")) blockSize = Integer.parseInt(request.getParameter("blockSize-" + type));
			if (type.equals("option3")) {
				isImbalanceCorrected = request.getParameter("optionsRadios") == "option1";
				imbalanceDesc = isImbalanceCorrected ? "Yes" : "No";
			}
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

	public boolean isImbalanceCorrected() {
		return isImbalanceCorrected;
	}

	public String getImbalanceDesc() {
		return imbalanceDesc;
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

	public String[] getFeatureList() {
		return featureList;
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

	public void setImbalanceCorrected(boolean isImbalanceCorrected) {
		this.isImbalanceCorrected = isImbalanceCorrected;
	}

	public void setImbalanceDesc(String imbalanceDesc) {
		this.imbalanceDesc = imbalanceDesc;
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

	public void setFeatureList(String[] featureList) {
		this.featureList = featureList;
	}
}
