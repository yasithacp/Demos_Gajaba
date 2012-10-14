/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AgentFrame.java
 *
 * Created on Oct 12, 2012, 12:14:07 PM
 */
package org.gajaba.sample.agent;

import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Yasitha
 */
public class AgentFrame extends javax.swing.JFrame {

    private String getFreePhysicalMemorySize;
    private String getFreeSwapSpaceSize;
    private String getTotalPhysicalMemorySize;
    private String getTotalSwapSpaceSize;

    /** Creates new form AgentFrame */
    public AgentFrame() {
        initComponents();
    }

    public void updateData(OperatingSystemMXBean operatingSystemMXBean){
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get")
                    && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                    if(method.getName() == "getFreePhysicalMemorySize") {
                        this.getFreePhysicalMemorySize = value.toString();
                    } else if(method.getName() == "getFreeSwapSpaceSize") {
                        this.getFreeSwapSpaceSize = value.toString();
                    } else if (method.getName() == "getTotalPhysicalMemorySize") {
                        this.getTotalPhysicalMemorySize = value.toString();
                    } else if (method.getName() == "getTotalSwapSpaceSize") {
                        this.getTotalSwapSpaceSize = value.toString();
                    }
                } catch (Exception e) {
                    value = e;
                } // try

            } // if
        } // for

        this.jMemoryProgressBar.setValue(this.getMemoryPercentage());
        this.jSwapProgressBar.setValue(this.getSwapPercentage());
    }

    private int getMemoryPercentage() {
        double value = Double.parseDouble(this.getFreePhysicalMemorySize) * 100 / Double.parseDouble(this.getTotalPhysicalMemorySize);
        this.jMemoryValueLabel.setText(String.valueOf((int) value) + "%");
        return (int) value;
    }

    private int getSwapPercentage() {
        double value = Double.parseDouble(this.getFreeSwapSpaceSize) * 100 / Double.parseDouble(this.getTotalSwapSpaceSize);
        this.jSwapValueLabel.setText(String.valueOf((int) value) + "%");
        return (int) value;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMemoryProgressBar = new javax.swing.JProgressBar();
        jSwapProgressBar = new javax.swing.JProgressBar();
        jMemoryValueLabel = new javax.swing.JLabel();
        jSwapValueLabel = new javax.swing.JLabel();
        jExitButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gajaba Agent - CPU Usage");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Gajaba Agent - CPU Usage");

        jLabel2.setText("Free Physical Memory");

        jLabel3.setText("Free Swap Space");

        jMemoryValueLabel.setText("34%");

        jSwapValueLabel.setText("63%");

        jExitButton.setText("Exit");
        jExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSwapProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSwapValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jMemoryProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jMemoryValueLabel)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addComponent(jExitButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMemoryValueLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jMemoryProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSwapProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSwapValueLabel))
                .addGap(26, 26, 26)
                .addComponent(jExitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {

            //public void run() {
                AgentFrame af = new AgentFrame();
                af.setVisible(true); 
                while(true){  
                   int i = (int)Math.round(Math.random() * 100);
                    System.out.println(i);
                   af.jMemoryProgressBar.setValue(i); 
                   i++;
                //}
                
            }
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jExitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jMemoryProgressBar;
    private javax.swing.JLabel jMemoryValueLabel;
    private javax.swing.JProgressBar jSwapProgressBar;
    private javax.swing.JLabel jSwapValueLabel;
    // End of variables declaration//GEN-END:variables
}