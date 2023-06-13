/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.DAO.CursoDAO;
import modelo.entidade.Curso;



@ManagedBean
@ViewScoped
public class CursoBean implements Serializable{

    /**
     * Creates a new instance of CursoBean
     */
    private List<Curso> listaCurso;
    private Curso curso;

    public CursoBean() {
        curso = new Curso();
    }

    public List<Curso> getListaCurso() {
        CursoDAO ad = new CursoDAO();
        listaCurso = ad.listarCursos();
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void limparCurso() {
        curso = new Curso();
    }

    public void agregarCurso() {
        CursoDAO ad = new CursoDAO();
        ad.cadastrarCurso(curso);
    }

    public void modificarCurso() {
        CursoDAO ad = new CursoDAO();
        ad.atualizarCurso(curso);
        limparCurso();
    }

    public void eliminarCurso() {
        CursoDAO ad = new CursoDAO();
        ad.removerCurso(curso.getId());
        limparCurso();
    }
}
