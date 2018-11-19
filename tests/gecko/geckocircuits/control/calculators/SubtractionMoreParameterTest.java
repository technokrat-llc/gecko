/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package gecko.geckocircuits.control.calculators;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubtractionMoreParameterTest extends AbstractMultiInputFunctionTest {

    @Override
    public AbstractControlCalculatable calculatorFabricTwoInputs() {
        return new SubtractionMoreParameter(2);
    }

    @Override
    public AbstractControlCalculatable calculatorFabricThreeInputs() {
        return new SubtractionMoreParameter(3);
    }

    @Override
    public AbstractControlCalculatable matchingTwoInputFabric() {
        return new SubtractionTwoParameter();
    }

    @Override
    @Test
    public void testWithThreeInputs() {
        double val = getValue(5,-2,3);        
        assertEquals(4, val, 1e-7);
    }
           
}
