package com.heroes.items;

import com.heroes.items.types.ArmorType;
import com.heroes.rpgHeroes.HeroAttribute;

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
