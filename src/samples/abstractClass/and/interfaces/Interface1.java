package samples.abstractClass.and.interfaces;

interface Interface1 {	
	
	//Public and Abstract Method by default
	void interface1Method();
	
	
	//Default Method in Interface
	default void defaultMethodInInterface() {
		System.out.println("Default Method in Interface 1");
	}
	
	
	//Static Method in Interface
	static void staticMethodInInterface(){
    	System.out.println("Static method in Interface 1");
    }
}
