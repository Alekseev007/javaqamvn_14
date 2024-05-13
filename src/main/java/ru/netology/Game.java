package ru.netology;

import java.util.Comparator;

public class Game {
    private Player[] players = new Player[0];


    private Player[] register(Player[] current, Player player) {

        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = player;
        return tmp;
    }


    public void add(Player player) {
        players = register(players, player);
    }


    public Player[] findAll() {
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.name.contains(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName1 + " not found"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName2 + " not found"
            );
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 0;
    }


}
