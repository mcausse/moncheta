package org.moncheta.mapper.autogen;

public class HsqldbIdentity extends Generator {

    public HsqldbIdentity() {
        super("call identity()");
    }

    @Override
    public boolean generateBefore() {
        return false;
    }

}
