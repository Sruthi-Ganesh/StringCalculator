package com.onsherove.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {
    String numbers;
    String delimiter;
    public DelimiterUtils(String numbers) {
        this.numbers = numbers;
    }

    private boolean supportsDifferentDelimiter() {
        return this.numbers.startsWith("//");
    }

    public String getDelimiter() {
        if (this.supportsDifferentDelimiter()) {
            String delimiter = this.numbers.split("\n")[0].replaceAll("//", "");
            StringBuilder delimiters = new StringBuilder();
            if (delimiter.contains("[")) {
                Pattern regex = Pattern.compile("\\[(.*?)\\]");
                Matcher regexMatcher = regex.matcher(delimiter);
                while (regexMatcher.find()) {
                    delimiters.append(regexMatcher.group(1));
                }
            } else {
                delimiters.append(delimiter);
            }
            this.delimiter = "["  + delimiters.toString() + "]+";
            return this.delimiter;
        }
        return null;
    }

    public String getDelimiterRemovedFromString() {
        if (this.supportsDifferentDelimiter()) {
            String[] numbers = this.numbers.split("\n");
            return StringUtils.convertStringArrayToString(StringUtils.removeStartingIndex(numbers, 0));
        }
        return null;
    }
}
