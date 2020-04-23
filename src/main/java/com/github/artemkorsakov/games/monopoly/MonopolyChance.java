package com.github.artemkorsakov.games.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MonopolyChance {
    ADVANCE_TO_GO,
    GO_TO_JAIL,
    GO_TO_C1,
    GO_TO_E3,
    GO_TO_H2,
    GO_TO_R1,
    GO_TO_NEXT_R,
    GO_TO_NEXT_R2,
    GO_TO_NEXT_U,
    GO_BACK_3_SQUARES,
    N1,
    N2,
    N3,
    N4,
    N5,
    N6;

    public static List<MonopolyChance> generateRandom() {
        List<MonopolyChance> list = new ArrayList<>();
        list.addAll(Arrays.asList(MonopolyChance.values()));
        Collections.shuffle(list);
        return list;
    }
}
