package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameStoreTest {

    private GameStore store = new GameStore();

//  наверно можно удалить так как он дублируется
//    @Test
//    public void shouldAddGame() {
//
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//        assertTrue(store.containsGame(game));
//    }

    @Test
    public void shouldContainsGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldNotContainsGame() {
        GameStore store1 = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = new Game("GTA V", "Экшен", store1);
        assertFalse(store.containsGame(game1));
    }

    @Test
    public void shouldAddPlayTime() {

        store.addPlayTime("Vasya", 5);
        store.addPlayTime("Petya", 4);

        String expected = "Vasya";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayTimeSum() {

        store.addPlayTime("Vasya", 3);
        store.addPlayTime("Petya", 4);
        store.addPlayTime("Vasya", 5);
        String expected = "Vasya";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayer() {

        store.addPlayTime("Vasya", 3);
        store.addPlayTime("Petya", 4);
        store.addPlayTime("Vasya", 5);
        String expected = "Vasya";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNoGetMostPlayer() {
        String actual = store.getMostPlayer();
        assertNull(actual);
    }

    @Test
    void getSumPlayedTime() {
        store.addPlayTime("Vasya", 3);
        store.addPlayTime("Petya", 0);
        store.addPlayTime("Vanya", 20);
        int actual = store.getSumPlayedTime();
        int expected = 23;
        assertEquals(expected, actual);
    }
}
