/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.georgiasouthern.csci2410.csci2410datastructuresalgorithms;

/**
 *
 * @author EddyJ
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] assets = {1, 5, 10, 20, 50, 100};
        int[] rValsA = new int[100];
        int[] rValsB = new int[100];
        int W = 50;
        for (int i = 0; i < 100; i++) {
            rValsA[i] = (int) Math.random() * 1000;
        }
        for (int i = 0; i < 100; i++) {
            rValsB[i] = (int) Math.random() * 100000;
        }
//PARTITION first initial set
        int[] firstHalfA = new int[rValsA.length / 2];
        int[] secondHalfA = new int[rValsA.length / 2];
        System.arraycopy(rValsA, 0, firstHalfA, 0, rValsA.length / 2);
        System.arraycopy(rValsA, 50, secondHalfA, 0, 50);
        long startTime = System.nanoTime();
        System.out.print("The difference between the the "
                + "set partitions from the first initial set of assets is: "
                + Math.abs(knapSack(W, assets, firstHalfA, firstHalfA.length) - knapSack(W, assets, secondHalfA,
                        secondHalfA.length)));
        long endTime = System.nanoTime();
        System.out.print("It took " + (endTime - startTime) + " nanoseconds");
//PARTITION second initial set
        int[] firstHalfB = new int[50];
        int[] secondHalfB = new int[50];
        System.arraycopy(rValsB, 0, firstHalfB, 0, 50);
        System.arraycopy(rValsB, 50, secondHalfB, 0, 50);
        long startTimeB = System.nanoTime();
        System.out.print("The difference between the the "
                + "set partitions from the first initial set of assets is: "
                + Math.abs(knapSack(W, assets, firstHalfB, firstHalfB.length) - knapSack(W, assets, secondHalfB,
                        secondHalfA.length)));
        long endTimeB = System.nanoTime();
        System.out.print("It took " + (endTimeB - startTimeB) + " nanoseconds");
    }

    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
