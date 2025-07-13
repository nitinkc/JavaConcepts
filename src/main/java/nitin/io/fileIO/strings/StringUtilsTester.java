package nitin.io.fileIO.strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Some unit tests using the newer assertThat style. See StringUtilsTester for a variation that uses
 * the more traditional assertEquals, assertTrue, and assertFalse methods.
 */

// Note that under some Eclipse settings, Eclipse will make
// a warning that the methods can potentially be declared static.
// In this case, you should ignore the warning, since JUnit methods
// should NOT be static.

public class StringUtilsTester {
    @Test
    public void testReverse() {
        assertThat("oof", is(equalTo(StringUtils.reverseString("foo"))));
        assertThat("rab", is(equalTo(StringUtils.reverseString("bar"))));
        assertThat("!zaB", is(equalTo(StringUtils.reverseString("Baz!"))));
    }

    @Test
    public void testPalindromes() {
        String[] matches = {"a", "aba", "Aba", "abba", "AbBa", "abcdeffedcba", "abcdEffedcba"};
        String[] misMatches = {
            "ax", "axba", "Axba", "abbax", "xAbBa", "abcdeffedcdax", "axbcdEffedcda"
        };
        for (String s : matches) {
            assertThat(StringUtils.isPalindrome(s), is(true));
        }
        for (String s : misMatches) {
            assertThat(StringUtils.isPalindrome(s), is(false));
        }
    }
}
