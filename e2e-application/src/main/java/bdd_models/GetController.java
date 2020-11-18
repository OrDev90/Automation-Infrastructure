package bdd_models;

import scenarios_utils.CustomAssert;

public class GetController<T extends CustomAssert> extends BDDController<T> {

    public GetController(T customAssert) {
        super(customAssert);
    }
}
