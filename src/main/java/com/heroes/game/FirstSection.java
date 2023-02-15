package com.heroes.game;

import java.util.Scanner;

import com.heroes.exceptions.InvalidWeaponException;
import com.heroes.items.Armor;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.HeroAttribute;

/**
 * This is where the first section of the game is.
 */
public class FirstSection {

  protected static void startAdventure(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    GameUtils.createLine();
    System.out
        .println(ConsoleColors.TEXT_BRIGHT_BLUE
            + "Your adventure starts far out in the deep forest of Tailwoods your hero " + hero.getName()
            + " is alone and cold and as no idea what lurks in this uninviting environment.");
    GameUtils.createLine();
    System.out.println("You have some different choses to do:");
    System.out.println(
        "w = travel north\ta = travel west\td = travel east\ts = travel south\nl = view your hero");
    while (true) {
      switch (in.nextLine()) {
        case "w":
          travelNorth(hero, in);
          break;
        case "a":
          travelWest(hero, in);
          break;
        case "d":
          travelEast(hero, in);
          break;
        case "s":
          travelSouth(hero, in);
          break;
        case "l":
          hero.display();
          break;
        default:
          System.out.println("invalid input");
          break;
      }
    }
  }

  private static void travelSouth(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    int villainHp = 3;
    Weapon smallKnife = new Weapon("smallKnife", 1, WeaponType.Dagger, 1);
    GameUtils.createLine();
    System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE +
        "As your hero travel south a strange sight catches your hero's eye. A what seems to be a human sized duck approaches him. It's intentions seems friendly...");
    System.out.println(
        "At FIRST. For as your hero gets closer it becomes clear that this duck has some real nasty intensions. He holds a small knife and his eyebrows are in V-shape");
    GameUtils.createLine();

    while (true) {
      System.out.println("attack = a\trun away = r\tduck's hp: " + villainHp);
      switch (in.nextLine()) {
        case "a":
          System.out.println("You damage " + hero.damage() + " attacks");
          villainHp -= hero.damage();
          if (villainHp <= 0) {
            hero.levelUp();
            System.out
                .println("Your hero have gotten enough experience to level up. It is now level: " + hero.getLevel());
            try {
              hero.equip(smallKnife);
              System.out.println("You have gotten a new weapon");
            } catch (InvalidWeaponException e) {
              System.out.println(e.getMessage());
            } finally {
              System.out.println("Press to move on");
              if (in.nextLine() != null) {
                SecondSection.startSecondSection(hero, in);
              }
            }
          } else {
            System.out.println("Your fierce enemy attacks you with a damage of 0");
          }
          break;
        case "r":
          SecondSection.startSecondSection(hero, in);
          break;
        default:
          System.out.println("invalid input");
          break;
      }
    }
  }

  private static void travelEast(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    GameUtils.createDeadEnd("cliff");
    if (in.nextLine() != null) {
      startAdventure(hero, in);
    }
  }

  private static void travelWest(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    GameUtils.createDeadEnd("ocean");
    if (in.nextLine() != null) {
      startAdventure(hero, in);
    }
  }

  private static void travelNorth(Hero hero, Scanner in) {
    Armor neatBoots = new Armor("neat boots", 1, ArmorType.Leather, new HeroAttribute(1, 1, 1), Slot.Legs);
    while (true) {
      GameUtils.clearScreen();
      GameUtils.createLine();
      System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "As your hero travel north you find some neat looking boots");
      GameUtils.createLine();
      try {
        hero.equip(neatBoots);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } finally {
        System.out.println("Press to move on");
        if (in.nextLine() != null) {
          SecondSection.startSecondSection(hero, in);
        }
      }
    }
  }
}
