package services;

import java.util.Date;
import java.util.UUID;

import dao.AlertDao;
import dao.MapAlertDAO;

public class AlertService {
    private final MapAlertDAO storage;

    public AlertService(AlertDao dao){
        storage=(MapAlertDAO)dao;
    }

    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }
}
