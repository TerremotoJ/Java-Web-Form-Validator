import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberFieldTest {

	@Test
	void testValidate() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(20);
		field.validate();
		assertTrue(field.isValid());

	}

	@Test 
	void testValidate2() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(10);
		field.validate();
		assertFalse(field.isValid());
		assertEquals("value not in range", field.getErrorMessage());
		;
	}

	@Test 
	void testValidate3() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(null);
		field.validate();
		assertFalse(field.isValid());
		assertEquals("value not in range", field.getErrorMessage());
	}

	@Test
	void testGetHtml() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(20);
		String html = field.getHtml();
		assertEquals("<input name='Age' type='number' value='20'/>", html);
	}

	@Test
	void testNumberField() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(20);
		assertEquals(field.getData(), 20);

	}

	@Test
	void testGetErrorMessage() {
		NumberField field = new NumberField("Age", new Validator[] { new NumberRange(16, 99) });
		field.setData(10);
		field.validate();
		assertEquals("value not in range", field.getErrorMessage());
		;
	}

}
