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
    return super.totalHeroAttributes(this.levelAttributes.getTotal());
  }

  @Override
  public void levelUp() {
    super.levelUp();
    this.levelAttributes.increaseAttribute(1, 1, 5);
  }

  @Override
  public int damage() {
    int damagingAttribute = this.levelAttributes.getDexterity() + super.getArmorAttributes("intelligence");
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
    displayHero("Mage", this.levelAttributes, this.damage());
  }
}
