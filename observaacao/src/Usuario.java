public class Usuario {
    private String nome;
    private String endereco;
    private String login;
    private String senha;
    private String telefone;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String endereco, String telefone, String senha, String login, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
        this.login = login;
        this.tipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
