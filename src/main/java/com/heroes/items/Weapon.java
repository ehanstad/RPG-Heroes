package com.heroes.items;

import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;

/**
 * Weapon is a type of Item with an weapon type and damage.
 * Weapon can be placed in Slot weapon
 */
public class Weapon extends Item {
  private WeaponType type;
  private int damage;

  public Weapon(String name, int requiredLevel, WeaponType type, int damage) {
    super(name, requiredLevel, Slot.Weapon);
    this.type = type;
    this.damage = damage;
  }

  public int getDamage() {
    return this.damage;
  }

  public WeaponType getType() {
    return this.type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Weapon that = (Weapon) o;
    return type == that.type &&
        damage == that.damage &&
        super.name == that.name &&
        super.requiredLevel == that.requiredLevel &&
        super.slot == that.slot;
  }
}
