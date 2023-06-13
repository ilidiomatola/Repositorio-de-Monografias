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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import javax.servlet.http.Part;
import modelo.DAO.AreaConhecimentoDAO;
import modelo.entidade.Areaconhecimento;
import org.apache.commons.io.IOUtils;

@ManagedBean
@ViewScoped
@MultipartConfig(maxFileSize = 33554432)
public class AreaConhecimentoBean implements Serializable {

    private List<Areaconhecimento> listaAreaconhecimentos;
    private Areaconhecimento area_Conhecimento;

    public AreaConhecimentoBean() {
        area_Conhecimento = new Areaconhecimento();
    }

    public List<Areaconhecimento> getListaAreaconhecimentos() {
        AreaConhecimentoDAO ad = new AreaConhecimentoDAO();
        listaAreaconhecimentos = ad.listarAreaconhecimentos();
        return listaAreaconhecimentos;
    }

    public void setListaAreaconhecimentos(List<Areaconhecimento> listaAreaconhecimentos) {
        this.listaAreaconhecimentos = listaAreaconhecimentos;
    }

    public Areaconhecimento getAreaconhecimento() {
        return area_Conhecimento;
    }

    public void setAreaconhecimento(Areaconhecimento area_Conhecimento) {
        this.area_Conhecimento = area_Conhecimento;
    }

    public void limpiarAreaconhecimento() {
        area_Conhecimento = new Areaconhecimento();
    }

    public void cadastrarAreaconhecimento() {
        AreaConhecimentoDAO ad = new AreaConhecimentoDAO();
        ad.cadastrarAreaconhecimento(area_Conhecimento);
    }

    public void modificarAreaconhecimento() {
        AreaConhecimentoDAO ad = new AreaConhecimentoDAO();
        ad.atualizarAreaconhecimento(area_Conhecimento);
        limpiarAreaconhecimento();
    }

    public void eliminarAreaconhecimento() {
        AreaConhecimentoDAO ad = new AreaConhecimentoDAO();
        ad.removerAreaconhecimento(area_Conhecimento.getId());
        limpiarAreaconhecimento();
    }
}
