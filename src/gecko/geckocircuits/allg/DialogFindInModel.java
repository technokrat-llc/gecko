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
package gecko.geckocircuits.allg;

import gecko.GeckoSim;
import gecko.geckocircuits.circuit.SchematischeEingabe2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author andreas
 */
public final class DialogFindInModel extends javax.swing.JDialog {

    private final SchematischeEingabe2 _se;

    /**
     * Creates new form DialogFindInModel
     */
    public DialogFindInModel(java.awt.Frame parent, boolean modal, SchematischeEingabe2 se) {
        super(parent, modal);
        initComponents();
        if(! Fenster.IS_APPLET) {
            this.setAlwaysOnTop(true);
        }
        
        this.setTitle("Search strings in model");
        _se = se;
        this.setVisible(true);
        jTextField.selectAll();
        getRootPane().setDefaultButton(jButtonClose);
        addEscapeListener();
        jList1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                String foundString = jList1.getModel().getElementAt(jList1.getSelectedIndex()).toString();
                int stringIndex = foundString.indexOf(':');
                foundString = foundString.substring(stringIndex+2);
                foundString = foundString.substring(0, foundString.indexOf(" "));
                jTextField.setText(foundString);                    
                _se._visibleCircuitSheet.findString(foundString, jCheckBoxIgnore.isSelected(), !jCheckBoxExact.isSelected());
                } catch (Exception ex) {
                    System.err.println("could not find component!");
                }
            }
        });
    }

    @Override
    public void setVisible(final boolean value) {
        super.setVisible(value);
        if (!value) {
            _se._visibleCircuitSheet.clearFind();
        }
    }

    public void addEscapeListener() {
        ActionListener escListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        };

        this.getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jCheckBoxIgnore = new javax.swing.JCheckBox();
        jCheckBoxExact = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Search for String:");

        jTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField.setText("Please insert search text");
        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldKeyReleased(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jList1.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Found items:");

        jButtonClose.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonClose.setText("Close window");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jCheckBoxIgnore.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxIgnore.setSelected(true);
        jCheckBoxIgnore.setText("Ignore case");

        jCheckBoxExact.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxExact.setText("Exact match");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBoxIgnore)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxExact)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxIgnore)
                    .addComponent(jCheckBoxExact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyReleased
        String searchText = jTextField.getText();        
        if (!searchText.isEmpty()) {
            Set<String> found = _se._visibleCircuitSheet.findString(searchText, jCheckBoxIgnore.isSelected(), !jCheckBoxExact.isSelected());
            ((DefaultListModel)jList1.getModel()).clear();
            for(String tmp : found) {
                ((DefaultListModel) jList1.getModel()).addElement(tmp);
            }
        }
    }//GEN-LAST:event_jTextFieldKeyReleased

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
        _se._visibleCircuitSheet.clearFind();
    }//GEN-LAST:event_jButtonCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JCheckBox jCheckBoxExact;
    private javax.swing.JCheckBox jCheckBoxIgnore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
