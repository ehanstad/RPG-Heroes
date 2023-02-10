package com.heroes;

import java.io.IOException;
import java.util.Scanner;

import com.heroes.items.Weapon;
import com.heroes.items.enums.WeaponType;
import com.heroes.rpgHeroes.Hero;
import com.heroes.rpgHeroes.classes.Mage;
import com.heroes.rpgHeroes.classes.Ranger;
import com.heroes.rpgHeroes.classes.Rogue;
import com.heroes.rpgHeroes.classes.Warrior;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true)
            startGame(in);
    }

    private static void startGame(Scanner in) {
        System.out.println("CHOSE YOUR CLASS");
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
        startAdventure(hero, in);
    }

    private static void createRogue(Scanner in) {
        System.out.println("SET A NAME FOR YOUR NEW ROGUE");
        String name = in.nextLine();
        Rogue hero = new Rogue(name);
        startAdventure(hero, in);
    }

    private static void createRanger(Scanner in) {
        System.out.println("SET A NAME FOR YOUR NEW RANGER");
        String name = in.nextLine();
        Ranger hero = new Ranger(name);
        startAdventure(hero, in);
    }

    private static void createMage(Scanner in) {
        System.out.println("SET A NAME FOR YOUR NEW MAGE");
        String name = in.nextLine();
        Mage hero = new Mage(name);
        startAdventure(hero, in);
    }

    private static void startAdventure(Hero hero, Scanner in) {
        while (true) {
            clearScreen();
            System.out.println("\n------------------------------------------------------\n");
            System.out
                    .println("Your adventure starts far out in the deep forest of Tailwoods your hero " + hero.getName()
                            + " is alone and cold and as no idea what lurks in this uninviting environment.");
            System.out.println("\n------------------------------------------------------\n");
            System.out.println("You have some different choses to do:");
            System.out.println(
                    "w = travel north\ta = travel west\td = travel east\ts = travel south\nl = view your hero");
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
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void travelSouth(Hero hero, Scanner in) {
        clearScreen();
        int villianHp = 3;
        System.out.println("\n------------------------------------------------------\n");
        System.out.println(
                "As your hero travel south a strange sight catches your hero's eye. A what seems to be a human sized duck approaches him. It's intentions seems friendly...");
        System.out.println(
                "At FIRST. For as your hero gets closer it becomes clear that this duck has some real nasty intensions. He holds a small knife and his eyebrows are in V-shape");
        System.out.println("\n------------------------------------------------------\n");

        while (true) {
            System.out.println("attack = a\trun away = r\tduck's hp: " + villianHp);
            switch (in.nextLine()) {
                case "a":
                    System.out.println("You damage " + hero.damage() + " attacks");
                    villianHp -= hero.damage();
                    break;
                case "r":

                    break;
                default:
                    break;
            }
        }
    }

    private static void travelEast(Hero hero, Scanner in) {
    }

    private static void travelWest(Hero hero, Scanner in) {
    }

    private static void travelNorth(Hero hero, Scanner in) {
    }
}
