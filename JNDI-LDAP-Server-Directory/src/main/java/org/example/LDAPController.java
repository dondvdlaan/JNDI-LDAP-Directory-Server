package org.example;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class LDAPController {

    public DirContext getConnection(){

        Hashtable<String, Object> env = new Hashtable<String, Object>();
        DirContext ctx = null;

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389/dc=example,dc=com");
        //env.put(Context.SECURITY_AUTHENTICATION, "simple");
        //env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com");
        //env.put(Context.SECURITY_CREDENTIALS, "LDAP2804");

        try{
            ctx = new InitialDirContext(env);

        }catch (AuthenticationException e) {
            System.out.println("Foutje auth: " + e.getMessage() );
        }
        catch(NamingException n){
            System.out.println("Foutje naam: " + n.getMessage() );
        }
    return ctx;
    }

}
