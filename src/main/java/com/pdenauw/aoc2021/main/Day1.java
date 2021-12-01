package com.pdenauw.aoc2021.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class Day1 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("src/main/java/com/pdenauw/aoc2021/main/day1.json")) {
            Object obj = parser.parse(reader);

            JSONArray values = (JSONArray) ((JSONObject) obj).get("values");
            int cmp_incr = 0;
            Iterator<Long> ite = values.iterator();
            Long previous = ite.next();
            while(ite.hasNext()) {
                long value = ite.next();
                if (value> previous) {
                    cmp_incr = cmp_incr + 1;
                }
                previous = value;
            }
            System.out.println("Compteur final : " + cmp_incr);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void part2() {
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("src/main/java/com/pdenauw/aoc2021/main/day1.json")) {
            Object obj = parser.parse(reader);

            JSONArray values = (JSONArray) ((JSONObject) obj).get("values");
            int cmp_incr = 0;
            Iterator<Long> ite = values.iterator();
            long sum1 = 0;
            long sum2 = 0;
            long sum3 = 0;

            Long previous = ite.next();
            sum1 += previous;
            previous = ite.next();
            sum1 += previous;
            sum2 += previous;
            previous = ite.next();
            sum1 += previous;
            sum2 += previous;
            sum3 += previous;

            while(ite.hasNext()) {
                long value = ite.next();
                sum2 += value;
                sum3 += value;
                if (sum2 > sum1) {
                    cmp_incr = cmp_incr + 1;
                }
                sum1 = sum2;
                sum2 = sum3;
                sum3 = value;
            }
            System.out.println("Compteur final : " + cmp_incr);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
