package ru.takiwn.materials;

import java.util.Random;

public enum HammerTier {
    TIER_ONE(1, 8, 65),
    TIER_TWO(4, 8, 15),
    TIER_THREE(5, 10, 10),
    TIER_FOUR(6, 10, 5),
    TIER_FIVE(6, 12, 4),
    END(7, 13, 1);

    private final int minDamage;
    private final int maxDamage;
    private final int chance;

    HammerTier(int minDamage, int maxDamage, int chance) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chance = chance;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getChance() {
        return chance;
    }

    public static HammerTier getRandomTier() {
        int roll = new Random().nextInt(100) + 1;
        int cumulativeChance = 0;

        for (HammerTier tier : values()) {
            cumulativeChance += tier.getChance();
            if (roll <= cumulativeChance) {
                return tier;
            }
        }

        return TIER_ONE; // Если что-то пойдет не так
    }
}