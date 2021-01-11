package com.onsherove.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {

    public static String[] removeStartingIndex(String[] arrOfString, int index) {
        return Arrays.copyOfRange(arrOfString, index + 1, arrOfString.length);
    }

    public static String convertStringArrayToString(String[] arrOfString) {
        return Arrays.toString(arrOfString).replace("[", "").replace("]",
                "");
    }

    public static String convertIntegerArrayToString(int[] arrayList) {
        return Arrays.stream(arrayList).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    public static String convertIntegerListToString(List<Integer> arrayList) {
        return arrayList.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(","));
    }
}
