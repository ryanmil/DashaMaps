package dev.rmiller.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestWordList {

    String words = "";
    List<String> keys = new ArrayList<>();
    List<Integer> vals = new ArrayList<>();

    @Before
    public void setup() {

        File file = new File("./word-list.txt");
        try { Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                keys.add(sc.next());
                vals.add(Integer.parseInt(sc.next()));
            }
        }
        catch (Exception e) { System.out.println("Wrong File"); }
    }

    @Test
    public void testRead() {
        DashaMap map1 = new DashaMap();
        DashaMap map2 = new DashaMap(HashFuntions::hashFunctionTwo);
        DashaMap map3 = new DashaMap(HashFuntions::hashFunctionThree);

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + vals.get(i));
            map1.put(keys.get(i), vals.get(i));
            map2.put(keys.get(i), vals.get(i));
            map3.put(keys.get(i), vals.get(i));
        }
    }
}
