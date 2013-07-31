/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import formbean.*;

public class SimpleRandomization extends Randomization {
	public SimpleRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		int num = (int) (Math.random() * groupSize);
		return num;
	}
}
