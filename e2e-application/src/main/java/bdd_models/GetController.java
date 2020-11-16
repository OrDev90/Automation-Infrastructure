package bdd_models;

import runner_utils.CustomAssert;

public class GetController<T extends CustomAssert> extends BDDController<T> {

    public GetController(T customAssert) {
        super(customAssert);
    }
}
