/**
 * @author Shoucong Chen
 * Jul 23, 2013
 */

package formbean;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class RandomParameterForm {
	private int type;
	private int groupSize;
	private int blockSize;
	private boolean isStatisticalIntegrity;
	private TreeMap<String, Integer> feature;
	private String button;
	private int strataSize;

	public RandomParameterForm(HttpServletRequest request) {
		button = request.getParameter("saveBtn" + type);
		if (button != null) {
			type = Integer.parseInt(request.getParameter("randomType"));
			groupSize = Integer.parseInt(request.getParameter("groupSize" + type));
			if (type > 1) blockSize = Integer.parseInt(request.getParameter("blockSize" + type));
		}		
	}
	
	public boolean isPresent() {
		return button != null;
	}

	public int getType() {
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

	public void setType(int type) {
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
}
