package Modelo.entidade;
// Generated 09/06/2023 00:04:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Monografia generated by hbm2java
 */
public class Monografia  implements java.io.Serializable {


     private Integer id;
     private Areaconhecimento areaconhecimento;
     private Curso curso;
     private Usuario usuario;
     private String titulo;
     private String assunto;
     private String autor;
     private Date dataPublicacao;
     private byte[] monografia;

    public Monografia() {
    }

	
    public Monografia(String titulo, String assunto, String autor) {
        this.titulo = titulo;
        this.assunto = assunto;
        this.autor = autor;
    }
    public Monografia(Areaconhecimento areaconhecimento, Curso curso, Usuario usuario, String titulo, String assunto, String autor, Date dataPublicacao, byte[] monografia) {
       this.areaconhecimento = areaconhecimento;
       this.curso = curso;
       this.usuario = usuario;
       this.titulo = titulo;
       this.assunto = assunto;
       this.autor = autor;
       this.dataPublicacao = dataPublicacao;
       this.monografia = monografia;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Areaconhecimento getAreaconhecimento() {
        return this.areaconhecimento;
    }
    
    public void setAreaconhecimento(Areaconhecimento areaconhecimento) {
        this.areaconhecimento = areaconhecimento;
    }
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAssunto() {
        return this.assunto;
    }
    
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Date getDataPublicacao() {
        return this.dataPublicacao;
    }
    
    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public byte[] getMonografia() {
        return this.monografia;
    }
    
    public void setMonografia(byte[] monografia) {
        this.monografia = monografia;
    }




}

