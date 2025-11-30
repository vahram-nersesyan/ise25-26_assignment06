package de.seuhd.campuscoffee.domain.ports;

import de.seuhd.campuscoffee.domain.model.Pos;
import de.seuhd.campuscoffee.domain.model.User;
import org.jspecify.annotations.NonNull;

import java.util.List;

public interface UserService {
    //TODO: Define user service interface
    @NonNull List<User> getAll();
    @NonNull User getById(@NonNull Long id);
    @NonNull User getByloginName(@NonNull String loginName);
    @NonNull User upsert(@NonNull User user);
    void delete(@NonNull Long id);
}
