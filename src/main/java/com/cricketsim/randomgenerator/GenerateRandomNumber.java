package com.cricketsim.randomgenerator;

import java.util.List;
import java.util.Optional;

public class GenerateRandomNumber {
	
	private static double rand(double min, double max) {
	    return Math.random() * (max - min) + min;
	};

	/*This method will return the randomItem from the given scores & 
	 * there's corresponding scoreprobability for each individual batsmen
	 * @param socresList: holds the score data like 0(represents as dot ball),1,2,3,4,5,6,7(represents as out)
	 * @param scoresProbabilityList: holds the probability to getting a score(for eg: 1 with probability 30% etc.,)
	 * @return returns random value from scoresList using weighted random number generation based on probability
	 * */
	@SuppressWarnings("unused")
	public static Integer getRandomItem(List<Integer> scoresList, List<Double> scoresProbabilityList) {
		Optional<Double> totalSum = scoresProbabilityList.stream().reduce((prev,cur) -> prev + cur); 
		Double totalWeight = 0.0d;
		if(totalSum.isPresent())
			totalWeight = totalSum.get();
	     
	    Double randomNum = rand(0, totalWeight);
	    Double weightSum = 0.0d;
	     
	    for (int i = 0; i < scoresList.size(); i++) {
	        weightSum += scoresProbabilityList.get(i);
	        weightSum = +weightSum.doubleValue();
	         
	        if (randomNum <= weightSum) {
	            return scoresList.get(i);
	        }
	    }
		return weightSum.intValue();
	}
}
