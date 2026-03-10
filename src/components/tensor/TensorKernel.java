package components.tensor;

import components.standard.Standard;

/**
 * Kernel interface for the {@code Tensor} component type, providing the
 * minimal set of operations needed to fully model a mutable 2-dimensional
 * matrix of {@code double} values.
 *
 * <p>
 * A {@code Tensor} is modelled as a 2D grid {@code this[i][j]} for
 * {@code 0 <= i < rows} and {@code 0 <= j < cols}, where {@code rows > 0}
 * and {@code cols > 0}. The total number of elements is {@code rows * cols}.
 * </p>
 *
 * @initially <pre>
 *   ensures
 *     this.shape()[0] = 1 and this.shape()[1] = 1 and
 *     this.isZero() = true
 * </pre>
 */
public interface TensorKernel extends Standard<Tensor> {

    /**
     * Returns the value of element ({@code row}, {@code col}) in this tensor.
     *
     * @param row
     *            the zero-based row index of the element
     * @param col
     *            the zero-based column index of the element
     * @return the {@code double} value stored at position ({@code row},
     *         {@code col})
     * @requires
     *  0 <= row < this.shape()[0] and 0 <= col < this.shape()[1]
     * @ensures
     *  get = this[row][col]
     */
    double get(int row, int col);

    /**
     * Sets the element at position ({@code row}, {@code col}) in this tensor
     * to {@code value}.
     *
     * @param value
     *            the new value to store at position ({@code row}, {@code col})
     * @param row
     *            the zero-based row index of the element to update
     * @param col
     *            the zero-based column index of the element to update
     * @updates this
     * @requires
     *  0 <= row < this.shape()[0] and 0 <= col < this.shape()[1]
     * @ensures
     *  this[row][col] = value and
     *  for all i, j where (i, j) != (row, col):
     *    this[i][j] = #this[i][j]
     */
    void set(double value, int row, int col);

    /**
     * Returns the dimensions of this tensor as a two-element array where
     * index 0 is the number of rows and index 1 is the number of columns.
     *
     * @return a new {@code int[2]} array where {@code result[0]} is the row
     *         count and {@code result[1]} is the column count
     * @ensures
     *  shape[0] > 0 and shape[1] > 0 and
     *  shape[0] = number of rows in this and
     *  shape[1] = number of columns in this
     */
    int[] shape();

    /**
     * Reports whether every element of this tensor equals {@code 0.0}.
     *
     * @return {@code true} if and only if {@code this[i][j] = 0.0} for all
     *         valid indices {@code i} and {@code j}; {@code false} otherwise
     * @ensures
     *  isZero = (for all i, j: 0 <= i < this.shape()[0] and
     *                          0 <= j < this.shape()[1]:
     *            this[i][j] = 0)
     */
    boolean isZero();

    /**
     * Reshapes this tensor to {@code rows} rows and {@code cols} columns
     * without altering the underlying element data in row-major order.
     *
     * <p>
     * The element at flat row-major index {@code k} in {@code #this} remains
     * at flat row-major index {@code k} after the call. Concretely, for each
     * index {@code k} with {@code 0 <= k < rows * cols}:
     * <pre>
     *   this[k / cols][k % cols]  =  #this[k / #this.shape()[1]][k % #this.shape()[1]]
     * </pre>
     * </p>
     *
     * @param rows
     *            the new number of rows
     * @param cols
     *            the new number of columns
     * @updates this
     * @requires
     *  rows > 0 and cols > 0 and
     *  rows * cols = #this.shape()[0] * #this.shape()[1]
     * @ensures
     *  this.shape()[0] = rows and this.shape()[1] = cols and
     *  for all k: 0 <= k < rows * cols:
     *    this[k / cols][k % cols] =
     *      #this[k / #this.shape()[1]][k % #this.shape()[1]]
     */
    void reshape(int rows, int cols);

}
