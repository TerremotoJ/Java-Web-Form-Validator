class NumberRange implements Validator {
	private int min;
	private int max;
	private int number;

	public NumberRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean isValid(Object data) {
		if (data == null) {
			return false;
		}
		try {
			number = (int) data;
			return number >= min && number <= max;
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String getErrorMessage() {

		return "value not in range";
	}

}
