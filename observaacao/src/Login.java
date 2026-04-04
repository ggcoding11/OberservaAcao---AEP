import java.util.List;

public class Login {
    private final List<Usuario> usuarios;

    public Login(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario validar(String login, String senha) {
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }
}
