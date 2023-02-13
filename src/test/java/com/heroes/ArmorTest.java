package com.heroes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.heroes.items.Armor;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.rpgHeroes.HeroAttribute;

public class ArmorTest {
  HeroAttribute armorAttribute = new HeroAttribute(0, 0, 4);
  Armor helmet = new Armor("testHelmet", 4, ArmorType.Cloth, armorAttribute, Slot.Head);

  @Test
  public void armorCreationShouldInitCorrectName() {
    // Arrange
    String expected = "testHelmet";
    // Act
    String actual = helmet.getName();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void armorCreationShouldInitCorrectRequiredLevel() {
    // Arrange
    int expected = 4;
    // Act
    int actual = helmet.getRequiredLevel();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void armorCreationShouldInitCorrectSlot() {
    // Arrange
    Slot expected = Slot.Head;
    // Act
    Slot actual = helmet.getSlot();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void armorCreationShouldInitCorrectType() {
    // Arrange
    ArmorType expected = ArmorType.Cloth;
    // Act
    ArmorType actual = (ArmorType) helmet.getType();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void armorCreationShouldInitCorrectAttributes() {
    // Arrange
    HeroAttribute expected = armorAttribute;
    // Act
    HeroAttribute actual = (HeroAttribute) helmet.getHeroAttribute();
    // Assert
    assertEquals(expected, actual);
  }
}
