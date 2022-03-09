package conexion;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class AtributosConexion {
  private String name;
  
  private String mail;
  
  private String samaccountname;
  
  private String distinguishedname;
  
  DirContext dc;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getMail() {
    return this.mail;
  }
  
  public void setMail(String mail) {
    this.mail = mail;
  }
  
  public String getSamaccountname() {
    return this.samaccountname;
  }
  
  public void setSamaccountname(String samaccountname) {
    this.samaccountname = samaccountname;
  }
  
  public String getDistinguishedname() {
    return this.distinguishedname;
  }
  
  public void setDistinguishedname(String distinguishedname) {
    this.distinguishedname = distinguishedname;
  }
  
  public static AtributosConexion authenticate(String username) {
    AtributosConexion ac = new AtributosConexion();
    System.out.println("Funcion para encontrar usuario LDAP");
    Hashtable<String, String> env = new Hashtable<>();
    env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
    env.put("java.naming.provider.url", "ldap://subsecretaria.dominio:389/DC=subsecretaria,DC=dominio");
    env.put("java.naming.security.authentication", "simple");
    System.out.println("Username " + username);
    Hashtable<String, String> env2 = new Hashtable<>();
    env2.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
    env.put("java.naming.provider.url", "ldap://subsecretaria.dominio:389/DC=subsecretaria,DC=dominio");
    env2.put("java.naming.security.authentication", "simple");
    env2.put("java.naming.security.principal", "ldap");
    env2.put("java.naming.security.credentials", "0P9o8i7u&");
    DirContext dirContext = null;
    String dn = "";
    try {
      dirContext = new InitialDirContext(env2);
      dirContext.addToEnvironment("java.naming.referral", "follow");
      SearchControls controls = new SearchControls();
      controls.setReturningAttributes(new String[] { "distinguishedName", "unicodePwd", "name", "mail", "sAMAccountName" });
      controls.setSearchScope(2);
      NamingEnumeration<? extends SearchResult> searchResult = dirContext.search("", "(&(userPrincipalName=" + username + "@subsecretaria.dominio)(userPrincipalName=*@subsecretaria.dominio))", controls);
      if (dirContext != null)
        dirContext.close(); 
      Map<String, String> result = new HashMap<>();
      if (!searchResult.hasMore())
        dn = "Usuario no encontrado"; 
      while (searchResult.hasMore()) {
        NamingEnumeration<? extends Attribute> attr3 = ((SearchResult)searchResult.next()).getAttributes().getAll();
        while (attr3.hasMore()) {
          Attribute attr = attr3.next();
          String attrId = attr.getID();
          String attrValue = (String)attr.get();
          System.out.println("atributo: " + attrValue + " id " + attrId);
          result.put(attrId, attrValue);
          if (attrId.compareTo("distinguishedName") == 0) {
            ac.setDistinguishedname(attrValue);
            dn = attrValue;
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("name") == 0) {
            ac.setName(attrValue);
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("mail") == 0) {
            ac.setMail(attrValue);
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("sAMAccountName") == 0) {
            ac.setSamaccountname(attrValue);
            System.out.println(attrValue);
          } 
        } 
      } 
    } catch (NamingException ex) {
      System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
    } 
    if (dn == "") {
      System.out.println("Error al buscar el usuario");
    } else if (dn == "Usuario no encontrado") {
      System.out.println("Verificar el nombre de usuario");
    } 
    return ac;
  }
  
  public static AtributosConexion ModifyAttributes(AtributosConexion pac, String attribute) throws NamingException {
    AtributosConexion ac = new AtributosConexion();
    System.out.println("Funcion para encontrar usuario LDAP");
    System.out.println("Username " + pac.getSamaccountname());
    Hashtable<String, String> env2 = new Hashtable<>();
    env2.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
    env2.put("java.naming.provider.url", "ldap://subsecretaria.dominio:389/DC=subsecretaria,DC=dominio");
    env2.put("java.naming.security.authentication", "simple");
    env2.put("java.naming.security.principal", "ldap");
    env2.put("java.naming.security.credentials", "0P9o8i7u&");
    DirContext dirContext = null;
    String dn = "";
    try {
      dirContext = new InitialDirContext(env2);
      dirContext.addToEnvironment("java.naming.referral", "follow");
      SearchControls controls = new SearchControls();
      controls.setReturningAttributes(new String[] { "distinguishedName", "unicodePwd", "name", "mail", "sAMAccountName" });
      controls.setSearchScope(2);
      NamingEnumeration<? extends SearchResult> searchResult = dirContext.search("", "(&(userPrincipalName=" + pac.getSamaccountname() + "@subsecretaria.dominio)(userPrincipalName=*@subsecretaria.dominio))", controls);
      if (dirContext != null)
        dirContext.close(); 
      Map<String, String> result = new HashMap<>();
      if (!searchResult.hasMore())
        dn = "Usuario no encontrado"; 
      while (searchResult.hasMore()) {
        NamingEnumeration<? extends Attribute> attr3 = ((SearchResult)searchResult.next()).getAttributes().getAll();
        while (attr3.hasMore()) {
          Attribute attr = attr3.next();
          String attrId = attr.getID();
          String attrValue = (String)attr.get();
          System.out.println("atributo: " + attrValue + " id " + attrId);
          result.put(attrId, attrValue);
          if (attrId.compareTo("distinguishedName") == 0) {
            ac.setDistinguishedname(attrValue);
            dn = attrValue;
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("name") == 0) {
            ac.setName(attrValue);
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("mail") == 0) {
            ac.setMail(attrValue);
            System.out.println(attrValue);
          } 
          if (attrId.compareTo("sAMAccountName") == 0) {
            ac.setSamaccountname(attrValue);
            System.out.println(attrValue);
          } 
        } 
      } 
    } catch (NamingException ex) {
      System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
    } 
    if (dn == "") {
      System.out.println("Error al buscar el usuario");
    } else if (dn == "Usuario no encontrado") {
      System.out.println("Verificar el nombre de usuario");
    } else {
      System.out.println("OK");
      DirContext modify = new InitialDirContext(env2);
      System.out.println("OK2");
      ModificationItem[] mods = new ModificationItem[2];
      System.out.println("OK3");
      BasicAttribute quita = null;
      System.out.println("OK4");
      try {
        quita = new BasicAttribute("mail", "\"\"".getBytes("UTF-16LE"));
        System.out.println("OK5");
      } catch (UnsupportedEncodingException e) {
        System.out.println(e);
        e.printStackTrace();
      } 
      System.out.println("OK6");
      mods[0] = new ModificationItem(3, quita);
      System.out.println("OK7");
      String nueva = "sergio_gabriel_5@hotmail.com";
      BasicAttribute pon = null;
      System.out.println("OK8");
      try {
        pon = new BasicAttribute("mail", ("\"" + nueva + "\"").getBytes("UTF-16LE"));
        System.out.println("OK9");
      } catch (UnsupportedEncodingException e) {
        System.out.println(e);
        e.printStackTrace();
      } 
      System.out.println("OK10");
      mods[1] = new ModificationItem(1, pon);
      System.out.println("OK11");
      modify.modifyAttributes(pac.getDistinguishedname(), mods);
      System.out.println("OK12");
    } 
    return ac;
  }
}