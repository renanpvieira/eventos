/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import java.util.List;

/**
 *
 * @author pc_renan
 */
public interface IService<T> {
    	
	void salvar(T classe);
	void atualizar(T classe);
	void deletarById(int id);
	List<T> buscarTodos(); 
	T buscarById(int id);
        
}
