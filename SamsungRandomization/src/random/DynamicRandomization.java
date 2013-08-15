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
	ArrayList<TreeMap<String, Integer>> featureCount; // Count each feature in each group
	
	public DynamicRandomization(RandomParameterForm form) {
		super(form);
		
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
		if (availGroup <= 0) return -1;
		
		int i, j;
		
		// Count sum of specific features
		int[] sum = new int[groupSize];
		for (i = 0; i < featureList.length; i++) { // Loop in feature names, like Age, Gender...
			String currentFeature = sub.getFeature().get(featureList[i]);
			for (j = 0; j < sum.length; j++) { // Loop in groups
				if (featureCount.get(j).containsKey(currentFeature)) sum[j] += featureCount.get(j).get(currentFeature);
			}
		}
		
		// Exclude groups that are full already
		for (i = 0; i < sum.length; i++) {
			if (groupCount[i] == groupMax[i]) sum[i] = Integer.MAX_VALUE;
		}
		
		// Get the list of minimum sum index
		ArrayList<Integer> minList = new ArrayList<Integer>();
		minList.add(0);
		for (i = 1; i < sum.length; i++) {
			if (sum[i] < sum[minList.get(0)]) {
				minList = new ArrayList<Integer>();
				minList.add(i);
			} else if (sum[i] == sum[minList.get(0)]) {
				minList.add(i);
			}
		}
		
		// Choose one index randomly from the minimum list
		int minIdx = minList.get(randomGenerator.nextInt(minList.size()));
		
		// Add feature count
		for (i = 0; i < featureList.length; i++) {
			String currentFeature = sub.getFeature().get(featureList[i]);
			if (featureCount.get(minIdx).containsKey(currentFeature)) {
				featureCount.get(minIdx).put(currentFeature, featureCount.get(minIdx).get(currentFeature) + 1);
			} else {
				featureCount.get(minIdx).put(currentFeature, 1);
			}
		}
		
		// Assign group.
		sub.setGroup(minIdx);
		groupCount[minIdx]++;
		if (groupCount[minIdx] == groupMax[minIdx]) availGroup--;
		subjectList.add(sub);
		
		return minIdx;
	}

}
