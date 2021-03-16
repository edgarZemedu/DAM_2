/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditorTexto;

import Examen1ºEv.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author A C E R
 */
class TextFilter extends FileFilter{

    @Override
    public boolean accept(File file) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(file.getAbsolutePath().endsWith(".txt") || file.getAbsolutePath().endsWith(".rtf")
          || file.getAbsolutePath().endsWith(".java")  || file.isDirectory()){            
            return true;
            
        }else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "Archivos de texto";        
    }
    
    
}
