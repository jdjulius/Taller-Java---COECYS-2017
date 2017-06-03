/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportepdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Julio
 * http://datojava.blogspot.com/2015/08/itextPDFJavaEjemplo.html
 * http://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_de_creaci%C3%B3n_de_un_pdf_con_iText
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtparrafo = new javax.swing.JTextArea();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtparrafo.setColumns(20);
        txtparrafo.setRows(5);
        jScrollPane1.setViewportView(txtparrafo);

        btnReporte.setText("Reporte PDF");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        
        FileOutputStream fileOutputStream = null;
        
        try {
            // Creacion del documento con los margenes
            Document document = new Document(PageSize.A4, 35, 30, 50, 50);
            // El archivo pdf que vamos a generar
            fileOutputStream = new FileOutputStream("reporte.pdf");
            // Obtener la instancia del PdfWriter
            PdfWriter.getInstance(document, fileOutputStream);
            // Abrir el documento
            document.open();
            
            
            parrafo(document);
            
            tabla(document);
            
            foto(document);
            
            // Cerrar el documento
            document.close();

            
            
            // Abrir el archivo
            File file = new File("reporte.pdf");
           
            Desktop.getDesktop().open(file);
            
 
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnReporteActionPerformed
    
    public void parrafo(Document doc){
        
        try {
            // Crear las fuentes para el contenido y los titulos
            Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
            Font fontTitulos = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 11, Font.UNDERLINE, BaseColor.RED);
            
            
            // Creacion del parrafo
            Paragraph paragraph = new Paragraph();
            
            // Agregar un titulo con su respectiva fuente
            paragraph.add(new Phrase("Parrafo:", fontTitulos));
            
            // Agregar saltos de linea
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            
            String texto = txtparrafo.getText();
            
            // Agregar contenido con su respectiva fuente
            paragraph.add(new Phrase(texto, fontContenido));
            
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
           
            
            // Agregar el parrafo al documento
            doc.add(paragraph);
            
        } catch (DocumentException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tabla(Document doc){
                
        try {
            
            PdfPTable tabla = new PdfPTable(3);
            for (int i = 0; i < 15; i++)
            {
                tabla.addCell("celda " + i);
            }
            doc.add(tabla);
            
        } catch (DocumentException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void foto (Document doc){
        
        try
        {
                Image foto = Image.getInstance("coecys.jpg");
                foto.scaleToFit(100, 100);
                foto.setAlignment(Chunk.ALIGN_MIDDLE);
                
                doc.add(foto);
        }
        catch ( Exception e )
        {
                e.printStackTrace();
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtparrafo;
    // End of variables declaration//GEN-END:variables
}
