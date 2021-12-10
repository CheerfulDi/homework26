package pro.sky.java.course2.homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        List<String> words = new ArrayList<String>(List.of("привет", "привет", "друг", "друг", "!"));
        List<String> words2 = new ArrayList<String>(List.of("привет", "привет", "тебе", "мой", "милый", "друг", "!"));

        System.out.println(printOddNums(nums));
        System.out.println(printOddNumsWithoutDoubles(nums));

        removeDoubles(words);
        System.out.println(words);
        System.out.println(calculateDoubles(words2));

    }

    public static boolean isNumOdd(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findOddNums(List<Integer> nums) {
        List<Integer> oddNums = new ArrayList<>();
        int oddNum = 0;
        for (Integer num : nums) {
            if (num % 2 == 0) {
                oddNum = num;
                oddNums.add(oddNum);
            }
        }
        return oddNums;
    }


    public static String printOddNums(List<Integer> nums) {
        if (isNumOdd(nums)) {
            return "Четные номера списка: " + findOddNums(nums);
        }
        return "Четных номеров в списке нет.";
    }

    public static List<Integer> findOddNumsWithoutDoubles(List<Integer> nums) {
        List<Integer> oddNums = new ArrayList<>();
        int oddNum = 0;
        for (Integer num : nums) {
            if (num % 2 == 0) {
                oddNum = num;
                oddNums.add(oddNum);
            }
        }
        removeDoubles(oddNums);
        return oddNums;
    }

    public static String printOddNumsWithoutDoubles(List<Integer> nums) {
        if (isNumOdd(nums)) {

            return "Четные номера списка без повторов: " + findOddNumsWithoutDoubles(nums);
        }
        return "Четных номеров в списке нет.";
    }

    public static <E> void removeDoubles(List<E> items) {
        LinkedHashSet<E> set = new LinkedHashSet<E>(items);
        items.clear();
        items.addAll(set);
    }

    public static int calculateDoubles(List<String> words2) {
        LinkedHashSet<String> distinct = new LinkedHashSet<>();
        LinkedHashSet<String> repetitive = new LinkedHashSet<>();
        for (String s : words2) {
            if (distinct.contains(s)) {
                repetitive.add(s);
            } else {
                distinct.add(s);
            }
        }
        return repetitive.size()*2;
    }
}