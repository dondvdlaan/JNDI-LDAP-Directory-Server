package org.example;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Start LDAP comm");

        LDAPController ldapController = new LDAPController();
        DirContext ctx = ldapController.getConnection();

        Attributes answer = ctx.getAttributes("uid=john, ou=People");

        for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
            Attribute attr = (Attribute)ae.next();

            /* Print each attribute */
            System.out.println("attribute: " + attr.getID());

            /* Print each value */
            for (NamingEnumeration e = attr.getAll(); e.hasMore();
                 System.out.println("value: " + e.next()));
        }

    }
}