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

/**
 * This class is an instance of Mage, a subclass to Hero.
 */
public class Mage extends Hero {
  private HeroAttribute levelAttributes;
  private List<WeaponType> validWeaponTypes = new ArrayList<>();
  private List<ArmorType> validArmorTypes = new ArrayList<>();

  public Mage(String name) {
    super(name);
    this.levelAttributes = new HeroAttribute(1, 1, 8);

    validWeaponTypes.add(WeaponType.Staff);
    validWeaponTypes.add(WeaponType.Wand);

    validArmorTypes.add(ArmorType.Cloth);
  }

  public HeroAttribute getLevelAttributes() {
    return this.levelAttributes;
  }

  @Override
  public int totalAttributes() {
    return Util.totalHeroAttributes(this.levelAttributes.getTotal(), super.equipment);
  }

  @Override
  public void levelUp() {
    super.levelUp();
    this.levelAttributes.increaseAttribute(1, 1, 5);
  }

  @Override
  public int damage() {
    int damagingAttribute = this.levelAttributes.getDexterity()
        + Util.getArmorAttributes("intelligence", super.equipment);
    return Util.getWeaponDamage(super.equipment) * (1 + (damagingAttribute / 100));
  }

  @Override
  public void equip(Weapon weapon) throws InvalidWeaponException {
    try {
      Util.equipWeapon(weapon, this.validWeaponTypes, super.level, super.equipment);
    } catch (Exception e) {
      throw new InvalidWeaponException(e.getMessage());
    }
  }

  @Override
  public void equip(Armor armor) throws InvalidArmorException {
    try {
      Util.equipArmor(armor, validArmorTypes, super.level, super.equipment);
    } catch (Exception e) {
      throw new InvalidArmorException(e.getMessage());
    }
  }

  @Override
  public String display() {
    return Util.displayHero(super.name, "MAGE", super.level, this.levelAttributes, damage());
  }
}
