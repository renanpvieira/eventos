/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

/**
 *
 * @author Renan.Vieira
 */
public interface ILoginDao<T> {
    T buscarByLogin(String login);
}
