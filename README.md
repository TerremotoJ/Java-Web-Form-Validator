# Java Web Form Validator

An exercise for a university object-oriented programming course. It models a web form as plain Java objects: each field holds a value and a list of validators, the form validates every field, and it prints itself as an HTML `<form>` string and a JSON-style string. It is a console program; there is no web server.

## Classes

- `Form` extends `HashMap<String, Field>`. `validate()` validates every field, `getErrors()` returns the error messages of the fields that failed, `printFieldErrors()` prints them, `content()` returns the HTML string and `json()` returns the JSON-style string.
- `Field` is the abstract base class: it stores the value (`setData` / `getData`), the validation result and the error message, and declares `validate()` and `getHtml()`.
- `StringField` and `NumberField` extend `Field`. Each takes an array of validators, runs them in order and keeps the message of the first one that fails. `getHtml()` returns an `<input>` of type `text` or `number`.
- `Validator` is the interface the rules implement: `isValid(Object data)` and `getErrorMessage()`.
- `Required` (the value is a non-empty string), `Length(min)` (the value has at least `min` characters) and `NumberRange(min, max)` (the value is an integer from `min` to `max`, inclusive) are the three validators.
- `UsernameForm` is a sample form with three fields: `username` (`Length(3)`), `email` (`Required`) and `age` (`NumberRange(16, 99)`).
- `App` and `App2` fill in a `UsernameForm` with fixed values, validate it, and print the errors, the HTML and the JSON-style string.

## Build and run

Needs a JDK (tested with JDK 25 on macOS). Run these from the repository root. The JUnit 5 console runner is in `lib/`, and the compiled classes go to `bin/`.

```bash
javac -d bin -cp lib/junit-platform-console-standalone-1.9.2.jar src/*.java
java -cp bin App
java -cp bin App2
```

`App` uses valid values, so it prints no errors:

```
<form>
	<label for='email'>email:</label>
	<input name='Email' type='text' value='tia@gmail.com'/><br>
	<label for='age'>age:</label>
	<input name='Age' type='number' value='16'/><br>
	<label for='username'>username:</label>
	<input name='Username' type='text' value='tia'/><br>
</form>
{'email':'tia@gmail.com','age':'16','username':'tia'}
```

`App2` uses an empty email, age 13 and a two-letter username, so all three fields fail:

```
value empty
value not in range
less than min
<form>
	<label for='email'>email:</label>
	<input name='Email' type='text' value=''/><br>
	<label for='age'>age:</label>
	<input name='Age' type='number' value='13'/><br>
	<label for='username'>username:</label>
	<input name='Username' type='text' value='ti'/><br>
</form>
{'email':'','age':'13','username':'ti'}
```

## Tests

20 JUnit 5 tests in 5 classes (`AppTest`, `UsernameFormTest`, `StringFieldTest`, `NumberFieldTest`, `RequiredTest`). They check the full output of both sample programs, the HTML and JSON-style output of the sample form, `Length` passing and failing, `NumberRange` in range, out of range and with no value, and `Required` on an empty string.

After compiling as above:

```bash
java -jar lib/junit-platform-console-standalone-1.9.2.jar --class-path bin --scan-class-path
```

The summary ends with `20 tests successful` and `0 tests failed`.

## Limitations

- Values go into the HTML and the JSON-style string without escaping, so a value containing `'` breaks out of the `value='...'` attribute.
- The JSON-style output uses single quotes, so it is not valid JSON.
- Fields come out in `HashMap` order (email, age, username), not in the order they were added, and the tests depend on that order.
- Error messages do not name the field that failed.
- `Required` and `Length` throw a `NullPointerException` if a field's value was never set.
- Every field in the sample form has a single validator, so running several validators on one field is not tested.
- The test for `printFieldErrors()` does not check what it prints.
