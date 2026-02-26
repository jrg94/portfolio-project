# Portfolio Part 1: Component Brainstorming

- **Name**: Jiacheng Hou
- **Dot Number**: hou.688
- **Due Date**: Feb 6, 2026

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist


To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives


Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points


Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

| Learning Objective                                                                                        | Subcategory                 | Weight | Missing                                                     | Beginning                                                                              | Developing                                                                                     | Meeting                                                                                 |
| --------------------------------------------------------------------------------------------------------- | --------------------------- | ------ | ----------------------------------------------------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Students should be able to identify their values, interests, and/or goals as they relate to their designs | Metacognitive Memory        | 3      | (0) No attempt to summarize values, interests, and/or goals | (1) A brief description of values, interests, and/or goals is provided but lacks depth | (2) A description of values, interests, and/or goals is provided by are not related to designs | (3) A description of values, interests, and/or goals is provided and relates to designs |
| Students should be able to predict the feasibility of their designs                                       | Metacognitive Understanding | 3      | (0) No attempt to design components that are feasible       | (1) At least one component is feasible                                                 | (2) At least two components are feasible                                                       | (3) All three components are feasible                                                   |
| Students should be able to use the OSU discipline in all three designs                                    | Metacognitive Application   | 4      | (0) No attempt to follow the OSU discipline in designs      | (1) At least one design follows the OSU discipline                                     | (3) At least two designs follow the OSU discipline                                             | (4) All three designs follow the OSU discipline                                         |

Below is further rationale/explanation for the rubric items above:

1. Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

