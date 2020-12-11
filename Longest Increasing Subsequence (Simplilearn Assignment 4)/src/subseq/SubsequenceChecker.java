package subseq;

import java.util.LinkedList;

public class SubsequenceChecker 
{
	public static void main(String[] args) 
	{
		int[] targetSet = {22, 95, 8, 86, 29, 74, 36, 63, 81, 11, 24, 90, 16, 55, 77, 25, 42, 65, 72, 18, 38, 45, 69, 94, 37, 31, 54, 48, 93, 32, 43, 56, 21, 15, 97, 50, 9, 60, 23, 70, 67, 84, 49, 98, 78, 66, 88, 35, 17, 85, 58, 75, 34, 10, 82, 33, 62, 4, 27, 61, 64, 13, 19, 79, 28, 47, 99, 51, 57, 53, 59, 44, 52, 80, 12, 30, 40, 26, 5, 20, 2, 1, 41, 6, 73, 91, 46, 7, 96, 87, 100, 89, 76, 71, 68, 14, 83, 3, 92, 39};
		LinkedList<int[]> largestSequences = new LinkedList<int[]>();
		int[] workArray = new int[targetSet.length];
		int current = 0;
		int longest = 0;
		int prevNum = 0;
		int numSequences = 0;
		
		for (int i = 0; i < targetSet.length; i++)
		{
			for (int j = i; j < targetSet.length; j++)
			{
				if (targetSet[j] > prevNum)
				{
					workArray[current] = targetSet[j];
					current++;
					prevNum = targetSet[j];
				}
			}
			
			if (current == longest)
			{
				largestSequences.add(java.util.Arrays.copyOfRange(workArray, 0, current));
				numSequences++;
			}
			else if (current > longest)
			{
				longest = current;
				largestSequences.clear();
				largestSequences.add(java.util.Arrays.copyOfRange(workArray, 0, current));
				numSequences = 1;
			}
			
			prevNum = 0;
			current = 0;
		}
		
		System.out.println("The following are the longest subsequences from this given set:");
		System.out.println(java.util.Arrays.toString(targetSet));
		for (int i = 0; i < numSequences; i++)
		{
			System.out.println((i + 1) + ": " + java.util.Arrays.toString(largestSequences.pop()));
		}
	}
}
