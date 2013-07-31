/**
 * @author Shoucong Chen
 * Jul 11, 2013
 */

package random;

import formbean.*;

public class PermutedBlockRandomization extends Randomization {
	BlockRandomHelper brHelper;
	
	public PermutedBlockRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
		brHelper = new BlockRandomHelper(groupSize);
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		return brHelper.nextRandomValue();
	}
}
