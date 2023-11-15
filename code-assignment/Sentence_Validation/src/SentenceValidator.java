public class SentenceValidator {


    // ----------------------------------------------------------
    /**
     * Determines whether a sentence is valid according to assignment rules
     *
     * @param sentence: The sentence to be validated
     *
     * @return true if the sentence is valid, false otherwise
     *
     */
    public boolean validate(String sentence){
        if(sentence.length() < 2) return false;  //to ensure sentences have one letter, and one punctuation mark

        //ensure capital letter or number for first char
        int firstCharCode = (int)sentence.charAt(0);
        if((firstCharCode < 65 || firstCharCode > 90)  && (firstCharCode < 48 || firstCharCode > 57)) return false;

        //ensure correct sentence termination
        char lastChar = sentence.charAt(sentence.length() - 1);
        if(lastChar != '.' && lastChar != '?' && lastChar != '!') return false;

        int quotesCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            //ensure no more than 1 '.' char
            if(currentChar == '.' && i != sentence.length() -1) return false;

            if(currentChar == '"') quotesCount++;

        }

        //ensure even amount of quotes
        if(quotesCount % 2 == 1) return false;
        return true;
    }


    //main method for convenient testing purposes
    public static void main(String[] args) {
        SentenceValidator validator = new SentenceValidator();
        System.out.println(validator.validate("BAA"));
    }
}
