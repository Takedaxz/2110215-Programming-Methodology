package mypackage;

public class SimpleDice {
	final static int MAX = 6;
	public int faceValue;
	//constructor
	public SimpleDice(int faceValue) {
		// faceValue = val
		this.faceValue = faceValue;
	}

	public SimpleDice(){
		this.faceValue=1;
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}
	public String toString(){
		return "The face is "+this.faceValue;
	}
	public static void main(String[] args) {
		SimpleDice diceA = new SimpleDice(1);
		System.out.println(diceA.MAX);
		System.out.println(SimpleDice.MAX);

		System.out.println(Math.PI);
		System.out.println(Math.random());
		System.out.println(Math.floor(1.2));
	}

	@Override
	public boolean equals(Object o) {
		SimpleDice otherDice = (SimpleDice) o;

        return false;
    }

    public void setFaceValue(int i) {
    }
}
