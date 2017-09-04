package zophop;

import org.junit.Test;

import static java.util.Collections.list;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RescueOpsTest {
    private RescueOps test = new RescueOps();

    @Test
    public void directionWest() {
        assertThat(test.shortPath(1, 0), hasItems("60"));
        assertThat(test.shortPath(-1, 0), hasItems("80"));
    }

    @Test
    public void directionEest() {
        assertThat(test.shortPath(0, 1), hasItems("50"));
        assertThat(test.shortPath(0, -1), hasItems("70"));
    }

    @Test
    public void directionDiagonal() {
        assertThat(test.shortPath(1, 1), hasItems("10"));

        assertThat(test.shortPath(2, 2), hasItems("10"));
        assertThat(test.shortPath(-2, -2), hasItems("30"));
    }

    @Test
    public void directionMix() {
        assertThat(test.shortPath(1, 2), hasItems("[1][5][0]"));
        assertThat(test.shortPath(1, -2), hasItems("[2][7][0]"));
        assertThat(test.shortPath(-1, -2), hasItems("[3][7][0]"));
        assertThat(test.shortPath(-1, 2), hasItems("[4][5][0]"));
    }


}
