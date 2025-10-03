package pradeepshah.SpringProject.demo.DSA.DP1;

import java.util.*;
public class knapsack {
    // top down
    static int helper(int[]wt, int[]val, int index, int W, int[][] dp){
        if(index == 0){
            if(wt[0] <= W){
                return val[0];
            }
            return 0;
        }
        if(dp[index][W]!=-1){
            return dp[index][W];
        }
        int notTake = helper(wt, val, index-1,W, dp);
        int take = Integer.MIN_VALUE;
        if(wt[index] <= W){
            take = val[index] + helper(wt,val, index-1,W - wt[index], dp);
        }
        dp[index][W] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    // bottom up
    static int bottomUpDp(int[]wt, int[] val, int W, int n){
        int[]dp = new int[W + 1];
        Arrays.fill(dp,0);


        // if array has one element
        for(int i = wt[0]; i <= W; i++){
            dp[i] = val[0];
        }

        for(int i=1;i<n;i++){
            for(int cap = W; cap >= 0; cap--){
                // not take
                int notTake = dp[cap];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= cap){
                    take = val[i] + dp[cap-wt[i]];
                }
                dp[cap] = Math.max(notTake, take);
            }
        }
        return dp[W];
    }

    static int solution(int[]wt, int[] val, int W){
        int n = wt.length;
        // memoization
        // int[][] dp = new int[n][W + 1];
        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }
        // return helper(wt, val, n - 1 , W, dp);
        return bottomUpDp(wt, val, W, n);

    }

    public static void main(String[] args) {

        int[] wt = {2,3,5,6};
        int[] val = {5,6,7,8};

        System.out.println("maximum value: " + solution(wt, val, 10));
    }
}
