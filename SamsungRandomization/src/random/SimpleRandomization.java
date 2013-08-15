/**
 * @author Shoucong Chen
 * Jul 10, 2013
 */

package random;

import formbean.*;

@SuppressWarnings("serial")
public class SimpleRandomization extends Randomization {
	
	public SimpleRandomization(RandomParameterForm form) {
		super(form);
		this.typeDesc = "Simple Randomization";
	}
	
	@Override
	public int getRandomGroup(Subject sub) {
		if (availGroup <= 0) return -1;
		
//		System.out.println("Avail Group: " + availGroup);
		int num = randomGenerator.nextInt(availGroup);
//		System.out.println("Random number: " + num);
		
		int i = -1, availCount = -1;
		while (i < groupSize - 1 && availCount < num) {
			i++;
			if (groupCount[i] < groupMax[i]) availCount++;
//			System.out.println("i: " + i + " availCount: " + availCount);
		}
		
		sub.setGroup(i);
		groupCount[i]++;
		if (groupCount[i] == groupMax[i]) availGroup--;
		subjectList.add(sub);
		
//		System.out.println();
		return i;
	}
}
