package kino.xp.project.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter
 * @Output test af Movie-model
**/
class MovieTest {
    @Test
    public void canCreateMovie() {
        Movie test = new Movie(1, "Tenet", 118, 1, "Flot film", "Robert Pattinson, Michael Caine");
        //assertTrue(test.getId() == 1);
        assertEquals("Tenet", test.getTitle());
        assertEquals(118, test.getDuration());
        assertEquals(1, test.getPriceRank());
        assertEquals("Action", test.getGenre());
        assertEquals("Robert Pattinson, Michael Caine", test.getActors());
    }
}