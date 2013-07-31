/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import java.io.Serializable;
import java.util.ArrayList;

import formbean.Subject;

@SuppressWarnings("serial")
public abstract class Randomization implements Serializable{
	int groupSize;
	ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public abstract int getRandomGroup(Subject sub);
}
