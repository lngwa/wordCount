package w1d2_partB;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Mapper {
		private Scanner file;

		public List<Pair<String, Integer>> map(String filePath) {
			try {
				file = new Scanner(new FileReader(filePath));
			} catch (Exception e) {			
				e.printStackTrace();
			}

			List<Pair<String, Integer>> words = new LinkedList<>();
			
			while (file.hasNext()) {	
				String word = file.next();
				if(word.matches("[a-zA-Z-'\"]+.")) {
					word = word.replaceAll("['\".]", "");
					String[] keys = word.split("-");
					for(int i = 0; i < keys.length; i++) {
						if(!keys[i].trim().isEmpty()) {
							Pair<String, Integer> pair = new Pair<String, Integer>(keys[i].toLowerCase(), 1);
							words.add(pair);
						}
					}
				}			
			}
			
			file.close();
			
			List<Pair<String, Integer>> pairs = words.stream().sorted().collect(Collectors.toList());
			
			return pairs;
		}
	}
