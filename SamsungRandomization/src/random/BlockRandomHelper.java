package random;
import java.util.ArrayList;

/**
 * @author Shoucong Chen
 * Jul 11, 2013
 */

public class BlockRandomHelper {
	int groupSize;
	int blockSize;
	
	ArrayList<ArrayList<Integer>> blockList;
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
		
		int num = blockList.get(currentBlock).get(currentPosition);
		currentPosition++;
		return num;
	}
	
	public void nextBlock() {
		currentBlock = (int) (Math.random() * blockList.size());
	}
	
	private ArrayList<ArrayList<Integer>> generateBlockList(int groupSize, int blockSize) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[] block = new int[blockSize];
		int[] groupCount = new int[groupSize];
		recursion(list, block, groupCount, 0);
		return list;
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
			if (groupCount[i] + 1 < (block.length / groupCount.length)) {
				block[now] = i;
				groupCount[i]++;
				recursion(list, block, groupCount, now + 1);
				groupCount[i]--;
			}
		}
	}
}
