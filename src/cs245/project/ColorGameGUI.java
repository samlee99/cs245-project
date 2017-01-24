/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245.project;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
/**
 *
 * @author amnipp
 */
public class ColorGameGUI extends javax.swing.JFrame {

    ColorGame cg;
    Random r = new Random();
    //ArrayList<JButton> colorBtnList;
    HashMap<String, JButton> colorBtnList = new HashMap<>();
    /**
     * Creates new form ColorGameGUI
     */
    public ColorGameGUI() {
        initComponents();
    }
    
    public void setColorGame(ColorGame cg){
        this.cg = cg;
    }
    
    public void initRandomColors(){
        String[] colorList = cg.getColorList();
        //Randomize the color list
        for (int i = colorList.length - 1; i > 0; i--)
        {
          int index = r.nextInt(i + 1);
          // Simple swap
          String a = colorList[index];
          colorList[index] = colorList[i];
          colorList[i] = a;
        }
        Field field;
        Color color = null;
        for(int i = 0; i < colorList.length; ++i){
            if(colorList[i].toLowerCase().equals("purple")){
               color = new Color(255, 0, 255); 
            }else{
                try {
                    field = Class.forName("java.awt.Color").getField(colorList[i].toLowerCase());
                    color = (Color)field.get(null);
                } catch (Exception ex) {}
            }
            //I know this is really bad and should not be done this way but
            //I cant think of much else at this moment -amnipp
            switch(i){
                case 0:
                    colorBtn1.setBackground(color);
                    colorBtn1.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn1);
                    break;
                case 1:
                    colorBtn2.setBackground(color);
                    colorBtn2.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn2);
                    break;
                case 2:
                    colorBtn3.setBackground(color);
                    colorBtn3.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn3);
                    break;
                case 3:
                    colorBtn4.setBackground(color);
                    colorBtn4.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn4);
                    break;
                case 4:
                    colorBtn5.setBackground(color);
                    colorBtn5.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn5);
                    break;
                default:
                    System.out.println("default");
                    colorBtn1.setBackground(color);
                    colorBtn1.setForeground(color);
                    colorBtnList.put(colorList[i].toLowerCase(), colorBtn1);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Color_Label = new javax.swing.JLabel();
        colorBtn1 = new javax.swing.JButton();
        colorBtn2 = new javax.swing.JButton();
        colorBtn3 = new javax.swing.JButton();
        colorBtn4 = new javax.swing.JButton();
        colorBtn5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Color_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, 145, 41));
        getContentPane().add(colorBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, 40));

        colorBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(colorBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 99, 38));
        getContentPane().add(colorBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 100, 40));
        getContentPane().add(colorBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, 40));
        getContentPane().add(colorBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 100, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void colorBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBtn2ActionPerformed
        // TODO add your handling code here:
        /*int color = r.nextInt(5) + 1;
        cg.changeColor(color);
        int colorNum = r.nextInt(5);
        cg.changeName(colorNum);*/

    }//GEN-LAST:event_colorBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Color_Label;
    private javax.swing.JButton colorBtn1;
    public javax.swing.JButton colorBtn2;
    private javax.swing.JButton colorBtn3;
    private javax.swing.JButton colorBtn4;
    private javax.swing.JButton colorBtn5;
    // End of variables declaration//GEN-END:variables
}
