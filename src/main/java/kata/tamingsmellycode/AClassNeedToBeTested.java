package kata.tamingsmellycode;

public class AClassNeedToBeTested {
    private AnotherDependedOnComponentNeedToBeMocked memberVariable;

    public AClassNeedToBeTested() {
        this.memberVariable = new AnotherDependedOnComponentNeedToBeMocked();
        // 3. Parameterize Constructor
        // 9. Extract & Override Factory Method
    }

    public AClassNeedToBeTested(DependedOnComponentNeedToBeMocked dependedOnComponentNeedToBeMocked) {
        // 1. Extract Interface
    }

    public void aMethod(ClassWithTooManyMethodsToMock classWithTooManyMethodsToMock) {
        // 2. Adapt Parameter
    }

    public void anotherMethod() {
        TheThirdDependedOnComponentNeedToBeMocked aVariable =
                new TheThirdDependedOnComponentNeedToBeMocked();
        // 4. Parameterize Method
        // 8. Subclass & Override Method
    }

    public void theThirdMethod() {
        AService.aStaticMethod();
        // 5. Introduce Instance Delegator
    }

    public void theFourthMethod() {
        String aVariable = AnotherService.aStaticMethod();
        // 10. Extract & Override Call
        // 11. Replace Global Reference with Getter
    }

    public void aLargeMethodUsingManyInstanceDataAndMethods() {
        // 6. Break out Method Object
    }

    public void aMethodUsedSingletonWhichToBeMocked() {
        Singleton singleton = Singleton.getInstance();
        // 7. Introduce Static Setter

    }
}

class Singleton {
    private static Singleton singleInstance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }
}
