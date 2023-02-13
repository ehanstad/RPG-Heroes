package com.heroes;

import java.util.Scanner;

import com.heroes.game.Game;
import com.heroes.items.Armor;
import com.heroes.items.Weapon;
import com.heroes.items.enums.ArmorType;
import com.heroes.items.enums.Slot;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.HeroAttribute;
import com.heroes.rpgHeroes.classes.Ranger;
import com.heroes.rpgHeroes.classes.Rogue;

public class App {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // while (true)
        // Game.startGame(in);
        try {
            Weapon wand = new Weapon("testWand", 1, WeaponType.Dagger, 3);
            Rogue ranger = new Rogue("ranger");
            Armor bigDamageImpactArmor = new Armor("", 1, ArmorType.Leather, new HeroAttribute(0, 100, 0), Slot.Body);
            ranger.display();
            System.out.println(ranger.damage());
            ranger.equip(wand);
            ranger.equip(bigDamageImpactArmor);
            System.out.println(ranger.damage());
            System.out.println(ranger.totalAttributes());
            ranger.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
