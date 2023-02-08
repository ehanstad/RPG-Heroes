package com.heroes.rpgHeroes;

public class HeroAttribute {
  private int strength;
  private int dexterity;
  private int intelligence;

  public HeroAttribute(int strength, int dexterity, int intelligence) {
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }

  public void increaseAttribute(int strength, int dexterity, int intelligence) {
    this.strength += strength;
    this.dexterity += dexterity;
    this.intelligence += intelligence;
  }

  public int getTotal() {
    return this.strength + this.dexterity + this.intelligence;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getDexterity() {
    return this.dexterity;
  }

  public int getIntelligence() {
    return this.intelligence;
  }
}
