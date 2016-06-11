package bigram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {

		// input
		String input = "abbcceeeeeeabcc";
		// check string
		String check = "ja";

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < input.length() - 1; i++) {
			String bigram = input.substring(i, i + 2);

			if (map.containsKey(bigram)) {
				map.put(bigram, map.get(bigram) + 1);
			} else {
				map.put(bigram, 1);
			}
		}

		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// check next character
		for (int i = 0; i < 3; i++) {
			int maxFrequency = 0;
			String maxFrequencyBigram = "";

			for (Map.Entry<String, Integer> e : map.entrySet()) {
				if (e.getKey().startsWith(check.substring(check.length() - 1))) {
					if (maxFrequency < e.getValue()) {
						maxFrequencyBigram = e.getKey();
						maxFrequency = e.getValue();
					}
				}
			}

			if (maxFrequency > 0) {
				char nextCharacter = maxFrequencyBigram.charAt(1);
				check = check + nextCharacter + "";
			}

		}

		System.out.println(check);

	}

}
