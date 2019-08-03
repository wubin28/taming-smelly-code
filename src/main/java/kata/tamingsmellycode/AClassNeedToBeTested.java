package kata.tamingsmellycode;

public class AClassNeedToBeTested {
    private NewADependedOnComponentWhichToBeMocked memberVariable;

    public AClassNeedToBeTested() {
        this.memberVariable = new NewADependedOnComponentWhichToBeMocked();
        // k3. Parameterize Constructor
        // k5. Extract & Override Factory Method
    }

    public AClassNeedToBeTested(ParameterToBeMOcked parameterToBeMOcked) {
        // k1. Extract Interface
    }

    public void aMethod(HttpServletRequestWhichIsHardToMock httpServletRequestWhichIsHardToMock) {
        // k2. Adapt Parameter
    }

    public void anotherMethod() {
        NewADependedOnComponentWhichToBeMocked aVariable =
                new NewADependedOnComponentWhichToBeMocked();
        // k4. Parameterize Method
        // k5. Extract & Override Factory Method
    }

    public void theThirdMethod() {
        AService.aStaticMethodWhichToBeMocked();
        // k6. Introduce Instance Delegator
    }

    public void theFourthMethod() {
        String aVariable = AnotherService.aStaticMethodWhichToBeMocked();
        // k7. Extract & Override Call
    }

    public void aLargeMethodWithManyInstanceDataAndMethodsNotToBeTested() {
        // k9. Break out Method Object
    }

    public void aMethodUsedSingletonWhichToBeMocked() {
        Singleton singleton = Singleton.getInstance();
        // k8. Introduce Static Setter
    }

    public void aMethodUsedAnInstanceCreatedFromAGlobalFactoryWhichToBeMocked() {
        Product product = GlobalFactory.makeProduct();
        // k8. Introduce Static Setter
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

class GlobalFactory {
    public static Product makeProduct() {
        return new Product();
    }
}
