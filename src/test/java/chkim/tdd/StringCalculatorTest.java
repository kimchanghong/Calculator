package chkim.tdd;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringCalculatorTest {

	
	private static final Logger logger = LoggerFactory
			.getLogger(StringCalculatorTest.class);
	private StringCalculator stringCalculator;
	
	@Before
	public void setup(){
		stringCalculator = new StringCalculator();
	}
	

	@Test
	public void 빈_문자열을_입력할_경우0을_반환() throws Exception {
		int result = stringCalculator.add("");
		assertThat(result, is(0));
	}
	
	@Test
	public void 숫자하나를문자열로입력할경우해당숫자를반환() throws Exception {
		int result = stringCalculator.add("7");
		assertThat(result, is(7));
	}
	
	@Test
	public void 숫자두개를컴마로구분자로입력할경우두숫자의합을반환() throws Exception {
		int result = stringCalculator.add("1,4");
		assertThat(result, is(5));
	}
	
	@Test
	public void 구분자컴마이외에NewLine을사용가능() throws Exception {
		int result = stringCalculator.add("1,4\n6");
		assertThat(result, is(11));
	}
	
	@Test
	public void 슬래시두개를이용해커스컴구분자를지정할수있다() throws Exception {
		int result = stringCalculator.add("//;\n1;4;6");
		assertThat(result, is(11));
	}
	
	
	@Test
	public void 정규표현식예약어도구분자로사용할수있다() throws Exception {
		int result = stringCalculator.add("//.\n1.4.6");
		assertThat(result, is(11));
	}
	
	@Test
	public void 음수전달할경우RuntimeException발생()  {
		try{
			stringCalculator.add("-1,2,3");
			
		}catch (RuntimeException e) {
			logger.debug("예외발생 ");
			assertThat(e, is(RuntimeException.class));
		}
		
	}
	

}
