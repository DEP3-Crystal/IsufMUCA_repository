package dao;

import java.util.Date;
import java.util.UUID;

public interface AlertDao {

    UUID addAlert(Date time);

    Date getAlert(UUID id);
}
