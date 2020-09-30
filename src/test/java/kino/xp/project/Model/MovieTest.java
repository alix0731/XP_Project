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
        Movie test = new Movie(1, "Tenet", 118, 1, "Action", "Robert Pattinson, Michael Caine", "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/tenet2020.ar_509x.jpg?v=1578062934");
        //assertTrue(test.getId() == 1);
        assertEquals("Tenet", test.getTitle());
        assertEquals(118, test.getDuration());
        assertEquals(1, test.getPrice_rank());
        assertEquals("Action", test.getGenre());
        assertEquals("Robert Pattinson, Michael Caine", test.getActors());
    }


}