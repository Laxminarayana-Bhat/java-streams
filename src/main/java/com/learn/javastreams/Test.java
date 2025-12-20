package com.learn.javastreams;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] input = new int[]{100, 4, 500, 1, 20, 3, 2};
        int n = input.length;
        Set<Integer> set = new HashSet<>();
        int[] sorted = new int[n];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(input[j+1]<input[j]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }


        Arrays.sort(input);

        int max = 0;

        int l = 0;

        for (int r = 0; r < n - 1; r++) {

            int cur = input[r];

            int next = cur + 1;

            if(input[r + 1] != next) {

                max = Math.max(max, r - l + 1);

                l = r + 1;

            }

        }
        System.out.println(max);

        // 2600 ,
        //1000 rupees –10
        //
        //500 rupees -5
        //
        //100 rupees –10
        //
        //Amount – 2600
        //
        //2+1+1=4; 2+6=8
//        [1000,500,100]
//        [1000:10, 500:5, 100: 10];

        List<Integer> list=new ArrayList<>(List.of(1000,100,500));
        Collections.sort(list, Collections.reverseOrder());
        Map<Integer,Integer> amountCountMap=new HashMap<>(Map.of(1000,10,500,5,100,10));

        int inputAmt=2600;
        int minNotes=0;
        for(Integer amt:list){
            //1000 <= 2600
            while (amt<=inputAmt){
                if (amountCountMap.containsKey(amt)){
                    amountCountMap.compute(amt, (k, a) -> a - 1);
                    inputAmt-=amt;
                    minNotes++;
                }
                //1600
            }
        }
        System.out.println(minNotes);




    }
}
