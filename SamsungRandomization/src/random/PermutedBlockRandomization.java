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
		super(form);
		
		this.blockSize = form.getBlockSize();
		this.typeDesc = "Permuted Block Randomization";
		brHelper = new BlockRandomHelper(groupSize, blockSize);
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		if (availGroup <= 0) return -1;
		
		int num = brHelper.nextRandomValue();
		while (groupCount[num] == groupMax[num]) {
			num = brHelper.nextRandomValue();
		}
		
		sub.setGroup(num);
		groupCount[num]++;
		if (groupCount[num] == groupMax[num]) availGroup--;
		subjectList.add(sub);
		
		return num;
	}
}
