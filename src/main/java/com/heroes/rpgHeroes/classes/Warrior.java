package com.heroes.rpgHeroes.classes;

import java.util.ArrayList;
import java.util.List;

import com.heroes.exceptions.InvalidArmorException;
import com.heroes.exceptions.InvalidWeaponException;
import com.heroes.items.Armor;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.HeroAttribute;

public class Warrior extends Hero {
  private HeroAttribute levelAttributes;
  private List<WeaponType> validWeaponTypes = new ArrayList<>();
  private List<ArmorType> validArmorTypes = new ArrayList<>();

  public Warrior(String name) {
    super(name);
    this.levelAttributes = new HeroAttribute(5, 2, 1);

    validWeaponTypes.add(WeaponType.Axe);
    validWeaponTypes.add(WeaponType.Hammer);
    validWeaponTypes.add(WeaponType.Sword);

    validArmorTypes.add(ArmorType.Mail);
    validArmorTypes.add(ArmorType.Plate);
  }

  public HeroAttribute getLevelAttributes() {
    return this.levelAttributes;
  }

  @Override
  public void levelUp() {
    super.levelUp();
    this.levelAttributes.increaseAttribute(3, 2, 1);
  }

  @Override
  public int totalAttributes() {
    return super.totalHeroAttributes(this.levelAttributes.getTotal());
  }

  @Override
  public int damage() {
    int damagingAttribute = this.levelAttributes.getDexterity() + super.getArmorAttributes("strength");
    return super.getWeaponDamage() * (1 + (damagingAttribute / 100));
  }

  @Override
  public void equip(Weapon weapon) throws InvalidWeaponException {
    try {
      super.equipWeapon(weapon, this.validWeaponTypes);
    } catch (Exception e) {
      throw new InvalidWeaponException(e.getMessage());
    }
  }

  @Override
  public void equip(Armor armor) throws InvalidArmorException {
    try {
      super.equipArmor(armor, validArmorTypes);
    } catch (Exception e) {
      throw new InvalidArmorException(e.getMessage());
    }
  }

  @Override
  public void display() {
    displayHero("Warrior", this.levelAttributes, this.damage());
  }
}
