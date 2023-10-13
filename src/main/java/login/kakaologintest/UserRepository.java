package login.kakaologintest;

public interface UserRepository {
    User findByUsername(String username);
}
