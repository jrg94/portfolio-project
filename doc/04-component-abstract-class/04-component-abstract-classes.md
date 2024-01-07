# Portfolio Part 4: Abstract Class

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) and delete this comment -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) and delete this comment -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) and delete this comment -->

## Assignment Overview

Now that you've had a chance to refine your designs a bit, it's time to start
writing some code. In this assignment, you will be making your first abstract
class. The abstract class will take on the name `ComponentSecondary`, where
`Component` is the name of your component. For example, if you're making a
Point3D component, the abstract class would be called `Point3DSecondary` as
follows:

```java
public abstract class Point3DSecondary implements Point3D {
   ...
}
```

Inside the abstract class, you will implement every secondary method you
specified in the enhanced interface. Because the secondary abstract class is
layered over the kernel interface, you cannot implement the methods of your
enhanced interface using the underlying representation. As a result, these
methods must be implemented using the kernel methods only.

Surprisingly, you have done this several times before without probably realizing
it. For example, when you first learned recursion in software 1, [you were
tasked with implementing the secondary methods of NaturalNumber][lab-14]. At the
time, they were static methods, but you were tasked with only implementing the
secondary methods using the kernel methods.

You did this a few other times as well. For example, we asked you to
[implement the secondary methods for set at one point][lab-21]. We did this by
having you extend `Set1L`, so you could override the implementation of
`remove()` and `add()`. At the time, we didn't force you to only use kernel
methods, but the premise remains the same. Meanwhile, in a later lab, you were
tasked with implementing the secondary method `sort()` of `Queue`.

Once you have implemented all of the secondary methods, you must also implement
the key `Object` methods. It's up to you to decide which ones you want to
implement, but `toString()` and `equals()` are a great start. You may also
implement `hashCode()` if you so choose. Note that these methods do not have
access to the representation, so you must also implement them using the kernel
methods only.

## Assignment Rubric

Like the other assignments up to this point, you will be graded
on meeting certain criteria. More broadly, you will be graded on
your adherence to the software sequence design principles:

1. You must implement all of the secondary methods that you defined
   in your enhanced interface using Kernel methods only.
2. You must override at least `toString()` and `equals()` of
   `Object`, and other methods if you so choose.
3. Your solution must compile.
4. You must justify any changes you make to your original design
   (there will be space for this in the pre-assignment task area).

Note that you will not be able to test any of your methods, so don't
worry about them being 100% accurate. In writing, we call this a
"shitty first draft" or SFD for short. As a result, hitting 3/4
of these criteria is enough to earn full credit on the assignment.

## Pre-Assignment Tasks

Before you write any code, I would recommend that you sit down
and try to map out how you would implement your secondary methods
given the constraint of only using kernel methods. Is it possible?

Most likely, you are going to hit a bumb in the road in your design
where the kernel methods aren't quite enough to get you an implementation
of a secondary method. In that case, it is okay to update your design.
All that I ask is that you document your changes and why in this section.
Here's what that might look like:

> Added a kernel method for `size()` because I am unable to check the
> precondition of `remove()` without it.
>
> Changed `getSignals()` method to `removeSignal()` method to eliminate
> aliasing in my design.

Feel free to use the template above when writing out your changes.

<!-- TODO: include your changes to your design here -->

## Assignment Tasks

As promised, here is where you will drop in your abstract class design:

```java
// Insert Java abstract class here
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
[lab-14]: https://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/natural-number-static/natural-number-static.html
[lab-21]: https://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/set-instance-methods/set-instance-methods.html
