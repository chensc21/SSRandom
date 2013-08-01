/**
 * @author Shoucong Chen
 * Jul 11, 2013
 */

package random;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BlockRandomHelper implements Serializable {
	int groupSize;
	int blockSize;
	
	int[][] blockList;
	int currentBlock;
	int currentPosition;
	
	public BlockRandomHelper(int groupSize) {
		this.groupSize = groupSize;
		
		int num = (int) (Math.random() * 4);
		num += 3;
		num *= groupSize;
		this.blockSize = num;
		
		this.blockList = generateBlockList(groupSize, blockSize);
		this.currentPosition = 0;
	}
	
	public BlockRandomHelper(int groupSize, int blockSize) {
		this.groupSize = groupSize;
		this.blockSize = blockSize;
		
		this.blockList = generateBlockList(groupSize, blockSize);
		this.currentPosition = 0;
	}
	
	public int nextRandomValue() {
		if (currentPosition == blockSize) {
			nextBlock();
			currentPosition = 0;
		}
		
		System.out.println(blockList.length);
		int num = blockList[currentBlock][currentPosition];
		currentPosition++;
		return num;
	}
	
	public void nextBlock() {
		currentBlock = (int) (Math.random() * blockList.length);
	}
	
	private int[][] generateBlockList(int groupSize, int blockSize) {		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[] block = new int[blockSize];
		int[] groupCount = new int[groupSize];
		recursion(list, block, groupCount, 0);
		
		int[][] ans = new int[list.size()][list.get(0).size()];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				ans[i][j] = list.get(i).get(j);
			}
		}
		
		return ans;
	}
	
	private void recursion(ArrayList<ArrayList<Integer>> list, int[] block, int[] groupCount, int now) {
		if (now == block.length) {
			ArrayList<Integer> tBlock = new ArrayList<Integer>();
			for (int num : block) {
				tBlock.add(num);
			}
			list.add(tBlock);
			return;
		}
		
		for (int i = 0; i < groupCount.length; i++) {
			if (groupCount[i] < (block.length / groupCount.length)) {
				block[now] = i;
				groupCount[i]++;
				recursion(list, block, groupCount, now + 1);
				groupCount[i]--;
			}
		}
	}
}
