package conexion;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.tesoreria.Usuario;

public class ConexionLdap {
	private String usuario;
	  
	  private String clave;
	  
	  private String servidor;
	  
	  private String dn;
	  
	  private String tipoAuth;
	  
	  private boolean autenticado;
	  
	  DirContext dc;
	  
	  public ConexionLdap(String servidor, String dn, String tipoAuth, String usuario, String clave) {
	    this.usuario = usuario;
	    this.clave = clave;
	    this.servidor = servidor;
	    this.dn = dn;
	    this.tipoAuth = tipoAuth;
	    inicializarConexion();
	  }
	  
	  public ConexionLdap() {}
	  
	  public void inicializarConexion() {
	    Hashtable<String, String> env = new Hashtable<>();
	    env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
	    env.put("java.naming.provider.url", this.servidor);
	    env.put("java.naming.security.authentication", this.tipoAuth);
	    env.put("java.naming.security.principal", this.dn);
	    env.put("java.naming.security.credentials", this.clave);
	    System.out.println("servidor: " + this.servidor);
	    System.out.println("tipoAuth: " + this.tipoAuth);
	    System.out.println("dn: " + this.dn);
	    System.out.println("clave: " + this.clave);
	    try {
	      this.dc = new InitialDirContext(env);
	      setAutenticado(true);
	      DirContext ctx = new InitialDirContext(env);
	      Attributes answer = ctx.getAttributes("CN=ldap,OU=LDAP,DC=subsecretaria,DC=dominio");
	      printAttrs(answer);
	    } catch (NamingException ex) {
	      System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
	      setAutenticado(false);
	    } 
	  }
	  
	  public static void printAttrs(Attributes attrs) {
	    System.out.println("Prueba Impresion Atributos");
	    if (attrs == null) {
	      System.out.println("No attributes");
	    } else {
	      try {
	        for (NamingEnumeration<?> ae = attrs.getAll(); ae.hasMore(); ) {
	          Attribute attr = (Attribute)ae.next();
	          if (attr.getID().compareTo("sAMAccountName") == 0) {
	            System.out.println("attribute: " + attr.getID());
	            for (NamingEnumeration<?> e = attr.getAll(); e.hasMore(); System.out.println("value: " + e.next()));
	            continue;
	          } 
	          System.out.println("no impreso" + attr.getID());
	        } 
	      } catch (NamingException e) {
	        e.printStackTrace();
	      } 
	    } 
	  }
	  
	  public String getUsuario() {
	    return this.usuario;
	  }
	  
	  public void setUsuario(String usuario) {
	    this.usuario = usuario;
	  }
	  
	  public boolean isAutenticado() {
	    return this.autenticado;
	  }
	  
	  public void setAutenticado(boolean autenticado) {
	    this.autenticado = autenticado;
	  }
	  
	  public static boolean authenticate(String username, String password) {
	    System.out.println("Funcion para encontrar usuario LDAP");
	    System.out.println("Dominio a buscar: subsecretaria.dominio");
	    if (username.length() > 0 && password.length() > 0) {
	      Hashtable<String, String> env = new Hashtable<>();
	      env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
	      env.put("java.naming.provider.url", "ldap://subsecretaria.dominio:389/DC=subsecretaria,DC=dominio");
	      env.put("java.naming.security.authentication", "simple");
	      String dnuser = dnFromUser(username);
	      Boolean busqueda = Boolean.valueOf(false);
	      int valor = 0;
	      if (dnuser == "") {
	        System.out.println("Error al buscar el usuario");
	        busqueda = Boolean.valueOf(false);
	      } else if (dnuser == "Usuario no encontrado") {
	        System.out.println("Verificar el nombre de usuario 247 / 248");
	        busqueda = Boolean.valueOf(false);
	      } else {
	        env.put("java.naming.security.principal", dnuser);
	        env.put("java.naming.security.credentials", password);
	        valor = 1;
	      } 
	      if (valor == 1)
	        try {
	          DirContext ctx = new InitialDirContext(env);
	          System.out.println("Se validaron las credenciales correctamente");
	          busqueda = Boolean.valueOf(true);
	        } catch (NamingException ex) {
	          System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
	          busqueda = Boolean.valueOf(false);
	        }  
	      if (!busqueda.booleanValue()) {
	    	  Usuario us = Usuario.getUsuario(username);
	        //Usuario us = Usuario.getUsuario(username);
	        String tEnc = DigestUtils.md5Hex(password);
	        if (us != null) {
	          if (!us.getActive_directory().booleanValue()) {
	            busqueda = Boolean.valueOf(Usuario.Authenticate(us, tEnc));
	          } else {
	            busqueda = Boolean.valueOf(false);
	          } 
	        } else {
	          busqueda = Boolean.valueOf(false);
	        } 
	      } 
	      return busqueda.booleanValue();
	    } 
	    return false;
	  }
	  
	  public static String dnFromUser(String username) {
	    System.out.println("Username " + username);
	    Hashtable<String, String> env = new Hashtable<>();
	    env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
	    env.put("java.naming.provider.url", "ldap://subsecretaria.dominio:389/DC=subsecretaria,DC=dominio");
	    env.put("java.naming.security.authentication", "simple");
	    env.put("java.naming.security.principal", "ldap");
	    env.put("java.naming.security.credentials", "0P9o8i7u&");
	    DirContext dirContext = null;
	    String dn = "";
	    try {
	      dirContext = new InitialDirContext(env);
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
	        System.out.println("1 " + searchResult.hasMoreElements());
	        NamingEnumeration<? extends Attribute> attr3 = ((SearchResult)searchResult.next()).getAttributes().getAll();
	        while (attr3.hasMore()) {
	          Attribute attr = attr3.next();
	          String attrId = attr.getID();
	          String attrValue = (String)attr.get();
	          System.out.println("atributo: " + attrValue + " id " + attrId);
	          result.put(attrId, attrValue);
	          if (attrId.compareTo("distinguishedName") == 0) {
	            dn = attrValue;
	            System.out.println(attrValue);
	          } 
	        } 
	      } 
	    } catch (NamingException ex) {
	      System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
	    } 
	    return dn;
	  }
}
