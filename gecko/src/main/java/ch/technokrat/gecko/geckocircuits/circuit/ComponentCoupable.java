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
package ch.technokrat.gecko.geckocircuits.circuit;

import ch.technokrat.gecko.geckocircuits.control.Operationable;
import ch.technokrat.gecko.i18n.resources.I18nKeys;
import java.util.List;

/**
 * Every component, that builds an explicit link to other components (e.g for current measurements, or
 * a inductor coupling) should implement this interface.
 * @author andreas
 */
public interface ComponentCoupable extends Operationable {
    ComponentCoupling getComponentCoupling();
    I18nKeys getCouplingTitle();
    I18nKeys getMissingComponentsString();
    void checkComponentCompatibility(final Object testObject, List<AbstractBlockInterface> insertList);    
}
