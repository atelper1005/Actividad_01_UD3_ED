/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] buffer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream Corriente_Entrada = null;
    private static BufferedInputStream Buffer_Entrada = null;

    public static void inicializarArchivos() throws FileNotFoundException
    {
        Corriente_Entrada = new FileInputStream(nombreArchivo);
        Buffer_Entrada = new BufferedInputStream(Corriente_Entrada);
    }
    
    public static int mostrarTextoArchivo() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = Corriente_Entrada.read(buffer)) != -1) 
        {
            System.out.println(new String(buffer));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarTextoArchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( Buffer_Entrada != null && Corriente_Entrada != null )
                {
                    Corriente_Entrada.close();
                    Buffer_Entrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
