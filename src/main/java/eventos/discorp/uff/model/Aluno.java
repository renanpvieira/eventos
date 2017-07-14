/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */

@Entity
@Table(name="Aluno")
@PrimaryKeyJoinColumn(name="UsuarioId")
public class Aluno extends Usuario {

    /**
     * @return the Matricula
     */
    public String getMatricula() {
        return Matricula;
    }

    /**
     * @param Matricula the Matricula to set
     */
    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }
    
    @Size(min=5, max=255)
    @Column(name = "Matricula", nullable = true)
    private String Matricula;
    
    
}
