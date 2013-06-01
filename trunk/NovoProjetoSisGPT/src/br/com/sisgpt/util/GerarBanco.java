package br.com.sisgpt.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.sisgpt.dominio.Funcao;
import br.com.sisgpt.dominio.Setor;
import br.com.sisgpt.dominio.Turno;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;

public class GerarBanco {
    public static void main (String [] args){
        try {
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            cfg.configure();
            SchemaExport se = new SchemaExport(cfg);
            se.create(true, true);
            
            Operario o = new Operario();
            o.setFuncao(Funcao.GERENTE);
            o.setLogin("c");
            o.setNome("Cristiano");
            o.setObservacao("Dono do projeto");
            o.setSenha("c");
            o.setSetor(Setor.ACABAMENTO);
            o.setTurno(Turno.COMERCIAL);
            Fachada fachada = Fachada.obterInstancia();
            fachada.cadastroOperario().operarioCadastrar(o);
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
