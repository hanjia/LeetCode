package org.hanjia.leetcode.array;


/**
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * @author hanjia
 *
 */
public class Problem11_ContainerWithMostWater {
	public int maxArea(int[] height) {
        int maxVolume = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            if(height[i] > height[j]){
                int volume = height[j] * (j - i);
                if(volume > maxVolume) maxVolume = volume;
                j--;
            }else{
                int volume = height[i] * (j - i);
                if(volume > maxVolume) maxVolume = volume;
                i++;
            }
        }    
        
        return maxVolume;
    }
}
