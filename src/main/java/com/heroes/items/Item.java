package com.heroes.items;

import com.heroes.items.enums.Slot;

/**
 * An Item has a name, a required level which indicates what level the
 * hero needs to equip the Item and a Slot which indicates what Slot the
 * Item is equipped
 */
public abstract class Item {
  protected String name;
  protected int requiredLevel;
  protected Slot slot;

  public Item(String name, int requiredLevel, Slot slot) {
    this.name = name;
    this.requiredLevel = requiredLevel;
    this.slot = slot;
  }

  public String getName() {
    return this.name;
  }

  public int getRequiredLevel() {
    return this.requiredLevel;
  }

  public Slot getSlot() {
    return this.slot;
  }
}
