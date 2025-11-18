package github.lipenathan.demo.model.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Esta é uma classe que representa o modelo de dados de usuários da aplicação.
 * @author fnanjos
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    private Documento documento;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Contato> contatos;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    /**
     * getter do id de usuário
     * @return inteiro que identifica este usuário como único na aplicação
     */
    public Long getId() {
        return id;
    }

    /**
     * mét0do para setar id do usuário
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
