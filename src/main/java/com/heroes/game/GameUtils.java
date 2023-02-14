package com.heroes.game;

public class GameUtils {
  public static void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void createDeadEnd(String place) {
    System.out.println("\n------------------------------------------------------\n");
    System.out.println("You come to a deep " + place + ", with no possibility to come around");
    System.out.println("\n------------------------------------------------------\n");
    System.out.println("Press to return");
  }
}
