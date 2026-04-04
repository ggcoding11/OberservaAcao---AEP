import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolicitacaoService service = new SolicitacaoService();

        List<Usuario> usuarios = new ArrayList<>(List.of(
                new Usuario("Funcionário Padrão", "Empresa XYZ", "(44) 99876-5432",
                        "funcionario123", "executor123", TipoUsuario.FUNCIONARIO),
                new Usuario("Rafaela Souza", "Rua A, 123", "(44) 91234-5678",
                        "rafaela123", "rafa1234", TipoUsuario.MORADOR),
                new Usuario("Administrador", "Sistema", "(00) 00000-0000",
                        "admin", "admin", TipoUsuario.ADMIN)
        ));

        Login login = new Login(usuarios);

        Usuario atual = realizarLogin(scanner, login);

        IMenu menu = criarMenu(atual.getTipoUsuario(), scanner, service);
        menu.exibir();

        scanner.close();
    }

    private static Usuario realizarLogin(Scanner scanner, Login login) {
        Usuario atual = null;

        while (atual == null) {
            System.out.println("Prefeitura - Xique Xique Pedrosa");

            System.out.print("Login: ");
            String loginInput = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            atual = login.validar(loginInput, senha);

            if (atual == null) {
                System.out.println("Login inválido!\n");
            }
        }

        return atual;
    }

    private static IMenu criarMenu(TipoUsuario tipo, Scanner scanner, SolicitacaoService service) {
        switch (tipo) {
            case ADMIN:
                return new MenuAdmin(scanner, service);
            case MORADOR:
                return new MenuMorador(scanner, service);
            case FUNCIONARIO:
                return new MenuFuncionario(scanner, service);
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);
        }
    }
}
