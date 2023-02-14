package com.heroes.game;

import java.util.Scanner;

import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.classes.Mage;
import com.heroes.rpgHeroes.classes.Ranger;
import com.heroes.rpgHeroes.classes.Rogue;
import com.heroes.rpgHeroes.classes.Warrior;

/**
 * This class handles the init of the game, it creates a hero depending on the
 * users choses.
 */
public class Game {

  public static void startGame() {
    Scanner in = new Scanner(System.in);
    System.out.println("CHOOSE YOUR CLASS");
    System.out.println("m = mage\tr = ranger\to = rogue\tw = warrior");
    String _class = in.nextLine();

    switch (_class) {
      case "m":
        createMage(in);
        break;
      case "r":
        createRanger(in);
      case "o":
        createRogue(in);
        break;
      case "w":
        createWarrior(in);
        break;
      default:
        System.out.println("invalid input");
        break;
    }
  }

  private static void createWarrior(Scanner in) {
    System.out.println("SET A NAME FOR YOUR NEW WARRIOR");
    String name = in.nextLine();
    Warrior hero = new Warrior(name);
    FirstSection.startAdventure(hero, in);
  }

  private static void createRogue(Scanner in) {
    System.out.println("SET A NAME FOR YOUR NEW ROGUE");
    String name = in.nextLine();
    Rogue hero = new Rogue(name);
    FirstSection.startAdventure((Hero) hero, in);
  }

  private static void createRanger(Scanner in) {
    System.out.println("SET A NAME FOR YOUR NEW RANGER");
    String name = in.nextLine();
    Ranger hero = new Ranger(name);
    FirstSection.startAdventure(hero, in);
  }

  private static void createMage(Scanner in) {
    System.out.println("SET A NAME FOR YOUR NEW MAGE");
    String name = in.nextLine();
    Mage hero = new Mage(name);
    FirstSection.startAdventure(hero, in);
  }
}
