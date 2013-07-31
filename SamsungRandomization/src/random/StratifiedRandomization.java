/**
 * @author Shoucong Chen
 * Jul 15, 2013
 */

package random;

import formbean.*;

@SuppressWarnings("serial")
public class StratifiedRandomization extends Randomization {
	BlockRandomHelper[] brHelpers;
	boolean isStatisticalIntegrity;
	int[][] strataCount;
	
	public StratifiedRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
		brHelpers = new BlockRandomHelper[form.getStrataSize()];
		for (int i = 0; i < form.getStrataSize(); i++) {
			brHelpers[i] = new BlockRandomHelper(groupSize);
		}
		
		this.isStatisticalIntegrity = form.isStatisticalIntegrity();
		strataCount = new int[form.getStrataSize()][groupSize];
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		int index = sub.getStrata();
		int num = 0;
		
		if (isStatisticalIntegrity) {
			num = brHelpers[index].nextRandomValue();
			strataCount[index][num]++;
		} else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < groupSize; i++) {
				if (strataCount[index][i] < min) min = strataCount[index][i];
			}
			
			num = brHelpers[index].nextRandomValue();
			while (strataCount[index][num] > min) {
				brHelpers[index].nextBlock();
				num = brHelpers[index].nextRandomValue();
			}
		}
		
		return num;
	}
}
