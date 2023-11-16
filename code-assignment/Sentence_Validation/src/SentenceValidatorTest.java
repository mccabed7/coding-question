import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceValidatorTest {

    @Test
    public void validTest1() {
        SentenceValidator validator = new SentenceValidator();
        assertTrue("Testing valid: The quick brown fox said “hello Mr lazy dog”.", validator.validate("The quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    public void validTest2() {
        SentenceValidator validator = new SentenceValidator();
        assertTrue("Testing valid: The quick brown fox said hello Mr lazy dog.", validator.validate("The quick brown fox said hello Mr lazy dog."));
    }

    @Test
    public void validTest3() {
        SentenceValidator validator = new SentenceValidator();
        assertTrue("Testing valid: One lazy dog is too few, 13 is too many.", validator.validate("One lazy dog is too few, 13 is too many."));
    }

    @Test
    public void validTest4() {
        SentenceValidator validator = new SentenceValidator();
        assertTrue("Testing valid: One lazy dog is too few, thirteen is too many.", validator.validate("One lazy dog is too few, thirteen is too many."));
    }

    @Test
    public void invalidTest1FullStop(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: The quick brown fox said \"hello Mr. lazy dog\".", validator.validate("The quick brown fox said \"hello Mr. lazy dog\"."));
    }

    @Test
    public void invalidTest2CapitalLetter(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: the quick brown fox said \"hello Mr lazy dog\".", validator.validate("the quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    public void invalidTest3Quote(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: \"The quick brown fox said “hello Mr lazy dog.\"", validator.validate("\"The quick brown fox said “hello Mr lazy dog.\""));
    }

    @Test
    public void invalidTest4Number(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: One lazy dog is too few, 12 is too many.", validator.validate("One lazy dog is too few, 12 is too many."));
    }

    @Test
    public void invalidTest5Number(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: Are there 11, 12, or 13 lazy dogs?", validator.validate("Are there 11, 12, or 13 lazy dogs?"));
    }
    @Test
    public void invalidTest6FullStop(){
        SentenceValidator validator = new SentenceValidator();
        assertFalse("Testing invalid: There is no punctuation in this sentence", validator.validate("There is no punctuation in this sentence"));
    }

}