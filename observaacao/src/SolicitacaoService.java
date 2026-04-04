import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SolicitacaoService {
    private final List<Solicitacao> solicitacoes = new ArrayList<>();
    private final Random random = new Random();

    public Solicitacao criar(Categoria categoria, String descricao, String localizacao) {
        int protocolo = random.nextInt(100000);
        Solicitacao solicitacao = new Solicitacao(
                protocolo, categoria, descricao, localizacao,
                Status.ABERTO, LocalDateTime.now()
        );
        solicitacoes.add(solicitacao);
        return solicitacao;
    }

    public Solicitacao buscarPorProtocolo(int protocolo) {
        for (Solicitacao s : solicitacoes) {
            if (s.getProtocolo() == protocolo) {
                return s;
            }
        }
        return null;
    }

    public void aprovar(Solicitacao solicitacao) {
        if (solicitacao.getStatus() != Status.ABERTO) {
            throw new IllegalStateException("Só é possível aprovar solicitações ABERTAS!");
        }
        solicitacao.setStatus(Status.EM_ANDAMENTO);
    }

    public void negar(Solicitacao solicitacao) {
        if (solicitacao.getStatus() != Status.ABERTO) {
            throw new IllegalStateException("Só é possível negar solicitações ABERTAS!");
        }
        solicitacao.setStatus(Status.NEGADO);
    }

    public void finalizar(Solicitacao solicitacao) {
        if (solicitacao.getStatus() != Status.EM_ANDAMENTO) {
            throw new IllegalStateException("Só é possível finalizar solicitações EM ANDAMENTO!");
        }
        solicitacao.setStatus(Status.RESOLVIDO);
    }

    public List<Solicitacao> listarTodas() {
        return Collections.unmodifiableList(solicitacoes);
    }
}
