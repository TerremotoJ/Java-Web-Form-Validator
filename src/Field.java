abstract class Field {

	protected Object data;
	protected String name;

	protected boolean isValid;

	protected String errorMessage;

	public abstract void validate();

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public boolean isValid() {
		return isValid;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public abstract String getHtml();

}
