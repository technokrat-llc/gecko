/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations AG
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  GeckoCIRCUITS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package gecko.geckocircuits.circuit;

import gecko.GeckoSim;
import gecko.geckocircuits.control.SubCircuitSheet;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author andreas
 */
public class DialogGlobalTerminal extends javax.swing.JDialog {
    private final GlobalTerminable _globalTerminable;
    private final HashSet<GlobalTerminable> _allGlobalTerminals;
    private final AbstractBlockInterface _thisTerminal;
    private boolean _initDone = false;
    /**
     * Creates new form DialogGlobalTerminal
     */
    public DialogGlobalTerminal(final java.awt.Frame parent, final AbstractBlockInterface globalTerminal) {
        super(parent, true);
        initComponents();
        _thisTerminal = (AbstractBlockInterface) globalTerminal;
        jTextFieldName.setText(globalTerminal.getStringID());        
        _globalTerminable = (GlobalTerminable) globalTerminal;
        
        _allGlobalTerminals = new HashSet<GlobalTerminable>(_globalTerminable.getAllGlobalTerminals());        
        getRootPane().setDefaultButton(jButtonOK);
        readAllGlobalsIntoComboBoxes();
        _initDone = true;
        setTitle("Set global terminal");
    }
    
    private void readAllGlobalsIntoComboBoxes() {
        _initDone = false;
        jComboBoxAllNames.removeAllItems();
        jComboBoxConnections.removeAllItems();
        Set<String> allComboNames = new HashSet<String>();
        
        for(GlobalTerminable otherGlobal : _allGlobalTerminals) {                        
            allComboNames.add(otherGlobal.getStringID());            
            if(otherGlobal.getStringID().equals(_globalTerminable.getStringID())) {
                
                CircuitSheet connectedSheet = otherGlobal.getParentCircuitSheet();
                if(connectedSheet == null || connectedSheet.getClass() == CircuitSheet.class) {
                    jComboBoxConnections.addItem("Main sheet");
                } else if(connectedSheet instanceof SubCircuitSheet){
                    final String subName = ((SubCircuitSheet) connectedSheet)._subBlock.getStringID();
                    jComboBoxConnections.addItem(subName);
                }
                
                
            }
        }
        for(String insertName : allComboNames) {
            jComboBoxAllNames.addItem(insertName);
            if(insertName.equals(_thisTerminal.getStringID())) {
                jComboBoxAllNames.setSelectedIndex(jComboBoxAllNames.getItemCount()-1);
            }
        }
        
        _initDone = true;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAllNames = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxConnections = new javax.swing.JComboBox();
        jButtonShowInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jButtonOK.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonOK.setText("Ok");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Component name:");

        jTextFieldName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextFieldName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNameFocusLost(evt);
            }
        });
        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Connected circuit sheets (only for info)");

        jComboBoxAllNames.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBoxAllNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAllNamesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Select name from global terminals:");

        jComboBoxConnections.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jButtonShowInfo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonShowInfo.setText("Show info");
        jButtonShowInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxConnections, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxAllNames, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonShowInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonOK, jButtonShowInfo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConnections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAllNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonShowInfo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        setComponentName(jTextFieldName.getText());
        this.dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jComboBoxAllNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAllNamesActionPerformed
       
        if(!_initDone) {
            return;
        }
        final String nameToSet = (String) jComboBoxAllNames.getSelectedItem();
        
        if(nameToSet == null) {
            return;
        }
        setComponentName(nameToSet);
        
    }//GEN-LAST:event_jComboBoxAllNamesActionPerformed

    private void jTextFieldNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyTyped
        
    }//GEN-LAST:event_jTextFieldNameKeyTyped

    private void jTextFieldNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameFocusLost

    private void jButtonShowInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowInfoActionPerformed
        JOptionPane.showMessageDialog(GeckoSim._win, "The global terminal can be used to create electrical or control\n"
                + "connections between different subcircuits. The connection is detected by the component\n"
                + "name. For instance, if you create two global terminals in SUBCIRCUIT.1 and SUBCIRCUIT.2\n"
                + "both with the name GLOBAL.1, they will be connected.\n"
                + "Our recommendation is to use the global terminal only rarely, since your simulation model\n"
                + "could become very confusing when many global terminals are in use.", 
                "Information on global terminals",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonShowInfoActionPerformed

    private void setComponentName(final String newName) {
        
        if(!_initDone) {
            return;
        }
        try {
            _thisTerminal.setNewNameChecked(newName);
            jTextFieldName.setText(newName);
            readAllGlobalsIntoComboBoxes();
        } catch (NameAlreadyExistsException ex) {
            JOptionPane.showMessageDialog(this,
                    "Object name: " + newName + " is already in use in this circuit sheet!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);            
            throw new RuntimeException("Name is already in use!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonShowInfo;
    private javax.swing.JComboBox jComboBoxAllNames;
    private javax.swing.JComboBox jComboBoxConnections;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
