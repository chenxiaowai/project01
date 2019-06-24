package com.itheima.controller;



public class gdf  {

    public static void main(String[] args) {
        final long l1 = System.currentTimeMillis();
        int j =0;
        for (long i = 0; i < 2000000000; i++) {
            j+=i;
        }
        System.out.println(j);
        final long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }

    public static void git(){
        System.out.println("asaaa");
    }

}
