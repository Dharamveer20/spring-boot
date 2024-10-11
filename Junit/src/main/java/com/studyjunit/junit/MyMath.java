package com.studyjunit.junit;

public class MyMath {
    public int calcSum(int [] nums){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
}
