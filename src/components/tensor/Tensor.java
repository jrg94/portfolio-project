package components.tensor;

/**
 * Interface for the {@code Tensor} component, layering secondary
 * (higher-level) operations on top of {@link TensorKernel}.
 *
 * <p>
 * Every method declared here is implementable solely using the kernel methods
 * defined in {@link TensorKernel} and the {@code Standard} methods inherited
 * through the hierarchy ({@code clear}, {@code newInstance},
 * {@code transferFrom}).
 * </p>
 */
public interface Tensor extends TensorKernel {

    /**
     * Adds tensor {@code t} element-wise to this tensor.
     *
     * @param t
     *            the tensor whose elements are to be added; must have the
     *            same shape as {@code this}
     * @updates this
     * @requires
     *  t.shape()[0] = this.shape()[0] and
     *  t.shape()[1] = this.shape()[1]
     * @ensures
     *  for all i, j: 0 <= i < this.shape()[0] and
     *                0 <= j < this.shape()[1]:
     *    this[i][j] = #this[i][j] + t[i][j]
     */
    void add(Tensor t);

    /**
     * Multiplies every element of this tensor by {@code scalar}.
     *
     * @param scalar
     *            the factor by which every element is multiplied
     * @updates this
     * @ensures
     *  for all i, j: 0 <= i < this.shape()[0] and
     *                0 <= j < this.shape()[1]:
     *    this[i][j] = #this[i][j] * scalar
     */
    void scale(double scalar);

    /**
     * Returns the sum of all elements in this tensor.
     *
     * @return the sum of every element {@code this[i][j]}
     * @ensures
     *  sum = (summation over all i, j:
     *           0 <= i < this.shape()[0] and 0 <= j < this.shape()[1]:
     *         this[i][j])
     */
    double sum();

    /**
     * Sets every element of this tensor to {@code value}, regardless of
     * their previous values.
     *
     * @param value
     *            the value to assign to every element
     * @updates this
     * @ensures
     *  for all i, j: 0 <= i < this.shape()[0] and
     *                0 <= j < this.shape()[1]:
     *    this[i][j] = value
     */
    void fill(double value);

    /**
     * Returns a new {@code Tensor} that is the matrix product of this tensor
     * and {@code b}.
     *
     * <p>
     * The result has shape {@code [this.shape()[0], b.shape()[1]]}, and each
     * element {@code result[i][j]} is the dot product of row {@code i} of
     * {@code this} with column {@code j} of {@code b}.
     * </p>
     *
     * @param b
     *            the right-hand operand; its row count must equal the column
     *            count of {@code this}
     * @return a new {@code Tensor} representing the matrix product
     *         {@code this x b}
     * @requires
     *  this.shape()[1] = b.shape()[0]
     * @ensures
     *  multiply.shape()[0] = this.shape()[0] and
     *  multiply.shape()[1] = b.shape()[1] and
     *  for all i, j: 0 <= i < this.shape()[0] and
     *                0 <= j < b.shape()[1]:
     *    multiply[i][j] = (summation over k: 0 <= k < this.shape()[1]:
     *                      this[i][k] * b[k][j])
     */
    Tensor multiply(Tensor b);

}
