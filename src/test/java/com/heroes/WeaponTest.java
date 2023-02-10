package com.heroes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.heroes.items.Weapon;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;

public class WeaponTest {
  Weapon staff = new Weapon("testStaff", 4, WeaponType.Staff, 3);

  @Test
  public void weaponCreationShouldInitCorrectName() {
    assertEquals(staff.getName(), "testStaff");
  }

  @Test
  public void weaponCreationShouldInitCorrectRequiredLevel() {
    assertEquals(staff.getRequiredLevel(), 4);
  }

  @Test
  public void weaponCreationShouldInitCorrectSlot() {
    assertEquals(staff.getSlot(), Slot.Weapon);
  }

  @Test
  public void weaponCreationShouldInitCorrectType() {
    assertEquals(staff.getType(), WeaponType.Staff);
  }

  @Test
  public void weaponCreationShouldInitCorrectDamage() {
    assertEquals(staff.getDamage(), 3);
  }
}
