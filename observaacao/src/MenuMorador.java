import java.util.Scanner;

public class MenuMorador extends MenuBase {

    public MenuMorador(Scanner scanner, SolicitacaoService service) {
        super(scanner, service);
    }

    @Override
    public void exibir() {
        int opcao;

        do {
            System.out.println("\n--- Menu do Morador ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Abrir nova solicitação");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    visualizarSolicitacoes();
                    break;
                case 2:
                    abrirSolicitacao();
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

    private void abrirSolicitacao() {
        System.out.println("--- Abertura de solicitação ---");

        Categoria categoria = escolherCategoria();
        if (categoria == null) {
            System.out.println("Categoria inválida! Solicitação cancelada.");
            return;
        }

        System.out.println("\nDescreva o problema:");
        System.out.println("(Ex: poste sem luz, buraco grande, lixo acumulado...)");
        System.out.print("> ");
        String descricao = scanner.nextLine();

        System.out.println("\nInforme a localização:");
        System.out.println("(Rua, número, bairro ou ponto de referência)");
        System.out.print("> ");
        String localizacao = scanner.nextLine();

        Solicitacao criada = service.criar(categoria, descricao, localizacao);
        System.out.printf("Solicitação aberta com sucesso! Protocolo: #%06d%n", criada.getProtocolo());
    }

    private Categoria escolherCategoria() {
        System.out.println("Escolha a categoria do problema:\n");

        System.out.println("1 - ILUMINAÇÃO");
        System.out.println("Problemas relacionados à iluminação pública.");
        System.out.println("Exemplos: Falta de poste, lâmpada queimada, rua escura\n");

        System.out.println("2 - BURACO");
        System.out.println("Problemas na via pública que podem causar acidentes.");
        System.out.println("Exemplos: Buraco na rua, asfalto danificado, cratera na pista\n");

        System.out.println("3 - LIMPEZA");
        System.out.println("Problemas relacionados à higiene e acúmulo de resíduos.");
        System.out.println("Exemplos: Água parada, lixo acumulado, entulho em local público\n");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1: return Categoria.ILUMINACAO;
            case 2: return Categoria.BURACO;
            case 3: return Categoria.LIMPEZA;
            default: return null;
        }
    }
}
