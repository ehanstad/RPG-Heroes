package com.heroes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.heroes.rpgHeroes.classes.Mage;
import com.heroes.rpgHeroes.classes.Ranger;
import com.heroes.rpgHeroes.classes.Rogue;
import com.heroes.rpgHeroes.classes.Warrior;

public class AppTest {
    Mage mage = new Mage("testMage");
    Ranger ranger = new Ranger("testRanger");
    Rogue rogue = new Rogue("testRogue");
    Warrior warrior = new Warrior("testWarrior");

    @Test
    public void creationAndLevelingRangerTest() {
        assertEquals(ranger.getName(), "testRanger");
        assertEquals(ranger.getLevel(), 1);
        assertEquals(ranger.getLevelAttributes().getStrength(), 1);
        assertEquals(ranger.getLevelAttributes().getDexterity(), 7);
        assertEquals(ranger.getLevelAttributes().getIntelligence(), 1);

        ranger.levelUp();
        assertEquals(ranger.getLevel(), 2);
        assertEquals(ranger.getLevelAttributes().getStrength(), 2);
        assertEquals(ranger.getLevelAttributes().getDexterity(), 12);
        assertEquals(ranger.getLevelAttributes().getIntelligence(), 2);
    }
}
