package br.insper.ferramenta;


import lombok.Getter;
import lombok.Setter;

//id
//nome (String)
//descricao (String)
//categoria (Exemplo: "Eletrônica", "Mecânica", "Escritório")
//nomeUsuario (nome do usuário que cadastrou a ferramenta)
//emailUsuario (e-mail do usuário que cadastrou a ferramenta)

//@Getter
//@Setter
public class Ferramenta {
    private String id;
    private String nome;
    private String descricao;
    private String categoria;
    private String nomeUsuario;
    private String emailUsuario;

    public Ferramenta(String id, String nome, String descricao, String categoria, String nomeUsuario){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.nomeUsuario = nomeUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
