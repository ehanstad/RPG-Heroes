package com.heroes.rpgHeroes;

public class HeroAttribute {
  public int strength;
  public int dexterity;
  public int intelligence;

  public HeroAttribute(int s, int d, int i) {
    this.strength = s;
    this.dexterity = d;
    this.intelligence = i;
  }

  public void increaseAttribute(int s, int d, int i) {
    this.strength += s;
    this.dexterity += d;
    this.intelligence += i;
  }

  public int getTotal() {
    return this.strength + this.dexterity + this.intelligence;
  }
}
