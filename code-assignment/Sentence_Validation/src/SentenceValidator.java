public class SentenceValidator {

    private int countChar(String word, char c) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) count++;
        }
        return count;
    }

    private boolean isValidNumber(String num){
        if(num.length() == 1){
            return false;
        }
        else{
            if(num.charAt(0) == '1') {
                switch (num.charAt(1)){
                    case '1':
                    case '2':
                        return false;
                }
            }
        }
        return true;
    }


    /**
     * Determines whether a sentence is valid according to assignment rules
     *
     * @param sentence: The sentence to be validated
     *
     * @return True if the sentence is valid, false otherwise
     *
     */
    public boolean validate(String sentence){
        if(sentence.length() < 2) return false;  //to ensure sentences have one letter, and one punctuation mark

        //ensure capital letter or number for first char (using ASCII codes for efficiency)
        int firstCharCode = (int)sentence.charAt(0);
        if((firstCharCode < 65 || firstCharCode > 90)  && (firstCharCode < 48 || firstCharCode > 57)) return false;

        //ensure correct sentence termination
        char lastChar = sentence.charAt(sentence.length() - 1);
        if(lastChar != '.' && lastChar != '?' && lastChar != '!') return false;

        int quotesCount = 0;
        String words[] = sentence.split(" ");  //java method, O(n) time, n = string length
        for (int i = 0; i < words.length; i++) {
                ;
                //ensure no more than 1 '.' char
                int stopCount = countChar(words[i], '.');
                if((i == words.length -1 && stopCount != 1) || (i != words.length -1 && stopCount > 0)) return false;

                //count quotes
                quotesCount += countChar(words[i], '"');

                //to handle numbers
                String wordCopy = words[i];
                wordCopy = wordCopy.replace("\"", "");
                wordCopy = wordCopy.replace(",", "");
                wordCopy = wordCopy.replace(".", "");
                if(wordCopy.length() >= 1 && (wordCopy.charAt(0) >= 48 || wordCopy.charAt(0) <= 57) && !isValidNumber(wordCopy)) return false;

        }

        //ensure even amount of quotes
        if(quotesCount % 2 == 1) return false;
        return true;
    }


    //main method for convenient testing purposes
    public static void main(String[] args) {
        SentenceValidator validator = new SentenceValidator();
        System.out.println(validator.validate("Hello my name is \"Declan\", hi!, I'm 21."));
        System.out.println(validator.validate("Hello my name is \"Declan\", hi!, I'm \"21\"."));
    }
}
