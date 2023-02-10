package com.heroes.rpgHeroes.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heroes.items.Armor;
import com.heroes.items.Item;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.HeroAttribute;

public class Ranger extends Hero {
  private HeroAttribute levelAttributes;
  private Map<Slot, Item> equipment = new HashMap<>();
  private List<WeaponType> validWeaponTypes = new ArrayList<>();
  private List<ArmorType> validArmorTypes = new ArrayList<>();

  public Ranger(String name) {
    super(name);
    this.levelAttributes = new HeroAttribute(1, 7, 1);
    validWeaponTypes.add(WeaponType.Wand);

    validArmorTypes.add(ArmorType.Leather);
    validArmorTypes.add(ArmorType.Mail);
  }

  public HeroAttribute getLevelAttributes() {
    return this.levelAttributes;
  }

  @Override
  public void levelUp() {
    super.levelUp();
    this.levelAttributes.increaseAttribute(1, 5, 1);
  }

  @Override
  public int damage() {
    int dexterity = this.levelAttributes.getDexterity();
    Weapon weapon = (Weapon) super.getEquipment().get(Slot.Weapon);
    int weaponDamage = 1;
    if (weapon != null)
      weaponDamage = weapon.getDamage();
    return weaponDamage * (1 + (dexterity / 100));
  }

  @Override
  public void equip(Weapon weapon) {
    try {
      super.equipWeapon(weapon, this.validWeaponTypes);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void equip(Armor armor) {
    try {
      super.equipArmor(armor, validArmorTypes);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void display() {
    displayHero("Ranger", this.levelAttributes, this.damage());
  }
}