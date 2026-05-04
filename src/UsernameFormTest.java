import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsernameFormTest {

	@Test
	public void testValidate() {
		UsernameForm Usernameform = new UsernameForm();
		Usernameform.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		Usernameform.put("email", new StringField("Email", new Validator[] { new Required() }));
		Usernameform.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
		Usernameform.get("username").setData("tia");
		Usernameform.get("email").setData("tia@gmail.com");
		Usernameform.get("age").setData(16);
		Usernameform.validate();

		assertTrue(Usernameform.getErrors().isEmpty());

	}

	@Test
	public void testValidate2() {
		UsernameForm Usernameform = new UsernameForm();
		Usernameform.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		Usernameform.put("email", new StringField("Email", new Validator[] { new Required() }));
		Usernameform.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
		Usernameform.get("username").setData("ti");
		Usernameform.get("email").setData("tia@gmail.com");
		Usernameform.get("age").setData(16);
		Usernameform.validate();

		assertTrue(Usernameform.getErrors().contains("less than min"));

	}

	@Test
	void testPrintFieldErrors() {

		UsernameForm Usernameform = new UsernameForm();
		Usernameform.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		Usernameform.put("email", new StringField("Email", new Validator[] { new Required() }));
		Usernameform.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
		Usernameform.get("username").setData("ti");
		Usernameform.get("email").setData("tia@gmail.com");
		Usernameform.get("age").setData(16);
		Usernameform.validate();
		assertTrue(Usernameform.getErrors().contains("less than min"));

	}

	@Test
	void testContent() {

		String expectedContent = "<form>" + "\n\t<label for='email'>email:</label>"
				+ "\n\t<input name='email' type='text' value='tia@gmail.com'/><br>"
				+ "\n\t<label for='age'>age:</label>" + "\n\t<input name='age' type='number' value='16'/><br>"
				+ "\n\t<label for='username'>username:</label>"
				+ "\n\t<input name='username' type='text' value='tia'/><br>" + "\n</form>";

		UsernameForm Usernameform = new UsernameForm();
		Usernameform.put("username", new StringField("username", new Validator[] { new Length(3) }));
		Usernameform.put("email", new StringField("email", new Validator[] { new Required() }));
		Usernameform.put("age", new NumberField("age", new Validator[] { new NumberRange(16, 99) }));
		Usernameform.get("username").setData("tia");
		Usernameform.get("email").setData("tia@gmail.com");
		Usernameform.get("age").setData(16);
		Usernameform.validate();

		assertEquals(Usernameform.content(), expectedContent);
	}

	@Test
	void testJson() {
		UsernameForm Usernameform = new UsernameForm();
		Usernameform.put("username", new StringField("username", new Validator[] { new Length(3) }));
		Usernameform.put("email", new StringField("email", new Validator[] { new Required() }));
		Usernameform.put("age", new NumberField("age", new Validator[] { new NumberRange(16, 99) }));
		Usernameform.get("username").setData("tia");
		Usernameform.get("email").setData("tia@gmail.com");
		Usernameform.get("age").setData(16);
		Usernameform.validate();
		assertEquals(Usernameform.json(), "{'email':'tia@gmail.com','age':'16','username':'tia'}");
	}

}
