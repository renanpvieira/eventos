/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Recurso;
import java.util.List;


/**
 *
 * @author pc_renan
 */
public interface IDao<T> {

        T buscarById(int id);
        List<T> buscarTodos();
        
	void salvar(T classe);
	void deletarById(int id);
    
}