Hi！My name is Jiacheng Hou(My personal website: https://hjc704.github.io/). I’m a CSE student at Ohio State with a strong interest in machine learning and computer vision, especially problems related to geometry, perception, and autonomous-driving style pipelines. In my research and projects, I often work with numerical data (vectors, matrices, tensors) and care a lot about writing software that is correct, modular, and easy to reuse. Long term, I want to keep building toward research-oriented engineering roles (and potentially graduate study) where I can design reliable components that support experimentation and scale to larger systems.

Outside of coursework, I enjoy digging into technical details and improving my engineering habits—clean APIs, clear invariants, and testing. I also like exploring math-heavy topics that connect to computing (e.g., linear algebra, optimization, and scientific computing). These interests motivated my component ideas in this portfolio: designing small, disciplined numerical components (like Tensor, Vector, and ComplexNumber) that mirror real-world needs while still being feasible to implement within one semester.

## Assignment



As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.



There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

**Note**: Sometimes students will already know what they want to design
and will feel forced to make one-off designs for components they'll never
build. If that's you, you may submit three different designs for the same
component (rather than three different components). This will strengthen your
final design because you'll have an opportunity to think about different ways of
organizing the API. As an example, later in the course, you will see a tree
component that doesn't work by accessing the children through aliases but rather
by assembling and disassembling the tree. You will also see a variety of
list-like components that have different ways of manipulating the data. Think
about different ways you might allow a client to manipulate your component.

### Example Component


To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: `Tensor`
  - **Description**:
    - The Tensor component is a simplified 2-dimensional array inspired by
PyTorch, designed for numerical operations in Java. It provides a
foundation for scientific computing by representing data in an 2-dimensional grid. This component allows users to store and manipulate
numerical data in any number of dimensions, making it suitable for
  applications ranging from simple vector operations to more complex
matrix computations.
  - **Kernel Methods**:
    - `T get(int row, int col)`: Returns the value at the specified 2-dimensional index. This is the fundamental read operation for accessing 2D tensor data.
    - `void set(double value, int row, int col)`: Sets the value at the specified 2D index. This is the fundamental write
operation for modifying tensor data.
    - `int[] shape()`: Returns an array representing the size of each dimension of the tensor.
    - `boolean isZero()`: Reports whether all elements in the tensor are zero. This is analogous to NaturalNumber’s isZero() and provides a simple way to check the tensor’s state.

  - **Secondary Methods**:
    - `void add(Tensor a)`: Performs element-wise addition with another tensor of the same shape.
    - `void scale(double scalar)`: Multiplies every element in the tensor by a scalar value.
    - `void reshape(int a, int b)`: Changes the shape of the tensor without changing its underlying data. The total number of elements must
remain the same.
    - `double sum()`: Calculates and returns the sum of all elements in the tensor.
    - `Tensor multiply(Tensor b)`: Operate Matrix-multiplication between `this` and another tensor.
    - `void fill(double value)`: Sets all elements in the tensor to the specified value.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, the component is mutable. By extending Standard, it inherits `clear()` , `newInstance()` , and `transferFrom()` which all mutate `this`. Additionally, the kernel method set and secondary methods like `add` , `scale` , `reshape` , and `fill` all modify the tensor’s internal state.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No. The n-dimensional structure can be implemented efficiently using a single, flat one-dimensional array as the internal data store.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - No, For this simplified design, no special enums or public constants are required. It's a 2-dimension design, and clients can choose different numbers in each dimensions
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The secondary add method can be implemented by iterating through all elements of the tensors and using the kernel methods `get` and `set` . For example:
      ```java
      public void add(Tensor a) {
        int[] s = this.shape();
        for (int r = 0; r < s[0]; r++) {
          for (int c = 0; c < s[1]; c++) {
            double value = this.get(r, c) + a.get(r, c);
            this.set(value, r, c);
          }
        }
      }

      ```


- Component Design #2: `Vector`
  - **Description**:
    - The Vector component represents an n-dimensional mathematical vector, providing operations commonly used in linear algebra, physics
simulations, and graphics programming. This component is designed to be mutable and follows the OSU software engineering discipline, providing a core set of kernel methods for basic vector manipulation and a richer set of secondary methods for more complex mathematical operations. Unlike the Tensor component, Vector is specifically optimized for one-dimensional numerical data and includes operations like dot
product and magnitude that are specific to vector mathematics.
  - **Kernel Methods**:
    - `void setComponent(int index, double value)`: Sets the value of a
single component at the given index.
    - `double getComponent(int index)`: Retrieves the value of a single
component at the given index.
    - `int dimension()`: Returns the number of components in the vector.
    - `boolean isZero()`: Reports whether all components of the vector are zero.
  - **Secondary Methods**:
    - `double dotProduct(Vector other)`: Calculates the dot product of this vector with another vector of the same dimension.
    - `double magnitude()`: Computes the magnitude of the vector.
    - `void add(Vector other)`: Adds another vector to this vector.
    - `void subtract(Vector other)` : Subtracts another vector from this
vector.
    - `void scale(double scalar)`: Multiplies every component of the vector by a scalar value.
    - `void normalize()`: Scales the vector to have a magnitude of 1 (unit
vector).
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, the component is mutable. By extending Standard, it inherit `sclear()` , `newInstance()` , and `transferFrom()` which all mutate `this`. The kernel method `setComponent` and secondary methods like `add` , `subtract` , `scale` , and `normalize` all modify the vector’s internal state.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No, a Vector component can be implemented as a single class without the need for internal helper classes. The internal
representation can be a simple array of doubles
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - No, for this fundamental design, no specific enums or constants are immediately necessary. A constant for floating-point comparison
precision, such as `epsilon` could be considered in a more advanced implementation for comparing vectors for equality, but is not essential for the core component.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. For example, the dotProduct secondary method can be implemented by iterating through the vector’s components using the `dimension()` and `getComponent(int index)` kernel methods:
      ```java
      public double dotProduct(Vector other) {
        double total = 0;
        for (int i = 0; i < this.dimension(); i++) {
          total += this.getComponent(i) * other.getComponent(i);
        }
        return total;
      }
      ```

- Component Design #3: `ComplexNumber`
  - **Description**:
    - The ComplexNumber component represents a complex number, a mathematical entity with both a real and an imaginary part. It is designed to be a fundamental building block for scientific and engineering applications requiring complex arithmetic, such as signal processing, quantum computing simulations, and electrical engineering calculations. The design emphasizes a clear separation between a minimal kernel interface for primitive operations and a richer secondary interface for more complex, layered functionality.
  - **Kernel Methods**:
    - `void set(double real, double imaginary)` : Sets the value of the
complex number to the specified real and imaginary parts.
    - `double getReal()`: Returns the real part of the complex number.
    - `double getImaginary()` : Returns the imaginary part of the complex number.
    - `boolean isZero()` : Reports whether the complex number is zero (both real and imaginary parts are zero).

  - **Secondary Methods**:
    - `void add(ComplexNumber comp)` : Adds another complex number to this one, modifying this in place.
    - `void subtract(ComplexNumber comp)` : Subtracts another complex number from this one.
    - `void multiply(ComplexNumber comp)` : Multiplies this complex number by another using the formula $(a+bi)(c+di) = (ac-bd) + (ad+bc)i$.
    - `double magnitude()`: Calculates the magnitude (or modulus) of the complex number: $sqrt(real² + imaginary²)$.
    - `void conjugate()` : Computes the complex conjugate of this number by negating its imaginary part.
    - `double argument()` : Returns the argument (angle) of the complex number in radians.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, the component is mutable. It inherits `clear()` , `newInstance()` , and `transferFrom()` which all mutate `this` . The kernel method `set` and secondary methods like `add `,`subtract` , `multiply` , and `conjugate` all modify the complex number’s internal state.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No, this component does not require any internal helper classes. The representation of a complex number is simple enough (two double values for real and imaginary parts) that it can be fully managed within the main component class itself.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes, it would be beneficial to include public static final constants for common complex numbers. Useful constants would include ZERO(0+0i), ONE (1+1i), and I (0+1i, the imaginary unit) to improve code readability and prevent the creation of unnecessary objects for these commonly used values.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. A secondary method like `add(ComplexNumber other)` can be implemented by layering on the kernel methods `getReal()`, `getImaginary()`, and `set()`:
      ```java
      public void add(ComplexNumber other) {
        double newReal = this.getReal() + other.getReal();
        double newImag = this.getImaginary() + other.getImaginary();
        this.set(newReal, newImag);
      }
      ```

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog


At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission


If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.



### Peer Review


Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.



[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
