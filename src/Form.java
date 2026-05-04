import java.util.*;

public class Form extends HashMap<String, Field> {

	public void validate() {
		for (Field field : values()) {
			field.validate();
		}
	}

	public List<String> getErrors() {
		List<String> errors = new ArrayList<String>();

		for (Field field : values()) {
			if (!field.isValid()) {
				errors.add(field.getErrorMessage());
			}
		}
		return errors;
	}

	public void printFieldErrors() {
		for (Field field : values()) {
			if (!field.isValid()) {
				System.out.println("Error: " + field.getErrorMessage());
			}
		}
	}

	public String content() {
		StringBuilder sb = new StringBuilder();

		sb.append("<form>");

		for (String key : keySet()) {
			Field field = get(key);
			sb.append("\n\t<label for='" + key + "'>" + key + ":</label>");
			sb.append("\n\t" + field.getHtml());
			sb.append("<br>");
		}
		sb.append("\n" + "</form>");
		return sb.toString();

	}

	public String json() {

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		int i = 0;
		for (String name : keySet()) {
			Field field = get(name);
			sb.append("'" + name + "'" + ":'" + field.getData() + "'");
			if (i < size() - 1) {
				sb.append(",");
			}
			i++;
		}
		sb.append("}");
		return sb.toString();
	}
}
