package com.heroes.rpgHeroes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.heroes.exceptions.InvalidArmorException;
import com.heroes.exceptions.InvalidWeaponException;
import com.heroes.items.Armor;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.classes.Mage;

public class MageTest {

  Mage test;

  Weapon validWeapon;
  Weapon inValidWeaponType;
  Weapon inValidWeaponLevel;
  Weapon newValidWeapon;

  Armor validArmor;
  Armor invalidArmorType;
  Armor inValidArmorLevel;
  Armor firstArmor;
  Armor secondArmor;
  Armor thirdArmor;
  Armor sameSlotAsFirstArmor;
  Armor bigDamageImpactArmor;

  @Before
  public void setup() {
    test = new Mage("test");

    validWeapon = new Weapon("testWand", 1, WeaponType.Wand, 3);
    inValidWeaponType = new Weapon("testBow", 1, WeaponType.Bow, 2);
    inValidWeaponLevel = new Weapon("testWand", 2, WeaponType.Wand, 3);
    newValidWeapon = new Weapon("newWand", 1, WeaponType.Wand, 4);

    validArmor = new Armor("leather", 1, ArmorType.Cloth, new HeroAttribute(2, 0, 0), Slot.Body);
    inValidArmorLevel = new Armor("leather", 2, ArmorType.Cloth, new HeroAttribute(2, 0, 0), Slot.Body);
    invalidArmorType = new Armor("cloth", 1, ArmorType.Leather, new HeroAttribute(2, 0, 0), Slot.Body);

    firstArmor = new Armor("head", 1, ArmorType.Cloth, new HeroAttribute(1, 1, 1), Slot.Head);
    secondArmor = new Armor("body", 1, ArmorType.Cloth, new HeroAttribute(1, 1, 1), Slot.Body);
    thirdArmor = new Armor("legs", 1, ArmorType.Cloth, new HeroAttribute(1, 1, 1), Slot.Legs);
    sameSlotAsFirstArmor = new Armor("head", 1, ArmorType.Cloth, new HeroAttribute(2, 2, 2), Slot.Head);

    bigDamageImpactArmor = new Armor("bigDamageImpactArmor", 1, ArmorType.Cloth, new HeroAttribute(0, 0, 100),
        Slot.Body);
  }

  @Test
  public void mageGetName() {
    // Arrange
    String expected = "test";
    // Act
    String actual = test.getName();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageGetLevel_shouldInitAs1() {
    // Arrange
    int expected = 1;
    // Act
    int actual = test.getLevel();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageStrength_ShouldBeInitAs1() {
    // Arrange
    int expected = 1;
    // Act
    int actual = test.getLevelAttributes().getStrength();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageDexterity_ShouldBeInitAs1() {
    // Arrange
    int expected = 1;
    // Act
    int actual = test.getLevelAttributes().getDexterity();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageIntelligence_ShouldBeInitAs8() {
    // Arrange
    int expected = 8;
    // Act
    int actual = test.getLevelAttributes().getIntelligence();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageLevel_LevelUp_ShouldBe2() {
    // Arrange
    test.levelUp();
    int expected = 2;
    // Act
    int actual = test.getLevel();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageStrength_LevelUp_ShouldBe2() {
    // Arrange
    test.levelUp();
    int expected = 2;
    // Act
    int actual = test.getLevelAttributes().getStrength();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageDexterity_LevelUp_ShouldBe2() {
    // Arrange
    test.levelUp();
    int expected = 2;
    // Act
    int actual = test.getLevelAttributes().getDexterity();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void mageIntelligence_LevelUp_ShouldBe13() {
    // Arrange
    test.levelUp();
    int expected = 13;
    // Act
    int actual = test.getLevelAttributes().getIntelligence();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void equipValidWeapon() {
    try {
      // Arrange
      test.equip(validWeapon);
      Weapon expected = validWeapon;
      // Act
      Weapon actual = (Weapon) test.getEquipment().get(Slot.Weapon);
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void equipInvalidWeaponLevelTooLow_ShouldThrowError() throws Exception {
    expectedEx.expect(InvalidWeaponException.class);
    expectedEx.expectMessage("The hero does not have high enough level to equip this weapon");
    test.equip(inValidWeaponLevel);
  }

  @Test
  public void equipInvalidWeaponType_ShouldThrowError() throws Exception {
    expectedEx.expect(InvalidWeaponException.class);
    expectedEx.expectMessage("The weapon type is not valid for this class");
    test.equip(inValidWeaponType);
  }

  @Test
  public void equipValidArmor() {
    try {
      // Arrange
      test.equip(validArmor);
      Armor expected = validArmor;
      // Act
      Armor actual = (Armor) test.getEquipment().get(Slot.Body);
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void equipInvalidArmorLevelTooLow_ShouldThrowError() throws Exception {
    expectedEx.expect(InvalidArmorException.class);
    expectedEx.expectMessage("The hero does not have high enough level to equip this armor");
    test.equip(inValidArmorLevel);
  }

  @Test
  public void equipInvalidArmorType_ShouldThrowError() throws Exception {
    expectedEx.expect(InvalidArmorException.class);
    expectedEx.expectMessage("The armor type is not valid for this class");
    test.equip(invalidArmorType);
  }

  @Test
  public void totalAttributesWithOnePieceOfArmor() {
    try {
      // Arrange
      test.equip(firstArmor);
      HeroAttribute expected = new HeroAttribute(2, 2, 9);
      // Act
      HeroAttribute actual = test.totalAttributes();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void totalAttributesWithTwoPiecesOfArmor() {
    try {
      // Arrange
      test.equip(firstArmor);
      test.equip(secondArmor);
      HeroAttribute expected = new HeroAttribute(3, 3, 10);
      // Act
      HeroAttribute actual = test.totalAttributes();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void totalAttributesWithThreePiecesOfArmor() {
    try {
      // Arrange
      test.equip(firstArmor);
      test.equip(secondArmor);
      test.equip(thirdArmor);
      HeroAttribute expected = new HeroAttribute(4, 4, 11);
      // Act
      HeroAttribute actual = test.totalAttributes();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void totalAttributesWithReplacedArmor() {
    try {
      // Arrange
      test.equip(firstArmor);
      test.equip(sameSlotAsFirstArmor);
      HeroAttribute expected = new HeroAttribute(3, 3, 10);
      // Act
      HeroAttribute actual = test.totalAttributes();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void damageWithNoWeapon() {
    // Arrange
    int expected = 1;
    // Act
    int actual = test.damage();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void damageWithWeapon() {
    try {
      // Arrange
      test.equip(validWeapon);
      int expected = 3;
      // Act
      int actual = test.damage();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void damageWithReplacedWeapon() {
    try {
      // Arrange
      test.equip(validWeapon);
      test.equip(newValidWeapon);
      int expected = 4;
      // Act
      int actual = test.damage();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void damageWithWeaponAndArmor() {
    try {
      // Arrange
      test.equip(validWeapon);
      test.equip(bigDamageImpactArmor);
      int expected = 6;
      // Act
      int actual = test.damage();
      // Assert
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void displayMage() {
    // Arrange
    String expected = "\n---------------------------\nNAME: test\nCLASS: MAGE\nLEVEL: 1\nSTRENGTH: 1 DEXTERITY: 1 INTELLIGENCE: 8\nDAMAGE: 1\n---------------------------\n";
    // Act
    String actual = test.display();
    // Assert
    assertEquals(expected, actual);
  }

}
