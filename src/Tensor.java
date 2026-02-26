/**
 * A mutable 2-dimensional tensor of {@code double} values, inspired by the
 * tensor abstraction used in machine-learning frameworks such as PyTorch.
 *
 * <p>
 * <strong>Convention:</strong> {@code data} is a non-null array of length
 * {@code rows * cols} stored in row-major order; {@code rows > 0};
 * {@code cols > 0}; and element {@code (i, j)} is stored at index
 * {@code i * cols + j} for all valid {@code i} and {@code j}.
 * </p>
 *
 * <p>
 * <strong>Correspondence:</strong>
 * {@code this = [[data[i*cols + j] | 0 <= j < cols] | 0 <= i < rows]},
 * a {@code rows}-by-{@code cols} matrix of real-valued entries.
 * </p>
 */
public class Tensor {

    /** Flat row-major backing array; {@code data[i * cols + j]} = entry (i, j). */
    private double[] data;

    /** Number of rows; always positive. */
    private int rows;

    /** Number of columns; always positive. */
    private int cols;

    /**
     * Creates a rows×cols tensor with all elements initialised to 0.
     *
     * @param rows
     *            number of rows (must be > 0)
     * @param cols
     *            number of columns (must be > 0)
     */
    public Tensor(int rows, int cols) {
        assert rows > 0 && cols > 0 : "Dimensions must be positive";
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows * cols];
    }

    // -------------------------------------------------------------------------
    // Kernel Methods
    // -------------------------------------------------------------------------

    /**
     * Returns the value at position (row, col).
     *
     * @param row
     *            zero-based row index
     * @param col
     *            zero-based column index
     * @return element value
     */
    public double get(int row, int col) {
        assert row >= 0 && row < this.rows : "Row index out of bounds";
        assert col >= 0 && col < this.cols : "Col index out of bounds";
        return this.data[row * this.cols + col];
    }

    /**
     * Sets the value at position (row, col) to {@code value}.
     *
     * @param value
     *            new element value
     * @param row
     *            zero-based row index
     * @param col
     *            zero-based column index
     */
    public void set(double value, int row, int col) {
        assert row >= 0 && row < this.rows : "Row index out of bounds";
        assert col >= 0 && col < this.cols : "Col index out of bounds";
        this.data[row * this.cols + col] = value;
    }

    /**
     * Returns the shape of this tensor as {rows, cols}.
     *
     * @return int array of length 2
     */
    public int[] shape() {
        return new int[] { this.rows, this.cols };
    }

    /**
     * Reports whether every element of this tensor is 0.
     *
     * @return true iff all elements equal 0.0
     */
    public boolean isZero() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.get(i, j) != 0.0) {
                    return false;
                }
            }
        }
        return true;
    }

    // -------------------------------------------------------------------------
    // Secondary Methods
    // -------------------------------------------------------------------------

    /**
     * Adds tensor {@code a} element-wise to this tensor. Requires that
     * {@code a} has the same shape.
     *
     * @param a
     *            tensor to add (same shape as this)
     */
    public void add(Tensor a) {
        assert a.rows == this.rows
                && a.cols == this.cols : "Shape mismatch for add";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.set(this.get(i, j) + a.get(i, j), i, j);
            }
        }
    }

    /**
     * Multiplies every element of this tensor by {@code scalar}.
     *
     * @param scalar
     *            the scaling factor
     */
    public void scale(double scalar) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.set(this.get(i, j) * scalar, i, j);
            }
        }
    }

    /**
     * Reshapes this tensor in-place to dimensions {@code a}×{@code b}. The
     * total number of elements must remain unchanged.
     *
     * @param a
     *            new number of rows
     * @param b
     *            new number of columns
     */
    public void reshape(int a, int b) {
        assert a * b == this.rows
                * this.cols : "New shape must have the same total number of elements";
        this.rows = a;
        this.cols = b;
    }

    /**
     * Returns the sum of all elements in this tensor.
     *
     * @return scalar sum
     */
    public double sum() {
        double total = 0.0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                total += this.get(i, j);
            }
        }
        return total;
    }

    /**
     * Returns a new tensor that is the matrix product of {@code this} and
     * {@code b}. Requires {@code this.cols == b.rows}.
     *
     * @param b
     *            right-hand operand
     * @return new tensor of shape this.rows × b.cols
     */
    public Tensor multiply(Tensor b) {
        assert this.cols == b.rows : "Incompatible shapes for matrix multiplication";
        Tensor result = new Tensor(this.rows, b.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                double val = 0.0;
                for (int k = 0; k < this.cols; k++) {
                    val += this.get(i, k) * b.get(k, j);
                }
                result.set(val, i, j);
            }
        }
        return result;
    }

    /**
     * Sets every element of this tensor to {@code value}.
     *
     * @param value
     *            the fill value
     */
    public void fill(double value) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.set(value, i, j);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tensor[").append(this.rows).append("x").append(this.cols)
                .append("]:\n");
        for (int i = 0; i < this.rows; i++) {
            sb.append("  [");
            for (int j = 0; j < this.cols; j++) {
                sb.append(String.format("%7.3f", this.get(i, j)));
                if (j < this.cols - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    /**
     * Demonstrates the Tensor component by simulating a single forward pass
     * through a tiny neural network: input → linear layer → scaled → biased.
     */
    public static void main(String[] args) {

        System.out.println("=== Tensor Proof of Concept ===");
        System.out.println("Simulating a neural-network forward pass\n");

        // Build a 2×3 input tensor (e.g., two 3-pixel image rows)

        System.out.println("--- Step 1: Input Tensor (2x3) ---");
        Tensor input = new Tensor(2, 3);
        input.set(1.0, 0, 0);
        input.set(2.0, 0, 1);
        input.set(3.0, 0, 2);
        input.set(4.0, 1, 0);
        input.set(5.0, 1, 1);
        input.set(6.0, 1, 2);
        System.out.print(input);

        int[] s = input.shape();
        System.out.printf("Shape: %dx%d%n", s[0], s[1]);

        Tensor empty = new Tensor(2, 3);
        System.out.println("Fresh 2x3 tensor isZero: " + empty.isZero()); // true
        empty.set(1.0, 0, 0);
        System.out.println("After set(1.0,0,0) isZero: " + empty.isZero()); // false
        System.out.println();

        // Matrix multiply with a 3×2 weight matrix (linear layer)

        System.out.println(
                "--- Step 2: Weight Matrix (3x2) and Matrix Multiplication ---");
        Tensor weights = new Tensor(3, 2);
        weights.set(0.1, 0, 0);
        weights.set(0.2, 0, 1);
        weights.set(0.3, 1, 0);
        weights.set(0.4, 1, 1);
        weights.set(0.5, 2, 0);
        weights.set(0.6, 2, 1);
        System.out.print(weights);

        Tensor output = input.multiply(weights);
        System.out.println("Output = input @ weights (2x2):");
        System.out.print(output);
        System.out.println();

        // Scale by learning rate 0.01

        System.out.println("--- Step 3: Scale by Learning Rate (0.01) ---");
        output.scale(0.01);
        System.out.print(output);
        System.out.println();

        // Add a bias tensor (all 0.5)
        System.out.println("--- Step 4: Add Bias Tensor (all 0.5) ---");
        Tensor bias = new Tensor(2, 2);
        bias.fill(0.5);
        System.out.println("Bias tensor:");
        System.out.print(bias);
        output.add(bias);
        System.out.println("Output after bias addition:");
        System.out.print(output);
        System.out.println();

        // Compute total activation (sum)

        System.out.println("--- Step 5: Total Activation (sum) ---");
        System.out.printf("Sum of output elements: %.6f%n%n", output.sum());

        // Reshape a 2×6 tensor to 3×4 (e.g., flattening a feature map)

        System.out.println("--- Step 6: Reshape 2x6 -> 3x4 ---");
        Tensor feature = new Tensor(2, 6);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                feature.set(i * 6 + j + 1.0, i, j); // values 1..12
            }
        }
        System.out.println("Before reshape (2x6):");
        System.out.print(feature);
        feature.reshape(3, 4);
        System.out.println("After reshape (3x4) -- same data, different view:");
        System.out.print(feature);
        System.out.printf("Sum unchanged: %.1f%n", feature.sum());
    }
}
