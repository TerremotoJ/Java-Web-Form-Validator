class Required implements Validator {
	private String temp;

	@Override
	public boolean isValid(Object data) {

		try {
			temp = (String) data;
			return !temp.isEmpty();
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String getErrorMessage() {
		return "value empty";
	}
}
