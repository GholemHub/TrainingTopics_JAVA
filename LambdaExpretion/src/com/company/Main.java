package com.company;

import java.io.StringReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {


        //getSizeFun();

        //lambdaFun();

        //threadlambdaFun();

        lambdaArgumentsFun();

        //testSumFun();




    }

    private static void getSizeFun() {

        String line = "Hello i am lambda";

        lambdaExpretion lambda = str -> str.length();

        System.out.println("" + lambda.getSize(line));
    }

    @FunctionalInterface
    interface test{
        int Sumowanie(int x, int y);
    }

    private static void testSumFun() {
        test t = (int x, int y) -> x + y;

        System.out.println(t.Sumowanie(13, 34));
    }

    static class Words{
        public String str;
        public String str2;
        public int age;

        public Words(String str, String str2, int age) {
            this.str = str;
            this.str2 = str2;
            this.age = age;
        }
        public String getStr(){
            return str;
        }
    }

    private static void lambdaArgumentsFun() {

        List<Words> list = Arrays.asList(
                new Words("Lera", "Molotowa", 22),
                new Words("Dasha", "Kowalska", 19),
                new Words("Lee", "Moon", 34),
                new Words("George", "Shwilli", 4)
        );
                printThis(list, p -> System.out.println(p.getStr()), p -> p.getStr().startsWith("L"));

    }

    private static void printThis(List<Words> list, Consumer<Words> consumer, Predicate<Words> predicate){
        list.forEach(p -> {
            if(predicate.test(p))
                consumer.accept(p);
        });
    }

    private static void threadlambdaFun() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am the first thread");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = ()-> System.out.println("I am the second thread");
        Thread t2 = new Thread(r2);
        t2.start();

    }

    private static void lambdaFun() {

        List<String> list = new ArrayList<String>();
        list.add("w");
        list.add("d");
        list.add("g");
        list.add("s");
        list.add("h");
        list.add("a");

        list.forEach(biegac -> System.out.println(biegac));

    }
}

interface lambdaExpretion{
    int getSize(String str);
}
