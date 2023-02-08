package com.heroes.rpgHeroes.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heroes.items.Item;
import com.heroes.items.Slot;
import com.heroes.items.Weapon;
import com.heroes.items.types.ArmorType;
import com.heroes.items.types.WeaponType;
import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.HeroAttribute;

public class Mage extends Hero {
  private HeroAttribute levelAttributes;
  private Map<Slot, Item> equipment = new HashMap<>();
  private List<WeaponType> validWeaponTypes = new ArrayList<>();
  private List<ArmorType> validArmorTypes = new ArrayList<>();

  public Mage(String name) {
    super(name);
    this.levelAttributes = new HeroAttribute(1, 1, 8);

    validWeaponTypes.add(WeaponType.Staff);
    validWeaponTypes.add(WeaponType.Wand);

    validArmorTypes.add(ArmorType.Cloth);
  }

  @Override
  public void levelUp() {
    super.levelUp();
    this.levelAttributes.increaseAttribute(1, 1, 5);
  }

  @Override
  public int damage() {
    int intelligence = this.levelAttributes.getIntelligence();
    Weapon weapon = (Weapon) equipment.get(Slot.Weapon);
    int weaponDamage = 1;
    if (weapon != null)
      weaponDamage = weapon.getDamage();
    return weaponDamage * (1 + (intelligence / 100));
  }

  @Override
  public void display() {
    displayHero("Mage", this.levelAttributes, this.damage());
  }
}
