package com.livro.capitulo4.web.filter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.livro.capitulo4.model.util.HibernateUtil;

@WebFilter(urlPatterns = { "*.jsf" })
public class ConexaoHibernateFilter implements Filter {
	private SessionFactory sf;

	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws ServletException {

		Session currentSession = this.sf.getCurrentSession();

		Transaction transaction = null;

		try {
			System.out.println("(ConexaoHibernateFilter) >> filter herer....");
			transaction = currentSession.beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			transaction.commit();
			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable ex) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

	public void destroy() {
	}
}