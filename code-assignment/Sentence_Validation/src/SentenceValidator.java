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

        int firstCharCode = (int)sentence.charAt(0);
        if((firstCharCode < 65 || firstCharCode > 90)  &&) return false;  //to ensure capital letter, or number

        return true;
    }
}
