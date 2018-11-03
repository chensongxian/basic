package com.csx.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-09-20
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {89,34,270,17};

        for(int x=0;x<arr.length;x+=1){
            System.out.println("arr["+x+"] = "+arr[x]+";");
        }

        int max = getMax(arr);
        System.out.println(max);

        int maxByIndex = getMaxByIndex(arr);
        System.out.println(maxByIndex);
    }

    public static int getMax(int[] arr){
        int maxElement = arr[0];
        for(int x = 1;x < arr.length;x++){
            if(arr[x] > maxElement) {
                maxElement = arr[x];
            }
        }
        return maxElement;
    }

    public static int getMaxByIndex(int[] arr){
        int maxIndex = 0 ;
        for(int x = 1;x < arr.length;x++) {
            if(arr[x] > arr[maxIndex]){
                maxIndex = x;
            }
        }
        return arr[maxIndex];
    }
}
