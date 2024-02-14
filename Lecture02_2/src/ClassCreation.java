public class ClassCreation {
	public static void main(String[] args) {
		C c1 = new C(5);
	}
}

class A {
	A(int val) {
		System.out.println("class A");
	}
}

class B extends A {
	B(int val) {
		super(10); //create A
		System.out.println("class B, value=" + val);
	}
}

class C extends B {
	C(int val) {
		super(val);
		System.out.println("class C, value=" + val);
	}
}