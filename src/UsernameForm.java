class UsernameForm extends Form {
	UsernameForm() {
		super();
		this.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		this.put("email", new StringField("Email", new Validator[] { new Required() }));
		this.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
	}
}
