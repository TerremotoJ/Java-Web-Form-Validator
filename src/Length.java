class Length implements Validator {
	private int min;
	private int length;

	public Length(int min) {
		this.min = min;
	}

	@Override
	public boolean isValid(Object data) {

		length = data.toString().length();
		return length >= min;
	}

	@Override
	public String getErrorMessage() {

		return "less than min";

	}
}
