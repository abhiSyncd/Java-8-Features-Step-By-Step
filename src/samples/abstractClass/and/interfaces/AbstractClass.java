package samples.abstractClass.and.interfaces;

abstract class AbstractClass {

	
	//Constructor defined : : UNLIKE Interfaces where we can't define constructor 
	//                    : : We can Instantiate either Abstract class or Interface                       
	AbstractClass() {
		System.out.println("Abstract Class constructor called");
	}

	
	//Abstract Method :: Need to override in derived class 
	abstract void abstractClassAbstractMethod();
	

	//Defined Method : : No need to override in derived class : can be called using DerivedClass Object
	void abstractClassDefinedMethod() {
		System.out.println("Defined method of abstract class called");
	}

	
	//Final Method : Cannot be overridden : : No need to override in derived class : can be called using DerivedClass Object
	final void abstractClassFinalMethod() {
		System.out.println("Final method of abstract class called");
	}
	
}
