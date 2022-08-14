package edu.utez.mx.persona.servicios;

import edu.utez.mx.persona.modelo.BeanPersona;
import edu.utez.mx.persona.modelo.DaoPersona;
import edu.utez.mx.persona.utils.ResultAction;

import java.util.List;

public class ServicePersona {
    DaoPersona daoPersona= new DaoPersona();

    public List<BeanPersona> getAll() {
        return daoPersona.findAll();
    }
    public BeanPersona getUsuario (Long id){
        return daoPersona.findOne(id);
    }

    public ResultAction save(BeanPersona persona) {
        ResultAction result= new ResultAction();
        if(daoPersona.save(persona)){
            result.setResult(true);
            result.setMessage("Registrado correctamente");
            result.setStatus(200);
        }else{
            result.setResult(false);
            result.setMessage("Error");
            result.setStatus(400);
        }
        return result;
    }
    public ResultAction delete(Long id) {
        ResultAction result= new ResultAction();
        if(daoPersona.delete(id)){
            result.setResult(true);
            result.setMessage("Eliminado correctamente");
            result.setStatus(200);
        }else{
            result.setResult(false);
            result.setMessage("Error");
            result.setStatus(400);
        }
        return result;
    }

    public ResultAction update(BeanPersona persona) {
        ResultAction result= new ResultAction();
        if(daoPersona.update(persona)){
            result.setResult(true);
            result.setMessage("Modificación correcta");
            result.setStatus(200);
        }else{
            result.setResult(false);
            result.setMessage("Error");
            result.setStatus(400);
        }
        return result;
    }
}
