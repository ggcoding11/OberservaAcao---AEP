public class Usuario {
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final String login;
    private final String senha;
    private final TipoUsuario tipoUsuario;

    public Usuario(String nome, String endereco, String telefone,
                   String login, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
