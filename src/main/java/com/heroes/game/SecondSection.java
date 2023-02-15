package com.heroes.game;

import java.util.Scanner;

import com.heroes.rpgHeroes.Hero;

public class SecondSection {
  protected static void startSecondSection(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    GameUtils.createLine();
    System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE +
        "Your hero has now rambled out from the Tailwoods and entered a small tavern in the outskirts of the town of Coldshield.\n");
    System.out.println(
        "Inside your hero is faced by a wall of smoke and a rough smell of tobacco. There are two empty seats; one next to a obese fellow with a grime smile. The other seat is between a wizard-looking man and a lime-green woman.");
    GameUtils.createLine();
    System.out.println("a = sit next the obese fellow\ts = sit between the wizard-looking and lime-green woman.");
    while (true) {
      switch (in.nextLine()) {
        case "a":
          sitNextToWarrior(hero, in);
          break;
        case "s":
          sitNextToWizard(hero, in);
          break;
        default:
          System.out.println("invalid input");
          break;
      }
    }
  }

  private static void sitNextToWarrior(Hero hero, Scanner in) {
    int warriorHp = 3;
    GameUtils.clearScreen();
    GameUtils.createLine();
    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW + "'HeLlo small FelloW!'");
    System.out.println(ConsoleColors.TEXT_RESET
        + "A deep swirly voice gasps. Your hungry and tired hero tries to ignore it, but in vain.");
    System.out
        .println(ConsoleColors.TEXT_BRIGHT_YELLOW + "'DiDntt you hEAR Me' he slurred while pointing intensely at you");
    GameUtils.createLine();
    System.out.println("He is obviously very drunk and you could probably take him down");
    System.out.println("a = sneak attack\ts = ignore him and order some food");
    while (true) {
      switch (in.nextLine()) {
        case "a":
          warriorHp -= hero.damage();
          System.out.println("You damage " + hero.damage() + " without him noticing");
          System.out.println("He has " + warriorHp + " hp left");
          if (warriorHp <= 0) {
            hero.levelUp();
            System.out.println(ConsoleColors.TEXT_CYAN + "Your hero gains enough experience to level up!");
            System.out.println("--TODO next section--");
            if (in.nextLine() != null) {

            }
          }
          break;
        case "s":
          System.out.println("--TODO next section--");
          if (in.nextLine() != null) {

          }
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }
  }

  private static void sitNextToWizard(Hero hero, Scanner in) {
    GameUtils.clearScreen();
    GameUtils.createLine();
    System.out.println(ConsoleColors.TEXT_BRIGHT_RED
        + "As your hero sits down, he realizes that the seat is not at all empty. A small mouse is on its way to take a large bite of its even smaller burger. But it´s already to late. Your hero smashes the poor thing with bottoms.");
    System.out.println("The wizard which apparently is the mouses secret lover gets so mad that he kills your hero.");
    GameUtils.createLine();
    GameUtils.gameOver(in);
  }
}
