package in.suryaumapathy.projects.collage_admission.utils;

import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isValidString(String stringInput) {

		if (stringInput == null) {
			return false;
		}

		if ("".equals(stringInput.trim())) {
			return false;
		}

		return true;

	}

	public static boolean isValidEmail(String emailInput) {

		if (!StringUtil.isValidString(emailInput)) {
			return false;
		}

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean isMatch = Pattern.matches(regex, emailInput);

		return isMatch;
	}

}
