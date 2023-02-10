package com.heroes.items;

import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;

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
}
