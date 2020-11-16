package bdd_models;

import runner_utils.CustomAssert;

public class BDDController<T extends CustomAssert> {

    private final T customAssert;

    public BDDController(T customAssert) {
        this.customAssert = customAssert;
    }

    public T customAssert() {
        return this.customAssert;
    }
}
