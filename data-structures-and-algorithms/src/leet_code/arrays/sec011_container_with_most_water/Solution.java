package leet_code.arrays.sec011_container_with_most_water;

class Solution {

    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n - 2 ; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int area = (j - i) *  (Math.min(j, i));
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heigh = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println("Result: " + maxArea(heigh));;
    }
}
