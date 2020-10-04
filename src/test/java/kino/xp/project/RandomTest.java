package kino.xp.project;

import kino.xp.project.repositories.RandomMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Author Jonas, Jonathan
 * @Parameter Test af metoder relateret til Random
 * @Output det er en test så ikke rigtig noget
 **/
public class RandomTest {

    @Test
    public void contructTest()
    {
        RandomMethod rm10 = new RandomMethod(10);

        Assertions.assertTrue(rm10.getArrSize() == 10);
        Assertions.assertTrue(getAssertArray(rm10.getArrayList()));
        Assertions.assertFalse(rm10.getArrSize() == 20);
    }

    public boolean getAssertArray(ArrayList<Integer> arr)
    {
        boolean below120 = true;
        for (Integer i :  arr) {
            if (i >= 120){
                below120 = false;
            }
        }
        return below120;
    }
}
