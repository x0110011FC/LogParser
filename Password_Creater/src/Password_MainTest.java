import static org.junit.Assert.*;

import org.junit.Test;

public class Password_MainTest {

	@Test
	public void testRandomChar() {
		Password_Main tester = new Password_Main();
		char[] txt = Password_Main.randomChar(tester.getLetters(), tester.getKeyword(), 15);
		assertEquals("Expected 15", 15, txt.length);
		
		
	}

}