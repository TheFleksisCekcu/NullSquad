package gq.catchthels.nullhepler.fun;

import java.util.ArrayList;

public class Facts {
	public static String getRandomFact() {
		ArrayList<String> facts = new ArrayList<String>();
		facts.add("Old name rat is 'CatchThels' :)");
		facts.add("First developers is CatchThels & static");
		facts.add("NullRAT is rewrited CatchThelsRAT");
		facts.add("NullRAT birthday is 5 July 2020");
		facts.add("Maehdakvan is gay");
		facts.add("Hello, CatchThels");
		facts.add("Look at my status, you can see total messaages :)");
		facts.add("Ray tracing was invented in 1969");
		facts.add("я топ кодер а ты нет");
		
		return "Fun fact: " + facts.get((byte) (Math.random()*facts.size()));
	}

}
