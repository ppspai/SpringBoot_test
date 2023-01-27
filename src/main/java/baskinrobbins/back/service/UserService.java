package baskinrobbins.back.service;

public class UserService {
    private final UserCrudRepository repository;


    @Autowired
    public void setUserCrudRepository(UserCrudRepository repository) {
        this.repository = repository;
    }

    public void some() {
        List<Users> users = repository.findAll();
    }
}
