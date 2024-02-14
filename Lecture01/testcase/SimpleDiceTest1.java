package testcase;

import mypackage.SimpleDice;

public class SimpleDiceTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDice diceA = new SimpleDice(1);
		SimpleDice diceB = new SimpleDice(5);
		SimpleDice diceC = new SimpleDice();
		System.out.println("Initialize the dices");
		System.out.println(diceA.faceValue);
		System.out.println(diceB.faceValue);
		System.out.println(diceC.faceValue);
				
		diceA.roll();
		diceB.roll();
		System.out.println("After roll the dices");
		System.out.println(diceA.faceValue);
		System.out.println(diceB.faceValue);
		System.out.println(diceC.faceValue);
		System.out.println(diceA); //print address
		System.out.println(diceA);
	}

	public static void setToFivePassByValue(int a){
		a=5;
	}

	public static void setToFivePassByReference(SimpleDice a){
		a.setFaceValue(5);
	}

}
