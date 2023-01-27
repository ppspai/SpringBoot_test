package baskinrobbins.back.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import baskinrobbins.back.domain.Users;

public class UsersRepository {
    
    public static Map<Integer, Users> store = new HashMap<>();
    private static int sequence = 0;

    public Users save(Users users) {
        users.setId(++sequence);
        store.put(users.getId(), users);
        return users;
    }

    public Optional<Users> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Users> findByName(String name) {
        return store.values().stream()
                .filter(users -> users.getName().equals(name))
                .findAny();
    }

    public List<Users> findAll() {
        return new ArrayList<>(store.values());
    }
    
    public void clearStore() {
        store.clear();
    }
}
