/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package au.edu.qtac.testcluster;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
@Named
@SessionScoped
public class LoginBean implements java.io.Serializable {

    private String userName;
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String login() throws ServletException {
        final FacesContext context = FacesContext.getCurrentInstance();
        final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        System.out.println("===login happening===");
        request.login(userName, password);
        System.out.println("sessionid: " + request.getSession().getId());
        return "index";
    }
}
