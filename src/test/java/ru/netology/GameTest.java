package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Player player = new Player(1, "Маша", 90);
    Player player1 = new Player(2, "Петя", 50);
    Player player2 = new Player(3, "Коля", 70);
    Player player3 = new Player(4, "Саша", 50);
    Player player4 = new Player(5, "Иван", 100);

    @Test
    public void roundTest() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        int expected = 0;
        int actual = game.round("Петя", "Саша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest2() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        int expected = 1;
        int actual = game.round("Иван", "Маша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest3() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        int expected = 2;
        int actual = game.round("Маша", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest4() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Оля", "Петя");
        });
    }

    @Test
    public void roundTest5() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Яша");
        });
    }

    @Test
    public void findAllTest() {
        Game game = new Game();

        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        Player[] expected = {player, player1, player2, player3, player4};
        Player[] actual = game.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}