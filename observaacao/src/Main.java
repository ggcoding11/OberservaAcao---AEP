import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static List<Solicitacao> solicitacaoList = new ArrayList<>();

    static List<Usuario> userList = new ArrayList<Usuario>(List.of(new Usuario(
            "Funcionário Padrão",
            "Empresa XYZ",
            "(44) 99876-5432",
            "funcionario123",
            "executor123",
            TipoUsuario.FUNCIONARIO
    ), new Usuario(
            "Rafaela Souza",
            "Rua A, 123",
            "(44) 91234-5678",
            "rafaela123",
            "rafa1234",
            TipoUsuario.MORADOR
    ), new Usuario(
            "Administrador",
            "Sistema",
            "(00) 00000-0000",
            "admin",
            "admin",
            TipoUsuario.ADMIN
    )));

    static void main() {
        Usuario atual;

        do {
            System.out.println("Prefeitura - Xique Xique Pedrosa");

            String login;
            String senha;

            System.out.println("Login: ");
            login = scanner.nextLine();

            System.out.println("Senha: ");
            senha = scanner.nextLine();

            atual = Login.validar(userList, login, senha);

            if (atual == null) {
                System.out.println("Login inválido!");
            }
        } while (atual == null);

        switch(atual.getTipoUsuario()) {
            case ADMIN: {
                menuAdmin();
                break;
            }

            case MORADOR: {
                menuMorador();
                break;
            }

            case FUNCIONARIO: {
                menuFuncionario();
                break;
            }
        }
    }

    public static void menuAdmin() {
        int opcao;

        do {
            System.out.println("\n--- Menu do Administrador ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Gerenciar Solicitações");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    Solicitacao.visualizarSolicitacao();
                    break;
                }

                case 2: {
                    gerenciarSolicitacoes();
                    break;
                }

                case 0: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    public static void menuMorador(){
        int opcao;

        do {
            System.out.println("\n--- Menu do Morador ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Abrir nova solicitação");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    Solicitacao.visualizarSolicitacao();
                    break;
                }

                case 2: {
                    abrirSolicitacao();
                    break;
                }

                case 0: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    public static void menuFuncionario(){
        int opcao;

        do {
            System.out.println("\n--- Menu do Funcionário ---");
            System.out.println("1 - Visualizar Solicitações");
            System.out.println("2 - Finalizar Solicitação");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    Solicitacao.visualizarSolicitacao();
                    break;
                }

                case 2: {
                    new Main().finalizarSolicitacoes();
                    break;
                }

                case 0: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    public static void abrirSolicitacao() {
        System.out.println("--- Abertura de solicitação ---");

        Solicitacao solicitacao = new Solicitacao();

        int opcaoCategoria;

        System.out.println("Escolha a categoria do problema:\n");

        System.out.println("1 - ILUMINAÇÃO 💡");
        System.out.println("Problemas relacionados à iluminação pública.");
        System.out.println("Exemplos:");
        System.out.println("- Falta de poste na rua");
        System.out.println("- Lâmpada queimada");
        System.out.println("- Rua muito escura à noite\n");

        System.out.println("2 - BURACO 🕳️");
        System.out.println("Problemas na via pública que podem causar acidentes.");
        System.out.println("Exemplos:");
        System.out.println("- Buraco na rua");
        System.out.println("- Asfalto danificado");
        System.out.println("- Cratera ou irregularidade na pista\n");

        System.out.println("3 - LIMPEZA 🧹");
        System.out.println("Problemas relacionados à higiene e acúmulo de resíduos.");
        System.out.println("Exemplos:");
        System.out.println("- Água parada");
        System.out.println("- Lixo acumulado na rua");
        System.out.println("- Entulho em local público\n");

        opcaoCategoria = scanner.nextInt();

        switch(opcaoCategoria) {
            case 1 -> solicitacao.setCategoria(Categoria.ILUMINACAO);
            case 2 -> solicitacao.setCategoria(Categoria.BURACO);
            case 3 -> solicitacao.setCategoria(Categoria.LIMPEZA);
            default -> System.out.println("Opção inválida!");
        }

        String descricao;

        System.out.println("\nDescreva o problema:");
        System.out.println("(Ex: poste sem luz, buraco grande, lixo acumulado...)");
        System.out.print("> ");

        descricao = scanner.nextLine();
        solicitacao.setDescricao(descricao);

        String localizacao;

        System.out.println("\nInforme a localização:");
        System.out.println("(Rua, número, bairro ou ponto de referência)");
        System.out.print("> ");

        localizacao = scanner.nextLine();
        solicitacao.setLocalizacao(localizacao);

        solicitacao.setStatus(Status.ABERTO);
        solicitacao.setDataCriacao(LocalDateTime.now());

        solicitacao.setProtocolo(new Random().nextInt(100000));

        solicitacaoList.add(solicitacao);

        System.out.println("Solicitação aberta com sucesso!");
    }

    public static void gerenciarSolicitacoes() {
        int protocolo;
        System.out.println("Qual o protocolo da solicitação?: ");
        protocolo = scanner.nextInt();

            Solicitacao encontrada = null;

        for (Solicitacao solicitacao : solicitacaoList) {
            if (solicitacao.getProtocolo() == protocolo) {
                encontrada = solicitacao;
                System.out.println("Solicitação encontrada!");
                break;
            }
        }

        if (encontrada != null) {
            int opcao;

            System.out.println("1 - Aprovar");
            System.out.println("2 - Negar");

            System.out.println("Opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1: {
                    if (encontrada.getStatus() == Status.ABERTO) {
                        encontrada.setStatus(Status.EM_ANDAMENTO);
                        System.out.println("Solicitação aprovada!");
                    } else {
                        System.out.println("Só é possível aprovar solicitações ABERTAS!");
                    }
                    break;
                }

                case 2: {
                    encontrada.setStatus(Status.NEGADO);
                    System.out.println("Solicitação negada!");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                }
            }

            System.out.println("Solicitação concluída!");
        } else {
            System.out.println("Solicitação não encontrada!");
        }

    }

    public static void finalizarSolicitacoes() {
        int protocolo;

        System.out.println("Qual o protocolo da solicitação?: ");
        protocolo = scanner.nextInt();

        Solicitacao encontrada = null;

        for (Solicitacao solicitacao : solicitacaoList) {
            if (solicitacao.getProtocolo() == protocolo) {
                encontrada = solicitacao;
                System.out.println("Solicitação encontrada!");
                break;
            }
        }

        if (encontrada != null) {
            if (encontrada.getStatus() == Status.EM_ANDAMENTO) {
                encontrada.setStatus(Status.RESOLVIDO);

                System.out.println("Solicitação finalizada com sucesso!");
            } else {
                System.out.println("Só é possível finalizar solicitações EM ANDAMENTO!");
            }
        }
    }
}