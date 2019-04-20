package com.example.myapplication;

public class MainActivity {

    public static void main(String[] args) {
        int[] A = {1, 1, 6};

//        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
        int number[] = {0, 0, 0, 0, 0, 0};
//        int one_six = 0, two_five = 0, three_four = 0;
        int pair[] = {0, 0, 0};

        for (int i = 0; i < A.length; i++) {
            switch (A[i]) {
                case 1:
                    number[0] += 1;
                    break;
                case 2:
                    number[1] += 1;
                    break;
                case 3:
                    number[2] += 1;
                    break;
                case 4:
                    number[3] += 1;
                    break;
                case 5:
                    number[4] += 1;
                    break;
                case 6:
                    number[5] += 1;
                    break;
            }
        }

        //
        if (number[0] > 0 && number[5] > 0) { // 1과 6이 짝이 있는 경우
            if (number[0] > number[5]) {
                pair[0] = number[5];
            }
            else {
                pair[0] = number[0];
            }
        }
        //
        else if (number[1] > 0 && number[4] > 0) { // 2와 5 짝이 있는 경우
            if (number[1] > number[4]) {
                pair[1] = number[4];
            }
            else {
                pair[1] = number[1];
            }
        }
        //
        else if (number[2] > 0 && number[3] > 0) { // 3과 4 짝이 있는 경우
            if (number[2] > number[3]) {
                pair[2] = number[3];
            }
            else {
                pair[2] = number[2];
            }
        }

        // 짝이 하나도 안맞는 경우


        // 비교
        int max_pair = pair[0];
        int max_pair_index = -1;
        for (int i = 0; i < pair.length; i++) {

            if (pair[i] > max_pair) {
                max_pair = pair[i];
            }
            else {
                max_pair_index = i;
            }
        }

//        System.out.println("max_index " + max_index);
        System.out.println("one = " + number[0] + ", two = " + number[1] + ", three = " + number[2] + ", four = " + number[3] + ", five = " + number[4] + ", six = " + number[5]);

        int count = 0;
        int max_number_index = -1;
        // jj는 기준값,,,

        if (max_pair_index == 0) {
            if (number[0] > number[5]) {
//                count += number[5] * 2;
                max_number_index = 0;
            }
            else {
//                count += number[0] * 2;
                max_number_index = 5;
            }
        }
        else if (max_pair_index == 1) {
            if (number[1] > number[4]) {
//                count += number[4] * 2;
                max_number_index = 1;
            }
            else {
//                count += number[1] * 2;
                max_number_index = 4;
            }
        }
        else if (max_pair_index == 2) {
            if (number[2] > number[3]) {
//                count += number[3] * 2;
                max_number_index = 2;
            }
            else {
//                count += number[2] * 2;
                max_number_index = 3;
            }
        }

        System.out.println(max_number_index);

        for (int i = 0; i < number.length; i++) {
            if (i == 5 - max_number_index) {
                count += number[i] * 2;
            }
            else if (i != max_number_index){
                count += number[i];
            }
        }


        System.out.println(count);
    }
}
