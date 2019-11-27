package dev.rmiller.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DashaMapTest {

    private DashaMap theMap;

    @Before
    public void setup() {
        theMap = new DashaMap();
    }

    @Test
    public void put() {
        theMap.put("yep", 1);
        theMap.put("yes", 4);
        theMap.put("aye", -12);
    }

    @Test
    public void get() {
        theMap.put("yep", 1);
        theMap.put("yes", 4);
        theMap.put("aye", -12);

        Assert.assertEquals(1, theMap.get("yep").intValue());
        Assert.assertEquals(4, theMap.get("yes").intValue());
        Assert.assertEquals(-12, theMap.get("aye").intValue());
    }

    @Test
    public void delete() {

        theMap.put("yep", 1);
        theMap.put("yes", 4);
        theMap.put("aye", -12);

        Assert.assertFalse(theMap.delete("nope"));
        Assert.assertTrue(theMap.delete("yes"));
        Assert.assertTrue(theMap.delete("yep"));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, theMap.size());

        theMap.put("yep", 1);
        theMap.put("yes", 4);
        theMap.put("aye", -12);

        Assert.assertEquals(3, theMap.size());

        theMap.put("boi", 20);

        Assert.assertEquals(4, theMap.size());

        theMap.delete("yes");

        Assert.assertEquals(3, theMap.size());
    }
}