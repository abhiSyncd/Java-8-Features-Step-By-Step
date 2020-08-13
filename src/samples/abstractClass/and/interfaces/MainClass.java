package samples.abstractClass.and.interfaces;

public class MainClass  extends AbstractClass implements Interface1 ,Interface2{
	
	MainClass(){
		System.out.println("Derived class constructor called");
	}
	
	
	@Override
	void abstractClassAbstractMethod() {
	}
	
	@Override
	public void interface1Method() {
	}

	@Override
	public void interface2Method() {
	}

	@Override
	public void defaultMethodInInterface() {
		Interface1.super.defaultMethodInInterface();
		Interface2.super.defaultMethodInInterface();
	}

	
	public static void main(String args[]) {
		
		
		 MainClass mc = new MainClass();       //Calls constructor of base then derived class
		
		 
		// mc.abstractClassDefinedMethod();      //Class Defined method in Abstract class
		// mc.abstractClassFinalMethod();        //Calls Final Method of Abstract Class      
		 
//		 mc.defaultMethodInInterface();        //Calls Interface Default Method 
//		
//		 Interface1.staticMethodInInterface(); //Calls Interface Static Method
//		 Interface2.staticMethodInInterface();	
	}	
}
