package samples.abstractClass.and.interfaces;

interface Interface2 {
	
	void interface2Method();
	
	default void defaultMethodInInterface() {
		System.out.println("Default Method in Interface 1");
	}
	
	static void staticMethodInInterface(){
    	System.out.println("Static method in Interface 2");
    }
}
