/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
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

package gecko.geckocircuits.scope;

import gecko.geckocircuits.allg.GeckoFileChooser;
import gecko.geckocircuits.allg.SaveViewFrame;
import gecko.geckocircuits.control.ScopeSignalSimpleName;
import gecko.geckocircuits.datacontainer.ContainerStatus;
import gecko.geckocircuits.datacontainer.DataContainerFourier;
import gecko.geckocircuits.newscope.AbstractScopeSignal;
import gecko.geckocircuits.newscope.DialogConnectSignalsGraphs;
import gecko.geckocircuits.newscope.GraferV4;
import gecko.geckocircuits.newscope.NewScope;
import gecko.geckocircuits.newscope.ScopeSettings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class FourierPlotFrame extends javax.swing.JFrame {    

    public FourierPlotFrame(final NewScope newScope, final double baseFrequency, final double[][][] erg) {
        initComponents();        
        jPanelFourier1.insertData(baseFrequency, erg);
        newScope.additionalPanel(jPanelFourier1._graferNew);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanelFourier1 = new gecko.geckocircuits.newscope.JPanelFourier();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFourier1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFourier1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gecko.geckocircuits.newscope.JPanelFourier jPanelFourier1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
