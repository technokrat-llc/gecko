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
package gecko.geckocircuits.control;

import gecko.geckocircuits.allg.AbstractComponentTyp;
import gecko.geckocircuits.circuit.AbstractBlockInterface;
import gecko.geckocircuits.circuit.ConnectorType;
import gecko.geckocircuits.circuit.CurrentMeasurable;
import gecko.geckocircuits.circuit.TokenMap;
import gecko.i18n.resources.I18nKeys;
import java.util.Arrays;
import java.util.List;


public final class ReglerAmperemeter extends AbstractCurrentMeasurement {    
    static ControlTypeInfo tinfo = new ControlTypeInfo(ReglerAmperemeter.class, "AMP", I18nKeys.CURRENT_MEASUREMENT_A);
    
        @Override
    public String[] getOutputNames() {
        return new String[]{"Imeas"};
    }    

    @Override
    String getVariableForDisplay() {
        return "i";
    }                            

    @Override
    public void checkComponentCompatibility(final Object testObject, final List<AbstractBlockInterface> insertList) {
        if(testObject instanceof CurrentMeasurable) {
            final CurrentMeasurable measurable = (CurrentMeasurable) testObject;
            insertList.addAll(Arrays.asList(measurable.getCurrentMeasurementComponents(ConnectorType.LK)));            
        }
    }                   
            
    @Override
    public I18nKeys[] getOutputDescription() {
        return new I18nKeys[] {I18nKeys.CURRENT_MEASUREMENT_A};
    }
    

    @Override
    public I18nKeys getCouplingTitle() {
        return I18nKeys.SELECT_CIRCUIT_COMPONENT;        
    }

    @Override
    public I18nKeys getMissingComponentsString() {
        return I18nKeys.NO_CIRCUIT_COMPONENT_DEFINED;        
    }    

}
