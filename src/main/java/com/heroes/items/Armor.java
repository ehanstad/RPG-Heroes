package com.heroes.items;

import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.rpgHeroes.HeroAttribute;

/**
 * Armor is a type of Item with an armor type and a HeroAttribute.
 * Armor can be placed in Slot head, body and legs
 */
public class Armor extends Item {
  private ArmorType type;
  private HeroAttribute armorAttribute;

  public Armor(String name, int requiredLevel, ArmorType type, HeroAttribute armorAttribute, Slot slot) {
    super(name, requiredLevel, slot);
    this.type = type;
    this.armorAttribute = armorAttribute;
  }

  public Object getType() {
    return this.type;
  }

  public Object getHeroAttribute() {
    return this.armorAttribute;
  }
}
