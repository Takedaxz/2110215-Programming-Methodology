package logic;

import java.util.ArrayList;

public class Building {
	private ArrayList<EnterProfile> enterProfileList;

	private int populationCount = 0;
	private int potentialInfectedCount = 0;

	public Building() {
		enterProfileList = new ArrayList<EnterProfile>();
	}

	public EnterProfile addProfile(Person person, int temperature) {

		EnterProfile enterProfile = new EnterProfile(person,temperature);
		for(EnterProfile enterProfile1 : enterProfileList){
			if(enterProfile1.getPerson().equals(enterProfile.getPerson())) {
				int index = enterProfileList.indexOf(enterProfile1);
				removeProfile(index);
				break;
			}
		}
		enterProfileList.add(enterProfile);
		populationCount++;
		if(enterProfile.hasFever()){
			potentialInfectedCount++;
		}
		return enterProfile;

	}


	public EnterProfile removeProfile(int index) {
		//Fill Code Here
		/*
		 * 	Remove enterProfile from enterProfileList according to the index number.
			Decrease populationCount by 1 and if that enterProfile hasFever is true, Decrease potentialInfectedCount by 1.
		 */
		EnterProfile enterProfileTmp=enterProfileList.get(index);
		populationCount--;
		if(enterProfileList.get(index).hasFever()) {
			potentialInfectedCount--;
		}
		enterProfileList.remove(index);
		return enterProfileTmp;


	}



	public int getPopulationCount() {
		return populationCount;
	}



	public int getPotentialInfectedCount() {
		return potentialInfectedCount;
	}

	public ArrayList<EnterProfile> getEnterProfileList() {
		return enterProfileList;
	}
}
