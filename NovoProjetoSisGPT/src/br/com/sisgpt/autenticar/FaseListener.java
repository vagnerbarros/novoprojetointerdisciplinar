package br.com.sisgpt.autenticar;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.hibernate.Session;

import br.com.sisgpt.util.FacesContextUtil;
import br.com.sisgpt.util.HibernateUtil;


public class FaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;
		
	
	@Override
	public void beforePhase(PhaseEvent fase) {
		
		if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			
			/*	
			LogarBean logarBean = (LogarBean) FacesContextUtil.getSessionAttribute("logarBean");
			if(logarBean == null || !logarBean.isAutenticado() || 
					!logarBean.getFuncionario().getCpf_matricula().getFuncionario().isDadosConfirmado()){
				FacesContextUtil.setNavegacao("login");
			}
			else{
				if(logarBean.isAutenticado() && logarBean.getAcao().equals("atualizacao") && logarBean.getFuncionario() == null){
					FacesContextUtil.setNavegacao("login");
				}
			}
			*/
		}
		
		if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
			Session session = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			FacesContextUtil.setRequestSession(session);
		}	
	}
	
	@Override
	public void afterPhase(PhaseEvent fase) {
		if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			Session session = FacesContextUtil.getRequestSession();
			try{
				session.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Erro no commit da transação: "+e.getMessage());
				System.out.println("Erro no commit da transação: "+e.getCause());
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}	
			}finally{
				session.close();
			}
		}	
	}

	@Override
	public PhaseId getPhaseId() {
		//O FaseListener será invocado em todas as fases
		return PhaseId.ANY_PHASE;
	}

}
