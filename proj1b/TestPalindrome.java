import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String word0 = "";
        String word1 = "a";
        String word2 = "noon";
        String word3 = "racecar";
        String word4 = "persiflage";

        assertTrue(palindrome.isPalindrome(word0));
        assertTrue(palindrome.isPalindrome(word1));
        assertTrue(palindrome.isPalindrome(word2));
        assertTrue(palindrome.isPalindrome(word3));
        assertFalse(palindrome.isPalindrome(word4));
    }


    @Test
    public void testIsPalindromeOffByOne(){
        CharacterComparator offByOne = new OffByOne();
        String word0 = "";
        String word1 = "a";
        String word2 = "acdb";
        String word3 = "omnp";
        String word4 = "abcdefg";

        assertTrue(palindrome.isPalindrome(word0, offByOne));
        assertTrue(palindrome.isPalindrome(word1, offByOne));
        assertTrue(palindrome.isPalindrome(word2, offByOne));
        assertTrue(palindrome.isPalindrome(word3, offByOne));
        assertFalse(palindrome.isPalindrome(word4, offByOne));
    }

    @Test
    public void testIsPalindromeOffByN(){
        CharacterComparator offByOne = new OffByN(1);
        String word0 = "";
        String word1 = "a";
        String word2 = "acdb";
        String word3 = "omnp";
        String word4 = "abcdefg";

        assertTrue(palindrome.isPalindrome(word0, offByOne));
        assertTrue(palindrome.isPalindrome(word1, offByOne));
        assertTrue(palindrome.isPalindrome(word2, offByOne));
        assertTrue(palindrome.isPalindrome(word3, offByOne));
        assertFalse(palindrome.isPalindrome(word4, offByOne));
    }
}
