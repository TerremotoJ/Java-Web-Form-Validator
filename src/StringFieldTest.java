import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringFieldTest {

	@Test
	void testValidate() {
		StringField field = new StringField("Nome", new Validator[] { new Length(3) });

		field.setData("teste");
		field.validate();
		assertTrue(field.isValid());
	}

	@Test 
	void testValidate2() {
		StringField field = new StringField("Nome", new Validator[] { new Length(10) });

		field.setData("teste");
		field.validate();
		assertFalse(field.isValid());
		assertEquals("less than min", field.getErrorMessage());
	}

	@Test
	void testGetHtml() {
		StringField field = new StringField("test", new Validator[] { new Length(3) });
		field.setData("teste");
		assertEquals(field.getHtml(), "<input name='test' type='text' value='teste'/>");
	}

	@Test 
	void testStringField() {
		StringField field = new StringField("test", new Validator[] { new Length(3) });
		field.setData("teste");
		assertEquals(field.getData(), "teste");
	}

	@Test
	void testGetErrorMessage() {
		StringField field = new StringField("Nome", new Validator[] { new Length(10) });

		field.setData("teste");
		field.validate();
		assertFalse(field.isValid());
		assertEquals("less than min", field.getErrorMessage());
		;
	}

}
