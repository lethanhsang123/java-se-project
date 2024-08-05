package leet_code.arrays.sec011_container_with_most_water;

class Solution {

    public static int maxArea(int[] height) {
        int head = 0, tail = height.length - 1, maxArea = 0;
        while ( head < tail ) {
            int min = Math.min(height[head], height[tail]) ;
            maxArea = Math.max (maxArea, (tail - head) * min);
            while(head < tail && height[head] <= min) head++;
            while( head < tail && height[tail]<=min) tail--;
        }
        System.gc();
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heigh = new int[] {1,8,6,2,5,4,8,3,7};
        long current = System.currentTimeMillis();
        int maxArea = maxArea(heigh);
        long time = System.currentTimeMillis() - current;
        System.out.println("Result: " + maxArea + " ; Time: " + time);;
    }
}
