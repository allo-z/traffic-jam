package com.zuehlke.hamilton;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrafficJamTest {

    private final TrafficJam sut = new TrafficJam();

    @Test
    public void giveway() {
        assertEquals("abcCdCeCECX", sut.trafficJam("abcdeXghi", new String[]{"","","CCCCC","","EEEEEEEEEE","FFFFFF","","","IIIIII"}));
    }

    @Test
    public void noSideStreets() {
        assertEquals("abcdefX", sut.trafficJam("abcdefX", new String[0]));
        assertEquals("abcX", sut.trafficJam("abcXdef", new String[0]));
        assertEquals("X", sut.trafficJam("Xabcdef", new String[0]));
    }

    @Test
    public void example() {
        assertEquals("abcdBeBfBgBhBiBCjCkClCmCX", sut.trafficJam("abcdefghijklmX", new String[]{"","","","BBBBBB","","","","","CCCCC"}));
    }

}
