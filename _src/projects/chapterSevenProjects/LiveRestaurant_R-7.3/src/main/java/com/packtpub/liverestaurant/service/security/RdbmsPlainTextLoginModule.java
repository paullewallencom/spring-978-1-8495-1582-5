package com.packtpub.liverestaurant.service.security;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;





public class RdbmsPlainTextLoginModule implements LoginModule {

    private Subject subject;

    private CallbackHandler callbackHandler;

    private boolean success;

    private List<RdbmsPrincipal> principals = new ArrayList<RdbmsPrincipal>();
    private List<RdbmsCredential> credentials = new ArrayList<RdbmsCredential>();


	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
	       this.subject = subject;
	        this.callbackHandler = callbackHandler;
	}

	@Override
	public boolean login() throws LoginException {
		RdbmsCredential credential=new RdbmsCredential();
		Callback[] callbacks = new Callback[] {
                new NameCallback("Username: "),
                new PasswordCallback("Password: ", false) };
        try {
			callbackHandler.handle(callbacks);
	        String username = ((NameCallback)callbacks[0]).getName();
	        String password = new String(((PasswordCallback)callbacks[1]).getPassword());
	        
	        success = authenticate(username, password);

            callbacks[0] = null;
            callbacks[1] = null;

            if (!success) {
                throw new LoginException("Authentication failed: Usernamr/Password is incorrect");
            }
            List<String> allPermissions=getAllPermission(username);
			Iterator<String> it=allPermissions.iterator();
			while(it.hasNext()){
				String permission=(String) it.next();
				credential.setProperty(permission, permission);
				
			}
			credentials.add(credential);
            return true;
			
			
		}  catch (LoginException ex) {
            throw ex;
        }
        catch (Exception ex) {
            success = false;
            throw new LoginException(ex.getMessage());
        }
	}
	
	   private List<String> getAllPermission(String username) {
		   List allPermissions=new ArrayList<String>();
		   /**
		    * permission is hard-code here, but  it should read from database, in a real environment
		    */
		   allPermissions.add("HAS_READ_ALL_DATA_PERMISSION");
		   return  allPermissions;
	}

	private boolean  authenticate(String username,String password)
	      {
		   
		   /**
		    * username and password  are hard-code here, but  it should query database, in a real environment
		    */
		     if ("clinetUser".equals(username) && "pass".equals(password)) {
		            this.principals.add(new RdbmsPrincipal(username));
		            return true;
		        }
		        else {
		            return false;
		        }
		   
	      }

	
	public boolean commit() throws LoginException {
	     
		if (success) {

            if (subject.isReadOnly()) {
                throw new LoginException ("Subject is Readonly");
            }

            try {
               
                
           

                subject.getPrincipals().addAll(principals);
                subject.getPublicCredentials().addAll(credentials);

                principals.clear();
                credentials.clear();
             



                return(true);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
                throw new LoginException(ex.getMessage());
            }
        } else {
        	principals.clear();
            credentials.clear();
            return true;
        }
	}

    public boolean abort() {
        success = false;
        try {
			logout();
		} catch (LoginException e) {
			e.printStackTrace();
		}
        return true;
    }

	@Override
	public boolean logout() throws LoginException {
	      principals.clear();

	        Iterator iterator = subject.getPrincipals(RdbmsPrincipal.class).iterator();
	        while (iterator.hasNext()) {
	        	RdbmsPrincipal principal = (RdbmsPrincipal) iterator.next();
	            subject.getPrincipals().remove(principal);
	        }

	        return true;
	}

}
