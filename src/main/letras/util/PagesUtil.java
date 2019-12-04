package main.letras.util;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean
public class PagesUtil {


    public static void fecharDialog(String dialog) {
        getRequestContext().execute("PF('" + dialog + "').hide();");
    }

    public static void atualizarComponente(String componente) {
        getRequestContext().update(componente);
    }

    public static void abrirDialogAtualizado(String nomeDialog) {
//        atualizarComponente(FORM+nomeDialog);
//        abrirDialog(DLG+nomeDialog);
    }

    public static void abrirDialog(String dialog) {
        getRequestContext().execute("PF('" + dialog + "').show();");
    }

    private static RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }

    public static void redirecionarParaPage(String page) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        context.getExternalContext().redirect(url + "/" + page + ".faces");
    }

    public static void mensagemDeSucesso(String mensagem) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "Sucesso"));
    }

    public static void mensagemDeSucesso(Exception e) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), "Sucesso"));
    }

    public static void mensagemDeAlerta(String mensagem) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, "Atenção!"));
    }

    public static void mensagemDeErro(String mensagem) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "Erro"));
    }
}
