# Portfolio Part 2: Component Interfaces

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) and delete this comment -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) and delete this comment -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) and delete this comment -->

## Assignment Overview

By now, you have had the opportunity to create three high-level
component designs. Hopefully, at this point, you've also received
feedback on your designs. 

Now, you will have the opportunity to pick one of your designs
and attempt to put together the client-side interfaces, specifically
the kernel and secondary interfaces. 

Remember, the interfaces are what the client will see, so you
should really be considering the types of functionality that
your user would want. If it helps, ask yourself the following:
what would I (as in you, the reader) want this component to be 
able to do?

Again, you will not be able to answer this question to its
fullest extent until you actually start writing some code. 
And you'll never really know if your component is useful
until you use it. That's why engineers often create 
proof-of-concept designs first. However, you will not be required
to create a proof-of-concept design (but maybe that should 
be part 2 of this project, feel free to voice your thoughts 
on that in the feedback below). 

## Assignment Rubric

For this assignment, you will be graded on your completion
of two key interfaces in your design: kernel and secondary.

Unlike part one, the main areas of focus for assessment
will be on the course discipline (see Carmen for more 
details). Broadly:

- The kernel interface must inherit from Standard, and
  the secondary interface must inherit from the kernel.
- All kernel and secondary method headers must be defined
  using OSU components where applicable or your own 
  defined innerclasses (e.g., Node in LinkedList).
- All kernel and secondary methods must have contracts
  in line with the course discipline. In other words,
  these contracts must include the following annotations:
  `@ensures`. In addition, the contracts must include the
  following annotations as needed: `@requires`, `@param`,
  `@return`, `@updates`, `@replaces`, `@clears`. There is
  no requirement that you use mathematical notation in
  your contracts, but they should be as clear as possible.
  Keep in mind that these are the docs your client would
  read when looking to use your component, so exercise
  empathy. 
- All interfaces must compile. 

Unlike the previous assignment, each interface is graded
primarily on completion of the above criteria. There
really is no "correctness" grade in this case. 

## Pre-Assignment Tasks

Because choosing a design to use moving forward may present
a challenge, it may be a good idea to just pick one for
now. There is nothing wrong with creating a couple interfaces
that you will scrap later. Think of this as the process an
artist might go through in refining their craft. For instance,
you might have seen [some of these pottery fails before][pottery-fails]. 
You will have to throw out some work from time to time. 

With all that said, if the advice of "just pick one" isn't enough,
consider using the space below to pitch an argument of why you
selected one design over the other. Alternatively, if you hate all
of your old designs, use this space to create a new design.

<!-- TODO: briefly argue your choice of design or design something 
new; then delete this comment -->

## Assignment Tasks

Your primary task for this assignment is to draft two interfaces
in line with the course discipline: a kernel interface and a
secondary interface. Because it is unlikely that you've done this
before, you may consider browsing some examples directly from
the API. For example, here is the [NaturalNumberKernel 
interface][natural-number-kernel] source code. Your kernel 
interface should look something like this. Meanwhile, here is 
the [secondary interface of NaturalNumber][natural-number]. 
Similarly, your secondary interface should look something like
this. 

Below you'll find two subsections with places to paste your
interfaces. Feel free to complete your interfaces in a new
project in Eclipse. That way, you know they compile before 
dropping them here. 

### Kernel Interface

```java
// Insert kernel interface here
```

### Secondary Interface

```java
// Insert secondary interface here
```

## Post-Assignment Tasks

The following sections detail everything that you should do once
you've completed the assignment. 

### Submission

If you have completed the assignment using this template, we recommend
that you convert it to a PDF before submission. If you're not sure
how, check out this [Markdown to PDF guide][markdown-to-pdf-guide].

### Peer Review

Following the completion of this assignment, you will be assigned
three students' component interfaces assignments for review.
Please do not spend a ton of time on your reviews, **perhaps 10-15
minutes each**. Your job during the peer review process is to help 
your peers edit their contracts. Specifically, you should be helping 
them with the readability of their contracts. If something isn't clear
to you, it's probably not clear to others, so help them communicate
their contracts better. When reviewing your peers' assignments, 
please treat them with respect. We recommend using the following
feedback rubric to ensure that your feedback is both helpful and
respectful (you may want to render the markdown as HTML or a PDF
to read this rubric as a table). 

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

Now that you've had a chance to complete the assignment, is there
anything you would like to say about the assignment? For example,
are there any resources that could help you complete this assignment?
Feel free to use the feedback rubric above when reviewing this 
assignment.

<!-- TODO: share your feedback here -->

[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/

[pottery-fails]: https://www.youtube.com/shorts/Kqb9l113F_0?feature=share
[natural-number-kernel]: https://web.cse.ohio-state.edu/software/common/doc/src-html/components/naturalnumber/NaturalNumberKernel.html
[natural-number]: https://web.cse.ohio-state.edu/software/common/doc/src-html/components/naturalnumber/NaturalNumber.html
