import java.util.Scanner;

public class MenuFuncionario extends MenuBase {

    public MenuFuncionario(Scanner scanner, SolicitacaoService service) {
        super(scanner, service);
    }

    @Override
    public void exibir() {
        int opcao;

        do {
            System.out.println("\n--- Menu do Funcionário ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Finalizar Solicitação");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    visualizarSolicitacoes();
                    break;
                case 2:
                    finalizarSolicitacao();
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

    private void finalizarSolicitacao() {
        System.out.print("Qual o protocolo da solicitação?: ");
        int protocolo = lerInteiro();

        Solicitacao encontrada = service.buscarPorProtocolo(protocolo);

        if (encontrada == null) {
            System.out.println("Solicitação não encontrada!");
            return;
        }

        System.out.println("Solicitação encontrada!");
        System.out.println(encontrada);

        try {
            service.finalizar(encontrada);
            System.out.println("Solicitação finalizada com sucesso!");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
