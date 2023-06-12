/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.annotation.MultipartConfig;
import modelo.DAO.AreaConhecimentoDAO;
import modelo.DAO.CursoDAO;
import modelo.DAO.MonografiaDAO;
import modelo.entidade.Areaconhecimento;
import modelo.entidade.Curso;
import modelo.entidade.Monografia;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@ManagedBean
@ViewScoped
@MultipartConfig(maxFileSize = 33554432)
public class MonografiaBean implements Serializable{

    /**
     * Creates a new instance of MonografiaBean
     */
   
    private byte[] arquivo;
    private int idCurso;
    private int idAreaConhecimento;
    
    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAreaConhecimento() {
        return idAreaConhecimento;
    }

    public void setIdAreaConhecimento(int idAreaConhecimento) {
        this.idAreaConhecimento = idAreaConhecimento;
    }
    
    
    
    
    private List<Monografia> listaMonografias;
    private Monografia monografia;

    public MonografiaBean() {
        monografia = new Monografia();
    }

    public List<Monografia> getListaMonografias() {
        MonografiaDAO ad = new MonografiaDAO();
        listaMonografias = ad.listarMonografias();
        return listaMonografias;
    }

    public void setListaMonografias(List<Monografia> listaMonografias) {
        this.listaMonografias = listaMonografias;
    }

    public Monografia getMonografia() {
        return monografia;
    }

    public void setMonografia(Monografia monografia) {
        this.monografia = monografia;
    }

    public void limpiarMonografia() {
        monografia = new Monografia();
    }

    public void cadastrarMonografia() {

        CursoDAO cursoDAO = new CursoDAO();
        monografia.setCurso(cursoDAO.buscarCurso(idCurso));
        
        AreaConhecimentoDAO areaDAO = new AreaConhecimentoDAO();
        monografia.setAreaconhecimento(areaDAO.buscarAreaconhecimento(idAreaConhecimento));

            MonografiaDAO ad = new MonografiaDAO();
            ad.cadastrarMonografia(monografia);
//        } catch (IOException e) {
//        }
    }

    public void modificarMonografia() {
        CursoDAO cursoDAO = new CursoDAO();
        monografia.setCurso(cursoDAO.buscarCurso(idCurso));
        
        AreaConhecimentoDAO areaDAO = new AreaConhecimentoDAO();
        monografia.setAreaconhecimento(areaDAO.buscarAreaconhecimento(idAreaConhecimento));

        MonografiaDAO ad = new MonografiaDAO();
        ad.atualizarMonografia(monografia);
        limpiarMonografia();
    }

    public void eliminarMonografia() {
        MonografiaDAO ad = new MonografiaDAO();
        ad.excluirMonografia(monografia.getId());
        limpiarMonografia();
    }

    public StreamedContent obterArquivo(Monografia monografia) {
        byte[] arquivoBytes = monografia.getMonografia();
        String nomeArquivo = "monografia_" + monografia.getId() + ".pdf"; // Define o nome do arquivo a se descarregar
        String contentType = "application/pdf"; // Define o tipo do arquivo a se descarregar
        return new DefaultStreamedContent(new ByteArrayInputStream(arquivoBytes), contentType, nomeArquivo);
    }
    
    //Para obter o nome do curso e no apenas o id
    public String obterNomeCurso(int idCurso) {
        CursoDAO cursoDAO = new CursoDAO();
        Curso curso = cursoDAO.buscarCurso(idCurso);
        if (curso != null) {
            return curso.getNome();
        }
        return "Não Localizado";
    }
    
      //Para obter o nome da Área de Conhecimento e nao apenas o id
    public String obterAreaConhecimento(int idAreaConhecimento) {
        AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
        Areaconhecimento area = areaConhecimentoDAO.buscarAreaconhecimento(idAreaConhecimento);
        if (area != null) {
            return area.getNome();
        }
        return "Não Localizada";
    }

 
}
