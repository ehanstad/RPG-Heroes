package com.heroes.items;

import com.heroes.items.enums.Slot;

public abstract class Item {
  private String name;
  private int requiredLevel;
  private Slot slot;

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
