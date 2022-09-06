public class arrayproblems{
    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    public static void trappedWater(int height[]){
        int n=height.length;
        //calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        //calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        //loop
        int trappedWater=0;
        for(int i=0; i<height.length; i++){
            //waterlevel = min(leftmax, rightmax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trappedwater = waterlevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        System.out.println(trappedWater);
        
    }



    // You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on  the ith day.
    // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static void buyandsell(int arr[]){
        int buyprice = arr[0];
        int profit = 0;
        int max = 0;
        for(int i=0; i<arr.length; i++){
            buyprice = Math.min(buyprice, arr[i]);
            if(buyprice<=arr[i]){
                profit = arr[i] - buyprice;
            }
            max = Math.max(max, profit);
        }
        System.out.println(max);
    }

    public static void main(String args[]){
        // int height[] = {4,2,0,6,3,2,5};
        // trappedWater(height);

        int arr[] = {7,1,5,3,6,4};
        buyandsell(arr);
    }
}