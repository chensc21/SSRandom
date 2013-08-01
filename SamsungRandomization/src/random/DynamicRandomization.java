/**
 * @author Shoucong Chen
 * Jul 17, 2013
 */

package random;

import formbean.*;

@SuppressWarnings("serial")
public class DynamicRandomization extends Randomization {
	
	public DynamicRandomization(RandomParameterForm form) {
		this.typeDesc = "Dynamic Randomization";
	}

	@Override
	public int getRandomGroup(Subject sub) {
		return 0;
	}

}
