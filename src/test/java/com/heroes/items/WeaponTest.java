package com.heroes.items;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;

public class WeaponTest {

  Weapon staff;

  @Before
  public void setUp() {
    staff = new Weapon("testStaff", 4, WeaponType.Staff, 3);
  }

  @Test
  public void weaponCreationShouldInitCorrectName() {
    // Arrange
    String expected = "testStaff";
    // Act
    String actual = staff.getName();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void weaponCreationShouldInitCorrectRequiredLevel() {
    // Arrange
    int expected = 4;
    // Act
    int actual = staff.getRequiredLevel();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void weaponCreationShouldInitCorrectSlot() {
    // Arrange
    Slot expected = Slot.Weapon;
    // Act
    Slot actual = staff.getSlot();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void weaponCreationShouldInitCorrectType() {
    // Arrange
    WeaponType expected = WeaponType.Staff;
    // Act
    WeaponType actual = staff.getType();
    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void weaponCreationShouldInitCorrectDamage() {
    // Arrange
    int expected = 3;
    // Act
    int actual = staff.getDamage();
    // Assert
    assertEquals(expected, actual);
  }
}
