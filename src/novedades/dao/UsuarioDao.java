/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import java.util.List;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public interface UsuarioDao {
  java.util.List<Usuario> listarUsuario();
  public void addUsuario(Usuario a);
  public void deleteUsuario(Usuario a);
  public void upDateUsuario(Usuario a);
  public List<Usuario> getEstado(boolean estado);
  public Usuario getUsuario(int legajo);
  public Usuario getUsuarioAdministrador(String usuario,String clave);
  public Usuario getUsuarioLogin(String usuario);
}
