import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {
    private final int protocolo;
    private final Categoria categoria;
    private final String descricao;
    private final String localizacao;
    private Status status;
    private final LocalDateTime dataCriacao;

    public Solicitacao(int protocolo, Categoria categoria, String descricao,
                       String localizacao, Status status, LocalDateTime dataCriacao) {
        this.protocolo = protocolo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");
        return "========================================\n" +
               "  DETALHES DA SOLICITAÇÃO\n" +
               "========================================\n" +
               String.format("  Protocolo  : #%06d%n", protocolo) +
               String.format("  Categoria  : %s%n", categoria) +
               String.format("  Status     : %s%n", status) +
               String.format("  Descrição  : %s%n", descricao) +
               String.format("  Localização: %s%n", localizacao) +
               String.format("  Criado em  : %s%n", dataCriacao.format(formatter)) +
               "========================================";
    }
}
