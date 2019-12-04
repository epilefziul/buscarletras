package main.letras.util;

import javax.faces.context.FacesContext;

public class SessionUtil {

    public static String OBJ_USUARIO = "obj_usuario";

    public static void adicionaObjetoUsuarioNaSessao(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }

    public static Object recuperaObjetoDaSessao(String objeto) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(objeto);
    }

    public static void encerrarSessao() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
