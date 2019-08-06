package kata.tamingsmellycode;

public class AClassNeedToBeTested {
    private NewADependedOnComponentWhichToBeMocked memberVariable;

    // tlc11
    private static final DryConfiguration dryConfiguration = AppConfiguration.getDryConfiguration();
    private static ModelReader reader;
    private static TransactionManager tm;

    static {
        reader = new ModelReader(AppConfig.getDryConfiguration());
        XMLStore persister = new XMLStore(dryConfiguration);
        tm = new TransactionManager(reader, persister);
    }

    public AClassNeedToBeTested() {
        this.memberVariable = new NewADependedOnComponentWhichToBeMocked(); // tlc4. Parameterize Constructor

        AService.aStaticMethodWhichToBeMocked(); // tlc6. Introduce Instance Delegator
    }

    public AClassNeedToBeTested(ParameterToBeMOcked parameterToBeMOcked) { // tlc1. Extract Interface
    }

    public void aMethod(HttpServletRequest httpServletRequest) { // tlc1. Adapt Parameter
    }

    public void anotherMethod() {
        NewADependedOnComponentWhichToBeMocked aVariable = new NewADependedOnComponentWhichToBeMocked();
        // tlc4. Parameterize Method
    }

    public void theThirdMethod() {
        AService.aStaticMethodWhichToBeMocked(); // tlc6. Introduce Instance Delegator
    }

    public void aLargeMethodWithManyInstanceDataAndMethodsNotToBeTested() { // k9. Break out Method Object
    }

    public void aMethodUsedSingletonWhichToBeMocked() {
        Singleton singleton = Singleton.getInstance(); // k8. Introduce Static Setter
    }

    public void aMethodUsedAnInstanceCreatedFromAGlobalFactoryWhichToBeMocked() {
        Product product = GlobalFactory.makeProduct(); // k8. Introduce Static Setter
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
