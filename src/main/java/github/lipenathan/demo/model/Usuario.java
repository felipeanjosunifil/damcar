package github.lipenathan.demo.model;

/**
 * Esta é uma classe que representa o modelo de dados de usuários da aplicação.
 * @author fnanjos
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * getter do id de usuário
     * @return inteiro que identifica este usuário como único na aplicação
     */
    public int getId() {
        return id;
    }

    /**
     * mét0do para setar id do usuário
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
