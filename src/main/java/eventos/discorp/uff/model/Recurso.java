/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */
@Entity
@Table(name="Recurso")
public class Recurso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RecursoId;

    @Size(min=3, max=50)
    @Column(name = "Descricao", nullable = false)
    private String Descricao;
        
    /**
     * @return the RecursoId
     */
    public int getRecursoId() {
        return RecursoId;
    }

    /**
     * @param RecursoId the RecursoId to set
     */
    public void setRecursoId(int RecursoId) {
        this.RecursoId = RecursoId;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Recurso))
			return false;
		Recurso other = (Recurso)obj;
		if (RecursoId != other.RecursoId)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Recurso [RecursoId=%s, Descricao=%s]", this.RecursoId, this.Descricao);
	}
    
}
