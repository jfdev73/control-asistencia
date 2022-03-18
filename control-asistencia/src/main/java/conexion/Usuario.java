package conexion;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Usuario {
  private int status;
  
  private int usuarios_asign_id;
  
  private int usuario_id;
  
  private int cargos_id;
  
  private int nivel_cargo;
  
  private int uni_id;
  
  private int nick_id;
  
  private String nombre;
  
  private String ap_pat;
  
  private String ap_mat;
  
  private String descripcion_cargo;
  
  private String clave_uni;
  
  private String descripcion_uni;
  
  private String nickuser;
  
  private Date creado_en;
  
  private Date modificado_en;
  
  private String creado_por;
  
  private String modificado_por;
  
  private Boolean active_directory;
  
  private Boolean cuenta_expirada;
  
  private int elemento_autorizado_id;
  
  private int elemento_id;
  
  private int status_elemento;
  
  private int perfil;
  
  private String descripcion_elemento;
  
  private Boolean visible;
  
  private int sistema_id;
  
  private int usuario_perfil_id;
  
  private int status_sistema;
  
  private String descripcion_sistema;
  
  private int email_id;
  
  private int status_email;
  
  private String email;
  
  private String comentarios;
  
  private int imagen_id;
  
  private String mime_type;
  
  private String file_name;
  
  private Timestamp last_update;
  
  private InputStream archivoe;
  
  private byte[] bytes;
 
  
  public Usuario() {}
  
  public Usuario(int status, int usuarios_asign_id, int usuario_id, int cargos_id, int nivel_cargo, int uni_id, int nick_id, String nombre, String ap_pat, String ap_mat, String descripcion_cargo, String clave_uni, String descripcion_uni, String nickuser, Date creado_en, Date modificado_en, String creado_por, String modificado_por, Boolean active_directory, Boolean cuenta_expirada, int elemento_autorizado_id, int elemento_id, int status_elemento, int perfil, String descripcion_elemento, Boolean visible, int sistema_id, int usuario_perfil_id, int status_sistema, String descripcion_sistema) {
    this.status = status;
    this.usuarios_asign_id = usuarios_asign_id;
    this.usuario_id = usuario_id;
    this.cargos_id = cargos_id;
    this.nivel_cargo = nivel_cargo;
    this.uni_id = uni_id;
    this.nick_id = nick_id;
    this.nombre = nombre;
    this.ap_pat = ap_pat;
    this.ap_mat = ap_mat;
    this.descripcion_cargo = descripcion_cargo;
    this.clave_uni = clave_uni;
    this.descripcion_uni = descripcion_uni;
    this.nickuser = nickuser;
    this.creado_en = creado_en;
    this.modificado_en = modificado_en;
    this.creado_por = creado_por;
    this.modificado_por = modificado_por;
    this.active_directory = active_directory;
    this.cuenta_expirada = cuenta_expirada;
    this.elemento_autorizado_id = elemento_autorizado_id;
    this.elemento_id = elemento_id;
    this.status_elemento = status_elemento;
    this.perfil = perfil;
    this.descripcion_elemento = descripcion_elemento;
    this.visible = visible;
    this.sistema_id = sistema_id;
    this.usuario_perfil_id = usuario_perfil_id;
    this.status_sistema = status_sistema;
    this.descripcion_sistema = descripcion_sistema;
  }
  
  public int getStatus_elemento() {
    return this.status_elemento;
  }
  
  public void setStatus_elemento(int status_elemento) {
    this.status_elemento = status_elemento;
  }
  
  public int getSistema_id() {
    return this.sistema_id;
  }
  
  public void setSistema_id(int sistema_id) {
    this.sistema_id = sistema_id;
  }
  
  public int getStatus_sistema() {
    return this.status_sistema;
  }
  
  public void setStatus_sistema(int status_sistema) {
    this.status_sistema = status_sistema;
  }
  
  public int getPerfil() {
    return this.perfil;
  }
  
  public void setPerfil(int perfil) {
    this.perfil = perfil;
  }
  
  public int getElemento_id() {
    return this.elemento_id;
  }
  
  public void setElemento_id(int elemento_id) {
    this.elemento_id = elemento_id;
  }
  
  public int getElemento_autorizado_id() {
    return this.elemento_autorizado_id;
  }
  
  public void setElemento_autorizado_id(int elemento_autorizado_id) {
    this.elemento_autorizado_id = elemento_autorizado_id;
  }
  
  public String getDescripcion_elemento() {
    return this.descripcion_elemento;
  }
  
  public void setDescripcion_elemento(String descripcion_elemento) {
    this.descripcion_elemento = descripcion_elemento;
  }
  
  public String getDescripcion_sistema() {
    return this.descripcion_sistema;
  }
  
  public void setDescripcion_sistema(String descripcion_sistema) {
    this.descripcion_sistema = descripcion_sistema;
  }
  
  public Boolean getVisible() {
    return this.visible;
  }
  
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }
  
  public int getStatus() {
    return this.status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public int getUsuario_asign_id() {
    return this.usuarios_asign_id;
  }
  
  public void setUsuario_asign_id(int usuarios_asign_id) {
    this.usuarios_asign_id = usuarios_asign_id;
  }
  
  public int getUsuario_id() {
    return this.usuario_id;
  }
  
  public void setUsuario_id(int usuario_id) {
    this.usuario_id = usuario_id;
  }
  
  public int getCargos_id() {
    return this.cargos_id;
  }
  
  public void setCargos_id(int cargos_id) {
    this.cargos_id = cargos_id;
  }
  
  public int getNivel_cargo() {
    return this.nivel_cargo;
  }
  
  public void setNivel_cargo(int nivel_cargo) {
    this.nivel_cargo = nivel_cargo;
  }
  
  public int getUni_id() {
    return this.uni_id;
  }
  
  public void setUni_id(int uni_id) {
    this.uni_id = uni_id;
  }
  
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getAp_pat() {
    return this.ap_pat;
  }
  
  public void setAp_pat(String ap_pat) {
    this.ap_pat = ap_pat;
  }
  
  public String getAp_mat() {
    return this.ap_mat;
  }
  
  public void setAp_mat(String ap_mat) {
    this.ap_mat = ap_mat;
  }
  
  public String getDescripcion_cargo() {
    return this.descripcion_cargo;
  }
  
  public void setDescripcion_cargo(String descripcion_cargo) {
    this.descripcion_cargo = descripcion_cargo;
  }
  
  public String getClave_uni() {
    return this.clave_uni;
  }
  
  public void setClave_uni(String clave_uni) {
    this.clave_uni = clave_uni;
  }
  
  public String getDescripcion_uni() {
    return this.descripcion_uni;
  }
  
  public void setDescripcion_uni(String descripcion_uni) {
    this.descripcion_uni = descripcion_uni;
  }
  
  public Date getCreado_en() {
    return this.creado_en;
  }
  
  public void setCreado_en(Date creado_en) {
    this.creado_en = creado_en;
  }
  
  public Date getModificado_en() {
    return this.modificado_en;
  }
  
  public void setModificado_en(Date modificado_en) {
    this.modificado_en = modificado_en;
  }
  
  public String getCreado_por() {
    return this.creado_por;
  }
  
  public void setCreado_por(String creado_por) {
    this.creado_por = creado_por;
  }
  
  public String getModificado_por() {
    return this.modificado_por;
  }
  
  public void setModificado_por(String modificado_por) {
    this.modificado_por = modificado_por;
  }
  
  public int getUsuarios_asign_id() {
    return this.usuarios_asign_id;
  }
  
  public void setUsuarios_asign_id(int usuarios_asign_id) {
    this.usuarios_asign_id = usuarios_asign_id;
  }
  
  public int getUsuario_perfil_id() {
    return this.usuario_perfil_id;
  }
  
  public void setUsuario_perfil_id(int usuario_perfil_id) {
    this.usuario_perfil_id = usuario_perfil_id;
  }
  
  public Boolean getActive_directory() {
    return this.active_directory;
  }
  
  public void setActive_directory(Boolean active_directory) {
    this.active_directory = active_directory;
  }
  
  public String getNickuser() {
    return this.nickuser;
  }
  
  public void setNickuser(String nickuser) {
    this.nickuser = nickuser;
  }
  
  public int getNick_id() {
    return this.nick_id;
  }
  
  public void setNick_id(int nick_id) {
    this.nick_id = nick_id;
  }
  
  public Boolean getCuenta_expirada() {
    return this.cuenta_expirada;
  }
  
  public void setCuenta_expirada(Boolean cuenta_expirada) {
    this.cuenta_expirada = cuenta_expirada;
  }
  
  public int getEmail_id() {
    return this.email_id;
  }
  
  public void setEmail_id(int email_id) {
    this.email_id = email_id;
  }
  
  public int getStatus_email() {
    return this.status_email;
  }
  
  public void setStatus_email(int status_email) {
    this.status_email = status_email;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getComentarios() {
    return this.comentarios;
  }
  
  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }
  
  public int getImagen_id() {
    return this.imagen_id;
  }
  
  public void setImagen_id(int imagen_id) {
    this.imagen_id = imagen_id;
  }
  
  public String getMime_type() {
    return this.mime_type;
  }
  
  public void setMime_type(String mime_type) {
    this.mime_type = mime_type;
  }
  
  public String getFile_name() {
    return this.file_name;
  }
  
  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }
  
  public Timestamp getLast_update() {
    return this.last_update;
  }
  
  public void setLast_update(Timestamp last_update) {
    this.last_update = last_update;
  }
  
  public InputStream getArchivoe() {
    return this.archivoe;
  }
  
  public void setArchivoe(InputStream archivoe) {
    this.archivoe = archivoe;
  }
  
  public byte[] getBytes() {
    return this.bytes;
  }
  
  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }
  
  public static Usuario getUsuario(String usuario) {
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    Usuario u = null;
    try {
      st = con.createStatement();
      sql = "select ua.usuarios_asign_id  , ua.status  , u.usuario_id  ,(u.nombre||' '||u.ap_pat||' '||u.ap_mat) nombre , u.ap_pat  , u.ap_mat  , ucc.cargos_id  , ucc.descripcion  , ucc.nivel  , uua.uni_id  , uua.clave  , uua.descripcion  , ua.creado_en  , ua.creado_por  , ua.modificado_en  , ua.modificado_por  , uca.nick_id  , uca.nickuser  , uca.active_directory , uca.cuenta_expirada  from inventario.usuarios_asign ua  , inventario.usuarios u  , inventario.usuarios_c_cargos ucc  , inventario.usuarios_uni_admva uua  , inventario.usuarios_cuentas_acceso uca  where ua.usuarios_usuario_id=u.usuario_id  and ua.usuarios_c_cargos_cargos_id=ucc.cargos_id  and ucc.unidad_admin=uua.uni_id  and uca.usuarios_usuario_id = u.usuario_id and uca.nickuser='" + 
        
        usuario.toUpperCase() + "'" + 
        " and uca.status=1 " + 
        " and ua.status=1 ";
      res = st.executeQuery(sql);
      if (res.next()) {
        u = new Usuario();
        u.setUsuario_asign_id(res.getInt(1));
        u.setStatus(res.getInt(2));
        u.setUsuario_id(res.getInt(3));
        u.setNombre(res.getString(4));
        u.setAp_pat(res.getString(5));
        u.setAp_mat(res.getString(6));
        u.setCargos_id(res.getInt(7));
        u.setDescripcion_cargo(res.getString(8));
        u.setNivel_cargo(res.getInt(9));
        u.setUni_id(res.getInt(10));
        u.setClave_uni(res.getString(11));
        u.setDescripcion_uni(res.getString(12));
        u.setCreado_en(res.getDate(13));
        u.setCreado_por(res.getString(14));
        u.setModificado_en(res.getDate(15));
        u.setModificado_por(res.getString(16));
        u.setNick_id(res.getInt(17));
        u.setNickuser(res.getString(18));
        u.setActive_directory(Boolean.valueOf(res.getBoolean(19)));
        u.setCuenta_expirada(Boolean.valueOf(res.getBoolean(20)));
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (res != null)
          res.close(); 
        if (st != null)
          st.close(); 
        if (con != null)
          con.close(); 
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
    return u;
  }
  
  public static boolean Authenticate(Usuario usuario, String Pass) {
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    Boolean existe = Boolean.valueOf(false);
    try {
      st = con.createStatement();
      sql = "select nick_id from inventario.usuarios_cuentas_acceso  where nickuser='" + 
        usuario.getNickuser() + "'" + 
        " and password='" + Pass + "'" + 
        " and status=1" + 
        " and active_directory = FALSE";
      res = st.executeQuery(sql);
      if (res.next())
        existe = Boolean.valueOf(true); 
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (res != null)
          res.close(); 
        if (st != null)
          st.close(); 
        if (con != null)
          con.close(); 
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
    return existe.booleanValue();
  }
  
  public static Usuario getUsuAsignUsuarioAct(Integer id) {
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    Usuario ca = null;
    try {
      st = con.createStatement();
      sql = "select ua.usuarios_asign_id  , ua.status  , u.usuario_id  ,(u.nombre||' '||u.ap_pat||' '||u.ap_mat) nombre , u.ap_pat  , u.ap_mat  , ucc.cargos_id  , ucc.descripcion  , ucc.nivel  , uua.uni_id  , uua.clave  , uua.descripcion  , ua.creado_en  , ua.creado_por  , ua.modificado_en  , ua.modificado_por  , uca.nickuser  , uca.active_directory from inventario.usuarios_asign ua  , inventario.usuarios u  , inventario.usuarios_c_cargos ucc  , inventario.usuarios_uni_admva uua  , inventario.usuarios_cuentas_acceso uca  where ua.usuarios_usuario_id=u.usuario_id  and ua.usuarios_c_cargos_cargos_id=ucc.cargos_id  and ucc.unidad_admin=uua.uni_id  and uca.usuarios_usuario_id = u.usuario_id and ua.usuarios_usuario_id=" + 
        
        id + 
        " and uca.status=1 " + 
        " and ua.status=1 ";
      res = st.executeQuery(sql);
      while (res.next()) {
        ca = new Usuario();
        ca.setUsuario_asign_id(res.getInt(1));
        ca.setStatus(res.getInt(2));
        ca.setUsuario_id(res.getInt(3));
        ca.setNombre(res.getString(4));
        ca.setAp_pat(res.getString(5));
        ca.setAp_mat(res.getString(6));
        ca.setCargos_id(res.getInt(7));
        ca.setDescripcion_cargo(res.getString(8));
        ca.setNivel_cargo(res.getInt(9));
        ca.setUni_id(res.getInt(10));
        ca.setClave_uni(res.getString(11));
        ca.setDescripcion_uni(res.getString(12));
        ca.setCreado_en(res.getDate(13));
        ca.setCreado_por(res.getString(14));
        ca.setModificado_en(res.getDate(15));
        ca.setModificado_por(res.getString(16));
        ca.setNickuser(res.getString(17));
        ca.setActive_directory(Boolean.valueOf(res.getBoolean(18)));
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (res != null)
          res.close(); 
        if (st != null)
          st.close(); 
        if (con != null)
          con.close(); 
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
          try {
              if (res != null)
                res.close(); 
              if (st != null)
                st.close(); 
              if (con != null)
                con.close(); 
            } catch (SQLException e) {
              e.printStackTrace();
            } 
          } 
    } 
    return ca;
  }
  
  public static Usuario getVerificarElemento(Usuario uea, Integer uel) {
    Connection con = ConexionP.getConexion();
    String sql = "";
    try {
      Statement st = con.createStatement();
      sql = "select uea.elemento_autorizado_id, uea.visible, uea.creado_en, uea.creado_por, uea.modificado_en, uea.modificado_por, uea.usuario, uea.elemento, (u.nombre||' '||u.ap_pat||' '||u.ap_mat) nombre, se.descripcion, se.status, s.sistemas_id, s.descripcion, s.status, uea.perfil from inventario.usuarios_elementos_autorizados uea, inventario.usuarios u, inventario.sistemas s, inventario.sistemas_elementos se where s.sistemas_id=se.sistema and se.elemento_id=uea.elemento and u.usuario_id=uea.usuario and uea.visible ='t' and u.usuario_id = " + 
        
        uea.getUsuario_id() + 
        " and uea.elemento = " + uel;
      ResultSet res = st.executeQuery(sql);
      if (res.next()) {
        uea.setElemento_autorizado_id(res.getInt(1));
        uea.setVisible(Boolean.valueOf(res.getBoolean(2)));
        uea.setUsuario_id(res.getInt(7));
        uea.setElemento_id(res.getInt(8));
        uea.setNombre(res.getString(9));
        uea.setDescripcion_elemento(res.getString(10));
        uea.setStatus_elemento(res.getInt(11));
        uea.setSistema_id(res.getInt(12));
        uea.setDescripcion_sistema(res.getString(13));
        uea.setStatus_sistema(res.getInt(14));
        uea.setPerfil(res.getInt(15));
      } 
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return uea;
  }
  
  public static Usuario getVerificarPerfil(Usuario uid, Integer sistema) {
    Connection con = ConexionP.getConexion();
    String sql = "";
    try {
      Statement st = con.createStatement();
      sql = " select p.perfil_id, p.descripcion, p.sistema  from inventario.usuarios_perfiles up,  inventario.perfiles p  where up.perfil=p.perfil_id  and p.status=1  and p.sistema=" + 
        
        sistema + 
        " and up.usuario=" + uid.getUsuario_id();
      ResultSet res = st.executeQuery(sql);
      if (res.next()) {
        uid.setPerfil(res.getInt(1));
        uid.setDescripcion_sistema(res.getString(2));
        uid.setSistema_id(res.getInt(3));
      } 
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return uid;
  }
  
  public static Usuario getEmailUsuario(Usuario uid) {
    Connection con = ConexionP.getConexion();
    String sql = "";
    try {
      Statement st = con.createStatement();
      sql = " select e.email_id, lower(e.descripcion), e.status,  e.comentarios  from inventario.usuarios_email e where e.status=1 and e.usuarios_usuario_id=" + 
        
        uid.getUsuario_id();
      ResultSet res = st.executeQuery(sql);
      if (res.next()) {
        uid.setEmail_id(res.getInt(1));
        uid.setEmail(res.getString(2));
        uid.setStatus_email(res.getInt(3));
        uid.setComentarios(res.getString(4));
      } 
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return uid;
  }
  
  public static Usuario getUsuarioImagen(Integer id) {
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = null;
    Usuario u = null;
    try {
      st = con.createStatement();
      sql = "select imagen_id, archivo, usuario, file_name, mime_type, last_update from inventario.usuarios_imagenes where usuario=" + 
        
        id;
      res = st.executeQuery(sql);
      if (res.next()) {
        u = new Usuario();
        u.setImagen_id(res.getInt(1));
        u.setArchivoe(res.getBinaryStream(2));
        u.setBytes(res.getBytes(2));
        u.setUsuario_id(res.getInt(3));
        u.setFile_name(res.getString(4));
        u.setMime_type(res.getString(5));
        u.setLast_update(res.getTimestamp(6));
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (st != null)
          st.close(); 
        if (res != null)
          res.close(); 
        if (con != null)
          con.close(); 
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
    return u;
  }
}
