package com.heroes.rpgHeroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heroes.items.Armor;
import com.heroes.items.Item;
import com.heroes.items.Slot;
import com.heroes.items.Weapon;
import com.heroes.items.types.ArmorType;
import com.heroes.items.types.WeaponType;

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

  public void levelUp() {
    this.level++;
  }

  abstract public int damage();

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

  public void equip(Weapon weapon) {
    if (weapon.getRequiredLevel() <= this.level) {
      if (validWeaponTypes.contains(weapon.getType())) {
        equipment.put(Slot.Weapon, weapon);
      } else {
        // throw new InvalidWeaponTypeError("The weapon type is not valid for this
        // class");
        System.out.println("The weapon type is not valid for this class");
      }
    } else {
      System.out.println("The hero does not have high enough level to equip this weapon");
    }
  }

  public void equip(Armor armor) {
    if (armor.getRequiredLevel() <= this.level) {
      if (validArmorTypes.contains(armor.getType())) {
        equipment.put(armor.getSlot(), armor);
      } else {
        // throw new InvalidWeaponTypeError("The weapon type is not valid for this
        // class");
        System.out.println("The weapon type is not valid for this class");
      }
    } else {
      System.out.println("The hero does not have high enough level to equip this weapon");
    }
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
