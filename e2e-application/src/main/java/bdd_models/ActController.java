package bdd_models;

import scenarios_utils.CustomAssert;

public class ActController<T extends CustomAssert> extends BDDController<T> {

    public ActController(T customAssert) {
        super(customAssert);
    }
}
