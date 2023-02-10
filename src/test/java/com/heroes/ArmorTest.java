package com.heroes;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.heroes.items.Armor;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.rpgHeroes.HeroAttribute;

public class ArmorTest {
  HeroAttribute armorAttribute = new HeroAttribute(0, 0, 4);
  Armor helmet = new Armor("testHelmet", 4, ArmorType.Cloth, armorAttribute, Slot.Head);

  @Test
  public void armorCreationShouldInitCorrectName() {
    assertEquals(helmet.getName(), "testHelmet");
  }

  @Test
  public void armorCreationShouldInitCorrectRequiredLevel() {
    assertEquals(helmet.getRequiredLevel(), 4);
  }

  @Test
  public void armorCreationShouldInitCorrectSlot() {
    assertEquals(helmet.getSlot(), Slot.Head);
  }

  @Test
  public void armorCreationShouldInitCorrectType() {
    assertEquals(helmet.getType(), ArmorType.Cloth);
  }

  @Test
  public void armorCreationShouldInitCorrectAttributes() {
    assertEquals(helmet.getHeroAttribute(), armorAttribute);
  }
}
