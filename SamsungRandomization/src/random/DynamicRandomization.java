/**
 * @author Shoucong Chen
 * Jul 17, 2013
 */

package random;

import formbean.*;

import java.util.ArrayList;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class DynamicRandomization extends Randomization {
	String[] featureList;
	ArrayList<TreeMap<String, Integer>> featureCount;
	
	public DynamicRandomization(RandomParameterForm form) {
		this.groupSize = form.getGroupSize();
		this.typeDesc = "Dynamic Randomization";
		this.featureList = form.getFeatureList();
		
		featureCount = new ArrayList<TreeMap<String, Integer>>();
		for (int i = 0; i < groupSize; i++) {
			TreeMap<String, Integer> count = new TreeMap<String, Integer>();
			featureCount.add(count);
		}
	}

	@Override
	public int getRandomGroup(Subject sub) {
		int sumA = 0, sumB = 0;
		for (int i = 0; i < featureList.length; i++) {
			int t1 = featureCount.get(0).containsKey(sub.getFeature().get(featureList[i])) ? featureCount.get(0).get(sub.getFeature().get(featureList[i])) : 0;
			int t2 = featureCount.get(1).containsKey(sub.getFeature().get(featureList[i])) ? featureCount.get(1).get(sub.getFeature().get(featureList[i])) : 0;
			sumA += Math.abs(t1 + 1 - t2);
			sumB += Math.abs(t2 + 1 - t1);
		}
		
		int num;
		if (sumA > sumB) {
			num = 1;
		} else if (sumB > sumA) {
			num = 0;
		} else {
			if (Math.random() < 0.5) num = 0;
			else num = 1;
		}
		
		for (int i = 0; i < featureList.length; i++) {
			if (featureCount.get(num).containsKey(sub.getFeature().get(featureList[i]))) {
				featureCount.get(num).put(sub.getFeature().get(featureList[i]), featureCount.get(num).get(sub.getFeature().get(featureList[i])) + 1);
			} else {
				featureCount.get(num).put(sub.getFeature().get(featureList[i]), 1);
			}
		}
		
		sub.setGroup(num);
		subjectList.add(sub);
		return num;
	}

}
