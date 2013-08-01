/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import formbean.*;

@SuppressWarnings("serial")
public class SimpleRandomization extends Randomization {
	public SimpleRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
		this.typeDesc = "Simple Randomization";
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		int num = (int) (Math.random() * groupSize);
		sub.setGroup(num);
		subjectList.add(sub);
		return num;
	}
}
