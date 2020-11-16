package bdd_models;

import runner_utils.CustomAssert;

public class ActController<T extends CustomAssert> extends BDDController<T> {

    public ActController(T customAssert) {
        super(customAssert);
    }
}
