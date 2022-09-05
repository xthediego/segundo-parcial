
package grud;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class clientes {
    public Connection conexion;
    
    
    private final String puerto= "3308";
    public final String bd = "conexion";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto, bd);
    public final String usuario = "conexion";
    public final String contra = "abcd123";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    public Connection abrir_conexion(){
        
        try{
            Class.forName(jdbc);
            conexion = DriverManager.getConnection(urlConexion,usuario,contra);
            JOptionPane.showMessageDialog(null,"Conexion Exitosa...","Exito",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            System.out.println("error..." + ex.getMessage());
            
        }
        return conexion;
        
    }
    
    public void cerrar_conexion(){
        
         try{
            
            conexion.close();
            
            
        }catch(SQLException ex){
            System.out.println("error..." + ex.getMessage());
            
        }
        
    }
  
    public static void main(String[] args){
    
        form app = new form();
        app.show();
    
    }
   
 
}
