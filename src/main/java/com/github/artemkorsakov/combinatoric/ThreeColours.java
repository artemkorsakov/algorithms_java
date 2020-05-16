package com.github.artemkorsakov.combinatoric;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

public class ThreeColours {
    private static final Map<Group, Long> RESULT = new HashMap<>();

    public static long getCount(Group group) {
        return getCount(group.min, group.mid, group.max);
    }

    /**
     * We have A white balls, B black balls and C grey balls.
     * How many different options to arrange these balls in a row?
     */
    public static long getCount(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return 0;
        }

        Group group = new Group(a, b, c);
        if (RESULT.containsKey(group)) {
            return RESULT.get(group);
        }

        long count;
        if (group.min == 0 && group.mid == 0) {
            count = 1;
        } else {
            count = getCount(group.min - 1, group.mid, group.max)
                    + getCount(group.min, group.mid - 1, group.max)
                    + getCount(group.min, group.mid, group.max - 1);
        }

        RESULT.put(group, count);
        return RESULT.get(group);
    }

    @ToString
    @EqualsAndHashCode
    @Data
    public static class Group {
        private int min;
        private int mid;
        private int max;

        public Group(int a, int b, int c) {
            min = Math.min(Math.min(a, b), c);
            max = Math.max(Math.max(a, b), c);
            mid = a + b + c - min - max;
        }
    }

}
