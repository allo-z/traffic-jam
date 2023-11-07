package com.zuehlke.hamilton;

import java.util.ArrayList;

class CharUtil {
    public static ArrayList<Character> toCharList(String value) {
        return new ArrayList<>(value.chars().mapToObj(c -> (char) c).toList());
    }
}
