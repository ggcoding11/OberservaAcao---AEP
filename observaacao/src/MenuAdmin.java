import java.util.Scanner;

public class MenuAdmin extends MenuBase {

    public MenuAdmin(Scanner scanner, SolicitacaoService service) {
        super(scanner, service);
    }

    @Override
    public void exibir() {
        int opcao;

        do {
            System.out.println("\n--- Menu do Administrador ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Gerenciar Solicitações");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    visualizarSolicitacoes();
                    break;
                case 2:
                    gerenciarSolicitacao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void gerenciarSolicitacao() {
        System.out.print("Qual o protocolo da solicitação?: ");
        int protocolo = lerInteiro();

        Solicitacao encontrada = service.buscarPorProtocolo(protocolo);

        if (encontrada == null) {
            System.out.println("Solicitação não encontrada!");
            return;
        }

        System.out.println("Solicitação encontrada!");
        System.out.println(encontrada);

        System.out.println("1 - Aprovar");
        System.out.println("2 - Negar");
        System.out.print("Opção: ");
        int opcao = lerInteiro();

        try {
            switch (opcao) {
                case 1:
                    service.aprovar(encontrada);
                    System.out.println("Solicitação aprovada!");
                    break;
                case 2:
                    service.negar(encontrada);
                    System.out.println("Solicitação negada!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
