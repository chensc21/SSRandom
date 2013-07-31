/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import java.util.ArrayList;

import formbean.Subject;

public abstract class Randomization {
	int groupSize;
	ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public abstract int getRandomGroup(Subject sub);
}
