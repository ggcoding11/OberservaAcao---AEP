import java.util.List;

public class Login {
    public static Usuario validar(List<Usuario> userList, String login, String senha) {
        for (Usuario user : userList) {
            if (user.getLogin().equals(login) && user.getSenha().equals((senha))) {
                return user;
            }
        }
        return null;
    }
}
