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
package gecko.geckocircuits.newscope;

import gecko.geckocircuits.circuit.CircuitSheet;
import gecko.geckocircuits.control.ReglerOSZI;
import gecko.geckocircuits.control.SubCircuitSheet;

/**
 * Immutable class, especially the scope input index should never change!
 *
 * @author andreas
 */
public final class ScopeSignalRegular extends AbstractScopeSignal {

    private final int _scopeInputIndex;
    private final ReglerOSZI _reglerOSZI;

    public ScopeSignalRegular(final int scopeInputIndex, final ReglerOSZI reglerOSZI) {
        super();
        _scopeInputIndex = scopeInputIndex;
        _reglerOSZI = reglerOSZI;
    }

    @Override
    public String getSignalName() {
        if (_reglerOSZI == null) {
            return "no regleroszi defined";
        }
        final String returnValue = _reglerOSZI.XIN.get(_scopeInputIndex).getLabelObject().getLabelString();
        if (returnValue.isEmpty()) {
            return "sg." + _scopeInputIndex;
        } else {
            return returnValue;
        }
    }

    int getSignalIndex() {
        return _scopeInputIndex;
    }

    @Override
    public String getSubcircuitPath() {
        return _reglerOSZI.getSubCircuitPath();        
    }
}
