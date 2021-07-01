/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelUsuario;
import util.ConexaoSQLite;
import java.sql.ResultSet;
/**
 *
 * @author jonat
 */
public class DAOUsuario extends ConexaoSQLite {

    public boolean salvarUsuarioDAO(ModelUsuario pModelUsuario){
     conectar();
     String sql="INSERT INTO tbl_usuario ("
             + "usu_nome,"
             + "usu_login, "
             + "usu_senha)"
             + "VALUES(?,?,?)";
    PreparedStatement preparedStatment = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatment.setString(1, pModelUsuario.getUsuarioNome());
            preparedStatment.setString(2, pModelUsuario.getUsuarioLogin());
            preparedStatment.setString(3, pModelUsuario.getUsuarioSenha());
            preparedStatment.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
     desconectar();
     return true;
    } 
    public List<ModelUsuario> getListaUsuarioDAO(){
        List<ModelUsuario> listaUsuario= new ArrayList<>();
        ModelUsuario modelUsuario = new ModelUsuario();
        conectar();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        
        String sql = "SELECT pk_usu_id, "
                + "usu_nome,"
                + "usu_login,"
                + "usu_senha"
                + "FROM tbl_usuario";
        
        try {
            preparedStatement= criarPreparedStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuarioId(resultSet.getInt(1));
                modelUsuario.setUsuarioNome(resultSet.getString(2));
                modelUsuario.setUsuarioLogin(resultSet.getString(3));
                modelUsuario.setUsuarioSenha(resultSet.getString(4));
                listaUsuario.add(modelUsuario);
            }
                    
        } catch (Exception e) {
            System.out.println("Erro!");
        }
        desconectar();
        return listaUsuario;
        
    }
    
}
