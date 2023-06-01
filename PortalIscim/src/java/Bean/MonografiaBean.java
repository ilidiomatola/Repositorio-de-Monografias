package Bean;

import DAO.MonografiaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Monografia;

@ManagedBean
@ViewScoped
public class MonografiaBean {
private Monografia monografia;
    private List<Monografia> monografias;

    public Monografia getMonografia() {
        return monografia;
    }

    public void setMonografia(Monografia monografia) {
        this.monografia = monografia;
    }

    public List<Monografia> getMonografias() {
        MonografiaDAO dao=new MonografiaDAO();
        monografias=dao.apresentarMonografia();
        return monografias;
    }

    public void setCursos(List<Monografia> cursos) {
        this.monografias = monografias;
    }
    
    /**
     * Creates a new instance of MonografiaBean
     */
    public MonografiaBean() {
        monografia=new Monografia();
        
    }

    public void inserir(){
        MonografiaDAO dao=new MonografiaDAO();
        dao.inserirMonografia(monografia);
        monografia=new Monografia();
        addMessage("Monografia inserida com sucesso");
    } 
    public void modificar(){
        MonografiaDAO dao=new MonografiaDAO();
        dao.actualizarMonografia(monografia);
        monografia=new Monografia();
        addMessage("Monografia modificada com sucesso");
    }
        public void eliminar(){
        MonografiaDAO dao=new MonografiaDAO();
        dao.apagarMonografia(monografia);
        monografia=new Monografia();
        addMessage("Monografia eliminada com sucesso");
    }
    public void addMessage(String summary){
        FacesMessage messagem=new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, messagem);
    }
}
