public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> letters = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++){
            letters.addLast(word.charAt(i));
        }
        return letters;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque1 = wordToDeque(word);
        while(wordDeque1.size() > 1) {
            if (wordDeque1.removeFirst() != wordDeque1.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordDeque2 = wordToDeque(word);
        while(wordDeque2.size() > 1){
            if(!cc.equalChars(wordDeque2.removeFirst(), wordDeque2.removeLast())){
                return false;
            }
        }
        return true;
    }
}
