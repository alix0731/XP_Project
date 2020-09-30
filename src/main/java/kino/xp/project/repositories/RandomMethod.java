package kino.xp.project.repositories;

import java.util.ArrayList;
import java.util.Random;

public class RandomMethod {
    ArrayList<Integer> arrayList = new ArrayList();

    public RandomMethod(int size)
    {
        Random r = new Random();
        int cnt = 0;
        while (cnt < size){
            arrayList.add(r.nextInt(120));
            cnt++;
        }
    }

    public ArrayList<Integer> getArrayList()
    {
        return this.arrayList;
    }

    public int getArrSize()
    {
        return this.arrayList.size();
    }
}
