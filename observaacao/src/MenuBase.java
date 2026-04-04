import java.util.List;
import java.util.Scanner;

public abstract class MenuBase implements IMenu {
    protected final Scanner scanner;
    protected final SolicitacaoService service;

    protected MenuBase(Scanner scanner, SolicitacaoService service) {
        this.scanner = scanner;
        this.service = service;
    }

    protected void visualizarSolicitacoes() {
        List<Solicitacao> lista = service.listarTodas();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma solicitação cadastrada.");
            return;
        }

        for (Solicitacao s : lista) {
            System.out.println(s);
        }
    }

    protected int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
