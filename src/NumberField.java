import java.util.Arrays;

import java.util.List;

class NumberField extends Field {

	private List<Validator> validators;

	public NumberField(String name, Validator[] validators) {
		this.name = name;
		this.validators = Arrays.asList(validators);
	}

	@Override
	public void validate() {
		isValid = true;
		for (Validator validator : validators) {
			if (!validator.isValid(data)) {
				isValid = false;
				errorMessage = validator.getErrorMessage();
				break;
			}
		}
	}

	@Override
	public String getHtml() {
		return "<input name='" + name + "' type='number' value='" + data + "'/>";
	}
}
