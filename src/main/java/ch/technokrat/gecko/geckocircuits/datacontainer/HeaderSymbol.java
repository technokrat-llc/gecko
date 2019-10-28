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
package ch.technokrat.gecko.geckocircuits.datacontainer;



public enum HeaderSymbol {

    /**
     * WARNING: Don't change the order of the enumeration constants, ordinal() is used!
     */
    HASH("#"),
    SLASHES("//"),
    SEMICOLON(";"),
    COMMA(",");

    public static HeaderSymbol getFromOrdinal(final int ordinal) {
        for (HeaderSymbol val : HeaderSymbol.values()) {
            if (val.ordinal() == ordinal) {
                return val;
            }
        }
        assert false;
        return null;
    }
    
    private final String _stringValue;

    HeaderSymbol(final String symbol) {
        _stringValue = symbol;
    }
        
    
    public static TextSeparator getFromCode(final int code) {
        for (TextSeparator val : TextSeparator.values()) {
            if (val.code() == code) {
                return val;
            }
        }
        return TextSeparator.SPACE;
    }
    
    public String toString() {
        return _stringValue;
    }
}