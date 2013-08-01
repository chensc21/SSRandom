/**
 * @author Shoucong Chen
 * Jul 11, 2013
 */

package random;

import formbean.*;

@SuppressWarnings("serial")
public class PermutedBlockRandomization extends Randomization {
	BlockRandomHelper brHelper;
	
	public PermutedBlockRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
		this.blockSize = form.getBlockSize();
		this.typeDesc = "Permuted Block Randomization";
		brHelper = new BlockRandomHelper(groupSize, blockSize);
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		int num = brHelper.nextRandomValue();
		sub.setGroup(num);
		subjectList.add(sub);
		return num;
	}
}
