package util;

import java.util.Comparator;

public class ComparatorCustom {
	public static final Comparator<String> compareRange =	new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.indexOf("-") == o2.indexOf("-")) {
				return (int) o1.charAt(0) - (int) o2.charAt(0);
			}
			return o1.indexOf("-") - o2.indexOf("-");
		}
		
	};
	public static final Comparator<String> compareDate = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	
	};
	
}
