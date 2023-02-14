package com.heroes;

import java.util.Scanner;

import com.heroes.game.Game;

/**
 * 
 */
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true)
            Game.startGame(in);
    }
}
