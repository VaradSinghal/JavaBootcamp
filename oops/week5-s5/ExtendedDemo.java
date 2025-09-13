package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {

    public ExtendedDemo(int privateField, String defaultField,
                        double protectedField, boolean publicField) {
        super(privateField, defaultField, protectedField, publicField);
    }

    public void testInheritedAccess() {
   
        System.out.println(protectedField);
        System.out.println(publicField);
 
        protectedMethod();
        publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo");
    }

    public static void main(String[] args) {
        AccessModifierDemo parent = new AccessModifierDemo(5, "Parent", 10.0, false);
        ExtendedDemo child = new ExtendedDemo(7, "Child", 20.0, true);

        System.out.println("=== Parent Object Access ===");
        System.out.println(parent.publicField);
        parent.publicMethod();

        System.out.println("\n=== Child Object Access (Subclass) ===");
        child.testInheritedAccess();
    }
}
