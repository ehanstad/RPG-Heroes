package com.heroes.rpgHeroes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heroes.exceptions.InvalidArmorException;
import com.heroes.exceptions.InvalidWeaponException;
import com.heroes.items.Armor;
import com.heroes.items.Item;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;

/**
 * This is a abstract class representing a Hero.
 */
public abstract class Hero {
  protected String name;
  protected int level;
  protected HeroAttribute levelAttributes;
  protected Map<Slot, Item> equipment = new HashMap<>();
  protected List<WeaponType> validWeaponTypes;
  protected List<ArmorType> validArmorTypes;

  public Hero(String name) {
    this.name = name;
    this.level = 1;
    equipment.put(Slot.Body, null);
    equipment.put(Slot.Head, null);
    equipment.put(Slot.Legs, null);
    equipment.put(Slot.Weapon, null);
  }

  public String getName() {
    return this.name;
  }

  public int getLevel() {
    return this.level;
  }

  public Map<Slot, Item> getEquipment() {
    return this.equipment;
  }

  public void levelUp() {
    this.level++;
  }

  /**
   * Calculates the heros damage, depends on Weapon, Attributes and
   * Armor
   * 
   * @return the heros damage as a int
   */
  abstract public int damage();

  /**
   * Calculates the heros total attributes
   * 
   * @return the heros total attributes
   */
  abstract public int totalAttributes();

  /**
   * Adds a weapon to the equipment of the hero
   * 
   * @param weapon the weapon which is being equipped
   * @throws InvalidWeaponException if the required level is to high or weapon is
   *                                not valid list a exception is thrown
   */
  abstract public void equip(Weapon weapon) throws InvalidWeaponException;

  /**
   * Adds a armor to the equipment of the hero
   * 
   * @param armor the armor which is being equipped
   * @throws InvalidArmorException if the required level is to high or weapon is
   *                               not valid list a exception is thrown
   */
  abstract public void equip(Armor armor) throws InvalidArmorException;

  /**
   * Display's the heros name, level, class, attributes and damage to the console
   */
  abstract public void display();

}
