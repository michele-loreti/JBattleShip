
/*
 * MIT License
 *
 * Copyright (c)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package it.unicam.cs.jbattleship.api;


import java.util.Objects;

/**
 * An instance of this class is used to identify a location in the battlefield.
 */
public class FieldLocation {

    private final int row;
    private final int column;

    /**
     * Creates a new position at the give row and column.
     *
     * @param row row index.
     * @param column column index.
     */
    public FieldLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the row of this position.
     *
     * @return the row of this position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this position.
     *
     * @return the column of this position.
     */
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldLocation that = (FieldLocation) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "FieldPosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
