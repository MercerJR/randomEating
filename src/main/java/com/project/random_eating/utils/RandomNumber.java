package com.project.random_eating.utils;

import java.util.Random;

/**
 * @Author MercerJR
 * @Data 2020/2/11 15:59
 */
public class RandomNumber {
    public Integer myRandom(Integer total){
        Random random = new Random();
        return random.nextInt(total) + 1;
    }

    public static void main(String[] args) {

    }
}
