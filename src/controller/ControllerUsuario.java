/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOUsuario;
import java.util.List;
import model.ModelUsuario;

/**
 *
 * @author jonat
 */
public class ControllerUsuario {
   /*AQUI SALVA UM NOVO USUÁRIO NO BANCO DE DADOS!
    @param modelUsuario
    @return boolean
*/
    DAOUsuario dAOUsuario=  new DAOUsuario();
    
    public boolean salvarUsuarioController(ModelUsuario modelUsuario) {
        return this.dAOUsuario.salvarUsuarioDAO(modelUsuario);
    }
//Retorna a lista criada no DAO com as informações que serão mostradas na tabela
    public List<ModelUsuario> getLoadUsuarioController() {
        return dAOUsuario.getListaUsuarioDAO();
    }
    
}
