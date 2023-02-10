package com.heroes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.heroes.items.Weapon;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.classes.Mage;

public class MageTest {

  Mage mage = new Mage("testMage");
  Weapon staff = new Weapon("testStaff", 4, WeaponType.Staff, 3);
  Weapon bow = new Weapon("testBow", 1, WeaponType.Bow, 2);

  @Test
  public void mageNameShouldBeCorrect() {
    assertEquals(mage.getName(), "testMage");
  }

  @Test
  public void mageLevelShouldBeCorrect() {
    assertEquals(mage.getLevel(), 1);
  }

  @Test
  public void mageStrengthShouldBeCorrect() {
    assertEquals(mage.getLevelAttributes().getStrength(), 1);
  }

  @Test
  public void mageDexterityShouldBeCorrect() {
    assertEquals(mage.getLevelAttributes().getDexterity(), 1);
  }

  @Test
  public void mageIntelligenceShouldBeCorrect() {
    assertEquals(mage.getLevelAttributes().getIntelligence(), 8);
  }

  @Test
  public void mageLevelShouldBeCorrectAfterLevelingUp() {
    mage.levelUp();
    assertEquals(mage.getLevel(), 2);
  }

  @Test
  public void mageLevelAttributesShouldBeCorrectAfterLevelingUp() {
    mage.levelUp();
    assertEquals(mage.getLevelAttributes().getStrength(), 2);
    assertEquals(mage.getLevelAttributes().getDexterity(), 2);
    assertEquals(mage.getLevelAttributes().getIntelligence(), 13);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  // @Test
  // public void equipWeaponLevelTooLowShouldThrowError() throws Exception {
  // expectedEx.expect(Exception.class);
  // expectedEx.expectMessage("The hero does not have high enough level to equip
  // this weapon");
  // mage.equip(staff);
  // }

  // @Test
  // public void equipWeaponNotInValidWeaponListShouldThrow() {
  // assertEquals(mage.equip(bow), "The weapon type is not valid for this class");
  // }

  @Test
  public void equipValidWeapon() {
    mage.levelUp();
    mage.levelUp();
    mage.equip(staff);
    assertEquals(mage.getEquipment().get(Slot.Weapon), staff);
  }
}
