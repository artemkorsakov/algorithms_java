package com.github.artemkorsakov.games.monopoly;

import java.util.List;

public class Monopoly {
    private MonopolyField currentField = MonopolyField.GO;
    private int countOfDuplicates = 0;
    private int ccIndex = 0;
    private List<MonopolyCommunityChest> CCList = MonopolyCommunityChest.generateRandom();
    private int chIndex = 0;
    private List<MonopolyChance> CHList = MonopolyChance.generateRandom();

    public MonopolyField getNext(int first, int second) {
        if (second > 0 && first != second) {
            countOfDuplicates = 0;
        } else if (first == second) {
            countOfDuplicates = (countOfDuplicates + 1) % 3;
            if (countOfDuplicates == 0) {
                return getNextG2J();
            }
        }

        int index = (currentField.ordinal() + first + second) % MonopolyField.values().length;
        currentField = MonopolyField.values()[index];
        return currentField.equals(MonopolyField.G2J) ? getNextG2J()
                : currentField.name().startsWith("CC") ? getNextCC()
                : currentField.name().startsWith("CH") ? getNextCH()
                : currentField;
    }

    private MonopolyField getNextG2J() {
        currentField = MonopolyField.JAIL;
        return currentField;
    }

    private MonopolyField getNextCC() {
        MonopolyCommunityChest monopolyCommunityChest = CCList.get(ccIndex);
        ccIndex = (ccIndex + 1) % CCList.size();
        switch (monopolyCommunityChest) {
            case ADVANCE_TO_GO:
                currentField = MonopolyField.GO;
                break;
            case GO_TO_JAIL:
                currentField = MonopolyField.JAIL;
                break;
        }
        return currentField;
    }

    private MonopolyField getNextCH() {
        MonopolyChance monopolyChance = CHList.get(chIndex);
        chIndex = (chIndex + 1) % CHList.size();
        int pos = currentField.ordinal();
        switch (monopolyChance) {
            case ADVANCE_TO_GO:
                currentField = MonopolyField.GO;
                break;
            case GO_TO_JAIL:
                currentField = MonopolyField.JAIL;
                break;
            case GO_TO_C1:
                currentField = MonopolyField.C1;
                break;
            case GO_TO_E3:
                currentField = MonopolyField.E3;
                break;
            case GO_TO_H2:
                currentField = MonopolyField.H2;
                break;
            case GO_TO_R1:
                currentField = MonopolyField.R1;
                break;
            case GO_TO_NEXT_R:
            case GO_TO_NEXT_R2:
                currentField = MonopolyField.R4.ordinal() < pos || pos < MonopolyField.R1.ordinal() ? MonopolyField.R1
                        : pos < MonopolyField.R2.ordinal() ? MonopolyField.R2
                        : pos < MonopolyField.R3.ordinal() ? MonopolyField.R3
                        : MonopolyField.R4;
                break;
            case GO_TO_NEXT_U:
                currentField = pos > MonopolyField.U1.ordinal() && pos < MonopolyField.U2.ordinal()
                        ? MonopolyField.U2 : MonopolyField.U1;
                break;
            case GO_BACK_3_SQUARES:
                currentField = getNext(-3, 0);
                break;
        }
        return currentField;
    }
}
