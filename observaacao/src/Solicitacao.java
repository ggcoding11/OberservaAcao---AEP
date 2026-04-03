import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {
    private static int protocolo;
    private static Categoria categoria;
    private static String descricao;
    private static String localizacao;
    private static Status status;
    private static LocalDateTime dataCriacao;

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        Solicitacao.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public static void visualizarSolicitacao() {
        System.out.println("========================================");
        System.out.println("  DETALHES DA SOLICITAÇÃO");
        System.out.println("========================================");
        System.out.printf("  Protocolo  : #%06d%n", protocolo);
        System.out.printf("  Categoria  : %s%n", categoria);
        System.out.printf("  Status     : %s%n", status);
        System.out.printf("  Descrição  : %s%n", descricao);
        System.out.printf("  Localização: %s%n", localizacao);
        System.out.printf("  Criado em  : %s%n", dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss")));
        System.out.println("========================================");
    }
}
