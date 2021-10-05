package utils;

import java.util.Arrays;

public class FunctionHelper {
	public static String convertArrayToString(String[] arr) {
		String result = "";
		if (arr != null && arr.length != 0) {
			result = Arrays.stream(arr).reduce((a, b) -> a.concat(",").concat(b)).get();
		}
		return result;
	}
}
