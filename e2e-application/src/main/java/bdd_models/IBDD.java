package bdd_models;

import runner_utils.CustomAssert;

public interface IBDD <T extends GetController<CustomAssert>,
        R extends ActController<CustomAssert>, S extends VerifyController<CustomAssert>> {

    T get();

    R act();

    S verify();
}
