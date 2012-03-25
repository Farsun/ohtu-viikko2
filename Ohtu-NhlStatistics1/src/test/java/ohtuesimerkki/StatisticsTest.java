/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        Player player = stats.search("Semenko");
        assertEquals(player.toString(), "Semenko              EDM  4 + 12 = 16");
    }

    @Test
    public void searchNull() {
        Player player = stats.search("Paddy");
        assertEquals(player, null);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        ArrayList<Player> team = (ArrayList<Player>) stats.team("PIT");
        assertEquals(stats.search("Lemieux"), team.get(0));
        assertEquals(team.size(), 1);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        ArrayList<Player> scores = (ArrayList<Player>) stats.topScorers(4);
        assertEquals(scores.get(0).getName(), "Gretzky");
        assertEquals(scores.get(1).getName(), "Lemieux");
        assertEquals(scores.get(2).getName(), "Yzerman");
        assertEquals(scores.get(3).getName(), "Kurri");
        assertEquals(scores.get(4).getName(), "Semenko");
    }
}
