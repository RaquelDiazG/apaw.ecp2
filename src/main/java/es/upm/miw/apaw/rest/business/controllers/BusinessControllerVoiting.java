package es.upm.miw.apaw.rest.business.controllers;

import java.awt.List;

import es.upm.miw.apaw.rest.business.views.TransferObjectTheme;
import es.upm.miw.apaw.rest.business.views.TransferObjectVoting;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;
import es.upm.miw.apaw.rest.data.models.daos.VoteDao;

public class BusinessControllerVoiting {

    public TransferObjectVoting findAll() {
        DaoFactory.getFactory().getVoteDao().findAll();
        return new TransferObjectVoting();
    }

    public void m2(TransferObjectTheme transferObject2) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }

    public TransferObjectVoting getAll() {
        List<VoteDao> all = DaoFactory.getFactory().getVoteDao().findAll();
        return new TransferObjectVoting(all);
    }
}
