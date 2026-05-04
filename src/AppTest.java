import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void testApp() {
		String teste = new String();
		String resultado = "<form>" + "\n\t<label for='email'>email:</label>"
				+ "\n\t<input name='Email' type='text' value='tia@gmail.com'/><br>"
				+ "\n\t<label for='age'>age:</label>" + "\n\t<input name='Age' type='number' value='16'/><br>"
				+ "\n\t<label for='username'>username:</label>"
				+ "\n\t<input name='Username' type='text' value='tia'/><br>" + "\n</form>"
				+ "\n{'email':'tia@gmail.com','age':'16','username':'tia'}";

		UsernameForm form = new UsernameForm();
		form.get("username").setData("tia");
		form.get("email").setData("tia@gmail.com");
		form.get("age").setData(16);
		form.validate();
		for (String err : form.getErrors())

			teste += err;

		teste += form.content();

		teste += "\n" + form.json();
		assertEquals(teste, resultado);

	}

	@Test
	void testClient2() {
		String teste = new String();
		String resultado = "value empty" + "value not in range" + "less than min" + "<form>"
				+ "\n\t<label for='email'>email:</label>" + "\n\t<input name='Email' type='text' value=''/><br>"
				+ "\n\t<label for='age'>age:</label>" + "\n\t<input name='Age' type='number' value='13'/><br>"
				+ "\n\t<label for='username'>username:</label>"
				+ "\n\t<input name='Username' type='text' value='ti'/><br>" + "\n</form>"
				+ "\n{'email':'','age':'13','username':'ti'}";

		UsernameForm form = new UsernameForm();
		form.get("username").setData("ti");
		form.get("email").setData("");
		form.get("age").setData(13);
		form.validate();
		for (String err : form.getErrors())

			teste += err;
		teste += form.content();
		teste += "\n" + form.json();

		assertEquals(teste, resultado);

	}
}
