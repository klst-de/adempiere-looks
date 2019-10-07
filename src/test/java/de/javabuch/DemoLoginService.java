package de.javabuch;

import org.jdesktop.swingx.auth.LoginService;

/**
 * A {@code LoginService} that can be modified to allow or disallow logins. Only useful for
 * demonstration purposes.
 * 
 * @author Karl George Schaefer
 */
// aus package org.jdesktop.swingx.demos.loginpane;
public class DemoLoginService extends LoginService {
    private boolean validLogin;
    
    /**
     * Constructs the default service.
     */
    public DemoLoginService() {
        setSynchronous(true);
    }
    
    /**
     * @return the validLogin
     */
    public boolean isValidLogin() {
        return validLogin;
    }

    /**
     * @param validLogin the validLogin to set
     */
    public void setValidLogin(boolean validLogin) {
        this.validLogin = validLogin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean authenticate(String name, char[] password, String server) throws Exception {
        return isValidLogin();
    }

}
