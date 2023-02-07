package com.heroes.rpgHeroes;

public class Hero {
  public String name;
  public int level;

  public Hero(String name) {
    this.name = name;
    this.level = 1;
  }

  public void levelUp() {
    this.level++;
  }

  public void display() {
  }
}
