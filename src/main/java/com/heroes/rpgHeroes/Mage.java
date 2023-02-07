package com.heroes.rpgHeroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heroes.items.Armor;
import com.heroes.items.ArmorType;
import com.heroes.items.Item;
import com.heroes.items.Slot;
import com.heroes.items.Weapon;
import com.heroes.items.WeaponType;

public class Mage extends Hero {

  public HeroAttribute levelAttributes;
  public Map<Slot, Item> equipment = new HashMap<>();
  public List<WeaponType> validWeaponTypes = new ArrayList<>();
  public List<ArmorType> validArmorTypes = new ArrayList<>();

  public Mage(String name) {
    super(name);
    this.levelAttributes = new HeroAttribute(1, 1, 8);

    equipment.put(Slot.Body, null);
    equipment.put(Slot.Head, null);
    equipment.put(Slot.Legs, null);
    equipment.put(Slot.Weapon, null);

    validWeaponTypes.add(WeaponType.Staff);
    validWeaponTypes.add(WeaponType.Wand);

    validArmorTypes.add(ArmorType.Cloth);
  }

  public void levelUp() {
    this.level++;
    this.levelAttributes.increaseAttribute(1, 1, 5);
  }

  public int totalAttributes() {
    int level = this.levelAttributes.getTotal();
    int armorAttributes = 0;

    for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
      Slot s = set.getKey();
      Item i = set.getValue();

      if (!i.equals(null) || !s.equals(Slot.Weapon)) {
        Armor a = (Armor) i;
        armorAttributes += a.armorAttribute.getTotal();
      }
    }

    return level + armorAttributes;
  }

  public int damage() {
    int intelligence = this.levelAttributes.intelligence;
    Weapon weapon = (Weapon) equipment.get(Slot.Weapon);
    int weaponDamage = 1;
    if (weapon != null)
      weaponDamage = weapon.damage;
    return weaponDamage * (1 + (intelligence / 100));
  }

  public void equip(Weapon weapon) {
    if (weapon.requiredLevel <= this.level) {
      if (validWeaponTypes.contains(weapon.type)) {
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

  public void display() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n---------------------------\n");
    sb.append("NAME: " + this.name + "\n");
    sb.append("CLASS: MAGE\n");
    sb.append("LEVEL: " + this.level + "\n");
    sb.append("STRENGTH: " + this.levelAttributes.strength + " ");
    sb.append("DEXTERITY: " + this.levelAttributes.dexterity + " ");
    sb.append("INTELLIGENCE: " + this.levelAttributes.intelligence + "\n");
    sb.append("DAMAGE: " + this.damage() + "\n");
    sb.append("---------------------------\n");
    System.out.println(sb.toString());
  }
}
