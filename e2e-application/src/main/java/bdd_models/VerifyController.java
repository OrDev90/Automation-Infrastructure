package bdd_models;

import runner_utils.CustomAssert;

public class VerifyController<T extends CustomAssert> extends BDDController<T> {

    public VerifyController(T customAssert) {
        super(customAssert);
    }
}
