/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.PerdidaGarrafones;

/**
 *
 * @author BONIFACIO
 */
@Stateless
public class PerdidaGarrafonesFacade extends AbstractFacade<PerdidaGarrafones> {

    @PersistenceContext(unitName = "ProyectoConstanciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerdidaGarrafonesFacade() {
        super(PerdidaGarrafones.class);
    }
    
}
