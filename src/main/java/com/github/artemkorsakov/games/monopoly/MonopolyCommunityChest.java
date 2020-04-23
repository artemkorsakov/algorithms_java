package com.github.artemkorsakov.games.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MonopolyCommunityChest {
    ADVANCE_TO_GO,
    GO_TO_JAIL,
    N1,
    N2,
    N3,
    N4,
    N5,
    N6,
    N7,
    N8,
    N9,
    N10,
    N11,
    N12,
    N13,
    N14;

    public static List<MonopolyCommunityChest> generateRandom() {
        List<MonopolyCommunityChest> list = new ArrayList<>();
        list.addAll(Arrays.asList(MonopolyCommunityChest.values()));
        Collections.shuffle(list);
        return list;
    }
}
