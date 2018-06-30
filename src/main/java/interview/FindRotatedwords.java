package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * problem statement ['Tokyo', 'London', 'Rome', 'Donlon', 'Kyoto', 'Paris']
 * 
 * should return [ [ 'Tokyo', 'Kyoto' ], [ 'London', 'Donlon' ], [ 'Rome' ], [
 * 'Paris' ] ]
 * 
 * If you rotate the letters of each city you may or may not match another city.
 * In case you do, put them together in a array on their own.
 *
 *
 */
public class FindRotatedwords {

	public static void main(String[] args) {
			Map<String, List<String>> results = findtheMatchedRotatedOnes(
				new String[] { "Tokyo", "London", "Rome", "Donlon", "Kyoto", "Paris", "yotok", "mero" });

		System.out.println(results);

	}

	private static Map<String, List<String>> findtheMatchedRotatedOnes(String[] input) {

		Map<String, String> doneList = new HashMap<String, String>();
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();

		for (int counter = 0; counter < input.length; counter++) {
			if (!doneList.containsKey(counter + "")) {
				String x = input[counter];
				for (int i = counter + 1; i < input.length; i++)

				{
					if (!doneList.containsKey(i + "")) {
						if (input[i].length() == x.length()) // hey lengths are matching
						{
							// check the chars if they are matching
							if (charsAreSame(input[i], x)) {
								// now see the sequence
								if (charsAreinRotatedSeq(input[i], x)) {
									List<String> temp = null;
									if (resultMap.containsKey(counter + "")) {
										temp = resultMap.get(counter + "");
										temp.add(input[i]);

									} else {
										temp = new ArrayList<String>();
										temp.add(x);
										temp.add(input[i]);
									}
									resultMap.put(counter + "", temp);
									doneList.put(i + "", i + "");
								}

							}
						}
					}
				}
			}
		}
		return resultMap;
	}

	private static boolean charsAreinRotatedSeq(String cmp, String base) {
		String concat = base.toLowerCase() + base.toLowerCase();
		if (concat.contains(cmp.toLowerCase())) {
			return true;
		}
		return false;
	}

	private static boolean charsAreSame(String firstStr, String secondStr) {
		char[] first = firstStr.toLowerCase().toCharArray();
		char[] second = secondStr.toLowerCase().toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}
}
