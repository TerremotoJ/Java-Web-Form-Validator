import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequiredTest {

	@Test
	void testIsValid() {
		StringField field = new StringField("Nome", new Validator[] { new Required() });

		field.setData("");
		field.validate();
		assertFalse(field.isValid());
	}

	@Test
	void testGetErrorMessage() {
		StringField field = new StringField("Nome", new Validator[] { new Required() });

		field.setData("");
		field.validate();
		assertFalse(field.isValid());
		assertEquals(field.getErrorMessage(), "value empty");
	}

}
