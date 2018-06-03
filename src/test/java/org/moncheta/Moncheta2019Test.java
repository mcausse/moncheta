package org.moncheta;

import org.junit.Test;
import org.moncheta.AccessorTest.EStatus;
import org.moncheta.AccessorTest.Exp;
import org.moncheta.AccessorTest.ExpId;
import org.moncheta.mapper.Accessor;
import org.moncheta.mapper.Moncheta2019.Column;
import org.moncheta.mapper.Moncheta2019.TableModel;
import org.moncheta.mapper.Order;
import org.moncheta.mapper.handler.EnumeratedHandler;
import org.moncheta.mapper.handler.Handlers;

public class Moncheta2019Test {

    @Test
    public void testName() throws Exception {

        TableModel<Exp> p = new TableModel<>(Exp.class, "exps");
        p.addColumn(new Column(true, "any_exp", new Accessor(Exp.class, "id.anyExp"), Handlers.INTEGER, null));
        p.addColumn(new Column(true, "num_exp", new Accessor(Exp.class, "id.numExp"), Handlers.LONG, null));
        p.addColumn(new Column(false, "desc", new Accessor(Exp.class, "desc"), Handlers.STRING, null));
        p.addColumn(new Column(false, "status", new Accessor(Exp.class, "status"), new EnumeratedHandler(EStatus.class),
                null));

        ExpId id = new ExpId(2019, 123L);
        Exp e = new Exp(id, "alo", EStatus.ACTIVE);

        System.out.println(p.queryForLoadById(id));
        System.out.println(p.queryForLoadAll(new Order[] { Order.asc("desc") }));
        System.out.println(p.queryForInsert(e));
        System.out.println(p.queryForUpdate(e));
        System.out.println(p.queryForDelete(e));
        System.out.println(p.queryForDeleteById(id));
    }
}
