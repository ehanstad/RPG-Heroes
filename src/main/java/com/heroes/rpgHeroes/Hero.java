package com.heroes.rpgHeroes;

import java.util.ArrayList;
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

public abstract class Hero {
  private String name;
  private int level;
  private HeroAttribute levelAttributes;
  private Map<Slot, Item> equipment = new HashMap<>();
  private List<WeaponType> validWeaponTypes = new ArrayList<>();
  private List<ArmorType> validArmorTypes = new ArrayList<>();

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

  abstract public int damage();

  abstract public void equip(Weapon weapon);

  abstract public void equip(Armor armor);

  abstract public void display();

  public int totalAttributes() {
    int level = this.levelAttributes.getTotal();
    int armorAttributes = 0;

    for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
      Slot s = set.getKey();
      Item i = set.getValue();

      if (!i.equals(null) || !s.equals(Slot.Weapon)) {
        Armor a = (Armor) i;
        HeroAttribute ha = (HeroAttribute) a.getHeroAttribute();
        armorAttributes += ha.getTotal();
      }
    }

    return level + armorAttributes;
  }

  public void equipWeapon(Weapon weapon, List<WeaponType> validWeaponTypes) throws InvalidWeaponException {
    if (!validWeaponTypes.contains(weapon.getType()))
      throw new InvalidWeaponException("The weapon type is not valid for this class");
    if (weapon.getRequiredLevel() <= this.level)
      throw new InvalidWeaponException("The hero does not have high enough level to equip this weapon");
    equipment.put(Slot.Weapon, weapon);
  }

  public void equipArmor(Armor armor, List<ArmorType> validArmorTypes) throws InvalidArmorException {
    if (!validArmorTypes.contains(armor.getType()))
      throw new InvalidArmorException("The armor type is not valid for this class");
    if (armor.getRequiredLevel() <= this.level)
      throw new InvalidArmorException("The hero does not have high enough level to equip this armor");
    equipment.put(armor.getSlot(), armor);
  }

  public void displayHero(String heroClass, HeroAttribute levelAttributes, int damage) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n---------------------------\n");
    sb.append("NAME: " + this.name + "\n");
    sb.append("CLASS: " + heroClass + "\n");
    sb.append("LEVEL: " + this.level + "\n");
    sb.append("STRENGTH: " + levelAttributes.getStrength() + " ");
    sb.append("DEXTERITY: " + levelAttributes.getDexterity() + " ");
    sb.append("INTELLIGENCE: " + levelAttributes.getIntelligence() + "\n");
    sb.append("DAMAGE: " + damage + "\n");
    sb.append("---------------------------\n");
    System.out.println(sb.toString());
  }
}
