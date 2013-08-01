/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import java.io.Serializable;
import java.util.ArrayList;

import formbean.Subject;

@SuppressWarnings("serial")
public abstract class Randomization implements Serializable {
	int groupSize;
	int blockSize;
	boolean isImbalanceCorrected;
	String typeDesc = "Simple Randomization";
	ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public abstract int getRandomGroup(Subject sub);

	public int getGroupSize() {
		return groupSize;
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
