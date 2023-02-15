package com.heroes.game;

import java.util.Scanner;

public class GameUtils {
  public static void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void createDeadEnd(String place) {
    createLine();
    System.out.println("You come to a deep " + place + ", with no possibility to come around");
    createLine();
    System.out.println("Press to return");
  }

  public static void createLine() {
    System.out.println(ConsoleColors.TEXT_RESET + "\n------------------------------------------------------\n");
  }

  public static void gameOver(Scanner in) {
    System.out.println(ConsoleColors.TEXT_BRIGHT_RED + "GAME OVER");
    System.out.println("Press to start over");
    if (in.nextLine() != null) {
      Game.startGame();
    }
  }
}
