package bdd_models;

import scenarios_utils.CustomAssert;

public abstract class TestTarget <T extends GetController<CustomAssert>,
        R extends ActController<CustomAssert>, S extends VerifyController<CustomAssert>> implements IBDD<GetController<CustomAssert>,
        ActController<CustomAssert>, VerifyController<CustomAssert>> {

    private final T getController;
    private final R actController;
    private final S verifyController;

    public TestTarget(T getController, R actController, S verifyController) {
        this.getController = getController;
        this.actController = actController;
        this.verifyController = verifyController;
    }

    @Override
    public T get() {
        return this.getController;
    }

    @Override
    public R act() {
        return this.actController;
    }

    @Override
    public S verify() {
        return this.verifyController;
    }
}
