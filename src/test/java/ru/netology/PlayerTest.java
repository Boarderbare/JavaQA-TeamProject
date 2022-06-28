package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  public void shouldSumGenreIfOneGame() {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    
    Player player = new Player("Petya");
    player.installGame(game);
    player.play(game, 3);
    
    int expected = 3;
    int actual = player.sumGenre(game.getGenre());
    assertEquals(expected, actual);
  }
  
  @Test
  public void shouldInstallGame() {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Player player = new Player("Ivan");
    player.installGame(game);
    player.play(game, 2);
    player.installGame(game);
    
    assertEquals(2, player.sumGenre("Аркады"));
  }
  
  @Test
  public void shouldDoNothingIfGameAlreadyInstalled() {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Player player = new Player("Ivan");
    player.installGame(game);
    
    player.play(game, 2);
    player.installGame(game);
    
    int expected = 2;
    int actual = player.sumGenre("Аркады");
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void shouldSumPlayTimeByGenre() {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Last of Us 2", "Экшен");
    Game game2 = store.publishGame("GTA V", "Экшен");
    
    Player player = new Player("Ivan");
    player.installGame(game);
    player.play(game, 2);
    
    player.installGame(game1);
    player.play(game1, 4);
    player.play(game1, 5);
    
    player.installGame(game2);
    player.play(game2, 6);
    
    int expected = 15;
    int actual = player.sumGenre("Экшен");
    
    assertEquals(expected, actual);
    
  }
  
  @Test
  public void shouldFindMostPlayedGameForGenre() {
    GameStore store = new GameStore();
    Game game = store.publishGame("GTA V", "Экшен");
    
    Player player = new Player("Petya");
    player.installGame(game);
    player.play(game, 3);
    player.play(game, 5);
    Game game1 = store.publishGame("RDR2", "Экшен");
    player.installGame(game1);
    player.play(game1, 12);
    
    
    Game expected = game1;
    Game actual = player.mostPlayerByGenre("Экшен");
    
    assertEquals(expected, actual);   
  }
  
  @Test
  public void shouldReturnNullForNotPlayingGenre() {
    GameStore store = new GameStore();
    Game game = store.publishGame("GTA V", "Экшен");
    
    Player player = new Player("Petya");
    player.installGame(game);
    player.play(game, 3);
    
    Game actual = player.mostPlayerByGenre("Аркады");
    assertNull(actual);
  }
  
  @Test
  public void shouldThrowExceptionThenGameNotInstalled() {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Player player = new Player("Petya");
    //player.installGame(game);
    
    
    assertThrows(RuntimeException.class, () -> {
      player.play(game, 2);
    });
    
  }
  
}

