package bigram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {

		String input = "abbcceeeeeeabcc";

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
	}

}
