package summary20240517;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class RegexTasksTest {

    @Test
    public void testFind() {
        int[] expected = new int[0];
        int[] result = RegexTasks.find(null, null);
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[0], new int[0]);
        assertArrayEquals(expected, result);

        result = RegexTasks.find(null, new int[]{1, 2});
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[0], new int[]{1, 2});
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1, 2}, null);
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1, 2}, new int[0]);
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1}, new int[]{2});
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1}, new int[]{1});
        expected = new int[] {1};
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1, 3, 2, 7, 9}, new int[]{-10, 2, 6, 9});
        expected = new int[] {2, 9};
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1, 3, 2, 7, 9, 2}, new int[]{-10, 2, 6, 9});
        expected = new int[] {2, 9};
        assertArrayEquals(expected, result);

        result = RegexTasks.find(new int[]{1, 3, 2, 7, 9, 2}, new int[]{9, 9, -10, 2, 6, 9});
        expected = new int[] {2, 9};
        assertArrayEquals(expected, result);

        assertTimeout(Duration.ofNanos(1), () -> RegexTasks.find(new int[]{1, 3, 2, 7, 9, 2}, new int[]{9, 9, -10, 2, 6, 9}));
    }
}
