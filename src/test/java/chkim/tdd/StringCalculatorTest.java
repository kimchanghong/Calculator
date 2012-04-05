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
	public void ��_���ڿ���_�Է���_���0��_��ȯ() throws Exception {
		int result = stringCalculator.add("");
		assertThat(result, is(0));
	}
	
	@Test
	public void �����ϳ������ڿ����Է��Ұ���ش���ڸ���ȯ() throws Exception {
		int result = stringCalculator.add("7");
		assertThat(result, is(7));
	}
	
	@Test
	public void ���ڵΰ����ĸ��α����ڷ��Է��Ұ��μ�����������ȯ() throws Exception {
		int result = stringCalculator.add("1,4");
		assertThat(result, is(5));
	}
	
	@Test
	public void �������ĸ��̿ܿ�NewLine����밡��() throws Exception {
		int result = stringCalculator.add("1,4\n6");
		assertThat(result, is(11));
	}
	
	@Test
	public void �����õΰ����̿���Ŀ���ı����ڸ������Ҽ��ִ�() throws Exception {
		int result = stringCalculator.add("//;\n1;4;6");
		assertThat(result, is(11));
	}
	
	
	@Test
	public void ����ǥ���Ŀ��������ڷλ���Ҽ��ִ�() throws Exception {
		int result = stringCalculator.add("//.\n1.4.6");
		assertThat(result, is(11));
	}
	
	@Test
	public void ���������Ұ��RuntimeException�߻�()  {
		try{
			stringCalculator.add("-1,2,3");
			
		}catch (RuntimeException e) {
			logger.debug("���ܹ߻� ");
			assertThat(e, is(RuntimeException.class));
		}
		
	}
	

}
