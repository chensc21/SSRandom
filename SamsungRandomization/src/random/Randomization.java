/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import formbean.RandomParameterForm;
import formbean.Subject;

@SuppressWarnings("serial")
public abstract class Randomization implements Serializable {
	Random randomGenerator;
	
	int groupSize;
	int availGroup;
	int[] groupMax;
	int[] groupCount;
	
	int blockSize;
	boolean isImbalanceCorrected;
	String typeDesc = "Simple Randomization";
	ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public abstract int getRandomGroup(Subject sub);
	
	public Randomization(RandomParameterForm form) {
		this.randomGenerator = new Random(System.currentTimeMillis());
		
		this.groupSize = form.getGroupSize();
		this.availGroup = form.getAvailGroup();
		this.groupMax = form.getGroupMax();
		this.groupCount = form.getGroupCount();
	}

	public int getGroupSize() {
		return groupSize;
	}

	public int getAvailGroup() {
		return availGroup;
	}

	public int[] getGroupMax() {
		return groupMax;
	}

	public int[] getGroupCount() {
		return groupCount;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public boolean isImbalanceCorrected() {
		return isImbalanceCorrected;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
}
