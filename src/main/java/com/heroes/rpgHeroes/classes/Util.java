package com.heroes.rpgHeroes.classes;

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
import com.heroes.rpgHeroes.HeroAttribute;

/**
 * This class is help class for the hero-subclasses, it contains methods to
 * reduce redundant code
 */
public class Util {
  protected static int totalHeroAttributes(int level, Map<Slot, Item> equipment) {
    int armorAttributes = 0;

    for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
      if (set.getValue() != null && set.getValue() instanceof Armor) {
        Armor a = (Armor) set.getValue();
        HeroAttribute ha = (HeroAttribute) a.getHeroAttribute();
        armorAttributes += ha.getTotal();
      }
    }

    return level + armorAttributes;
  }

  protected static void equipWeapon(Weapon weapon, List<WeaponType> validWeaponTypes, int level,
      Map<Slot, Item> equipment)
      throws InvalidWeaponException {
    if (!validWeaponTypes.contains(weapon.getType()))
      throw new InvalidWeaponException("The weapon type is not valid for this class");
    if (weapon.getRequiredLevel() > level)
      throw new InvalidWeaponException("The hero does not have high enough level to equip this weapon");
    equipment.put(Slot.Weapon, weapon);
  }

  protected static void equipArmor(Armor armor, List<ArmorType> validArmorTypes, int level, Map<Slot, Item> equipment)
      throws InvalidArmorException {
    if (!validArmorTypes.contains(armor.getType()))
      throw new InvalidArmorException("The armor type is not valid for this class");
    if (armor.getRequiredLevel() > level)
      throw new InvalidArmorException("The hero does not have high enough level to equip this armor");
    equipment.put(armor.getSlot(), armor);
  }

  protected static void displayHero(String name, String heroClass, int level, HeroAttribute levelAttributes,
      int damage) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n---------------------------\n");
    sb.append("NAME: " + name + "\n");
    sb.append("CLASS: " + heroClass + "\n");
    sb.append("LEVEL: " + level + "\n");
    sb.append("STRENGTH: " + levelAttributes.getStrength() + " ");
    sb.append("DEXTERITY: " + levelAttributes.getDexterity() + " ");
    sb.append("INTELLIGENCE: " + levelAttributes.getIntelligence() + "\n");
    sb.append("DAMAGE: " + damage + "\n");
    sb.append("---------------------------\n");
    System.out.println(sb.toString());
  }

  protected static int getArmorAttributes(String attribute, Map<Slot, Item> equipment) {
    int armorAttributes = 0;
    for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
      if (set.getValue() != null && set.getValue() instanceof Armor) {
        Armor a = (Armor) set.getValue();
        HeroAttribute heroAttribute = (HeroAttribute) a.getHeroAttribute();
        switch (attribute) {
          case "strength":
            armorAttributes += heroAttribute.getStrength();
            break;
          case "dexterity":
            armorAttributes += heroAttribute.getDexterity();
            break;
          case "intelligence":
            armorAttributes += heroAttribute.getIntelligence();
            break;
          default:
            break;
        }
      }
    }
    return armorAttributes;
  }

  protected static int getWeaponDamage(Map<Slot, Item> equipment) {
    Weapon weapon = (Weapon) equipment.get(Slot.Weapon);
    if (weapon != null)
      return weapon.getDamage();
    return 1;
  }
}
