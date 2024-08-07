# Portfolio Part 2: Component Proof-of-Concept

- **Name**: <!-- TODO: fill with first and last name (e.g., Brutus Buckeye) then delete this comment -->
- **Dot Number**: <!-- TODO: fill with OSU dot number (e.g., buckeye.17) then delete this comment -->
- **Due Date**: <!-- TODO: fill out with due date and time (e.g., 10/17 @ 3:10 PM EST) then delete this comment -->

## Assignment Overview

<!-- TODO: read the assignment overview then delete this comment -->

Previously, you brainstormed three ideas, and hopefully you got some feedback as
well. However, it's impossible to know how reasonable your design actually is
without trying to implement it. Because you're only just learning our full
discipline, it could be a bit frustrating to work through learning the
discipline while also trying to learn everything required to implement your
design. As a result, we're going to briefly take the discipline out of the
equation.

In this assignment, you're job is to pick one of your ideas and create a single
Java file that proves that your idea is reasonable. In the business world, this
is sometimes called a Minimum Viable Product or MVP. The goal of an MVP is to
get enough of the features of your original design implemented such that you can
get meaningful feedback.

Keep in mind that the goal is **not** to implement your entire design—just a
piece of it, so that you are confident that it can be adapted to the OSU
discipline. However, as before, you are welcome to be as detailed as you like.
Because this may ultimately be something you want to share with employers,
the more work you can put in now, the better.

## Assignment Checklist

<!-- TODO: browse the checklist then delete this comment -->

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

<!-- TODO: read the assignment learning objectives then delete this comment -->

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Predict which design would be appropriate to move forward with given time
   constraints, interests, and/or humility (among other real-world variables)
2. Select appropriate methods and fields to demonstrate the achievability of
   the proof-of-concept
3. Assemble a minimal working implementation of one of their designs

## Assignment Rubric: 10 Points

<!-- TODO: read the assignment rubric then delete this comment -->

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

1. (2 points) The choice of design to implement must be justified by considering
   a variety of real-world factors. It is okay to say that you selected a
   particular design because you do not know which design is best. We will
   provide a space for you to justify your selection below.
2. (4 points) The implementation must show off a range of methods on some
   representation to demonstrate feasibility of the overall design. Ideally,
   these methods should be significantly different. For example, don't implement
   only getters. Try to show the extent of the work that would be needed to
   implement the entire design.
3. (4 points) The implementation must include a main method that constructs the
   component and uses it in a variety of use cases. Part of a proof-of-concept
   is showing the client view. At this stage, we care less about the actual
   implementation and more about whether a client would actually want to use it.

## Pre-Assignment Tasks

Unlike previous assignments, the pre-assignment is somewhat in depth. Please
take your time to go through it. This will set you up for long term success.

### Discuss Choice of Design

> Because choosing a design to use moving forward may present a challenge, it
> may be a good idea to just pick one for now. There is nothing wrong with
> creating a couple interfaces that you will scrap later. Think of this as the
> process an artist might go through in refining their craft. For instance,
> you might have seen [some of these pottery fails before][pottery-fails].
> You will have to throw out some work from time to time.
>
> With all that said, if the advice of "just pick one" isn't enough, consider
> using the space below to pitch an argument of why you selected one design over
> the other. Alternatively, if you hate all of your old designs, use this space
> to create a new design. In you do end up picking one at random, you should
> disclose that here as well.

<!-- TODO: briefly argue your choice of design or design something
new; then delete this comment -->

### Setup Git and GitHub

<!-- TODO: follow the instructions below then delete this comment -->

Hopefully, at this point, you have some git experience. Therefore, here's what I
would recommend you do.

1. Create a [GitHub](https://github.com/) account, if you have not already.
2. Download [GitHub Desktop](https://desktop.github.com/download/), if you have
   not already.
3. Sign into GitHub Desktop using your GitHub account.
4. In GitHub Desktop, click `File` and `New Repository`.
5. Choose a name based on the component you decided above. Don't worry! This
   can be changed at any time. I recommend using lowercase letters and separating
   by dashes (e.g., `my-component`), but any format is fine.
6. Give a short description (i.e. one sentence) of your component.
7. Select a location on your computer where you want to keep your project.
   Do not make this the path to your existing portfolio project. We are just
   going to copy the files over.
8. Leave everything else blank and click "Create repository".

This will create a folder on your computer that is ready to be a git repo.
Next:

9. You should see multiple buttons that say "Publish repository". Click one of
   them.
10. A window will pop up asking you to confirm the repo name and description.
    In addition, there will be an option to "Keep this code private". **Uncheck
    this setting**, so I can access your code during submissions. Ignore the
    organization setting.
11. Click `Publish repository`.

Now, you need to move our existing work into the repo. To do this, you will
need to figure out where your portfolio project is current stored. Then:

12. Go inside the folder and copy everything. I would use `CTRL + A` (or the
    Mac equivalent) to select all the files. Then, I would use `CTRL + C` to
    copy them.
13. Next, go to where you stored the repo. If you don't know where this is,
    GitHub Desktop can tell you. Click the "Repository" tab and select
    "Show in Explorer" (or the Mac equivalent). Alternatively, you can use
    the shortcut `CTRL + SHIFT + F`.
14. Then, dump everything in this folder by pasting or using `CTRL + V` (or the
    Mac equivalent).
15. When you jump back into GitHub Desktop, you should see a lot of changes as
    follows:

![GitHub Desktop With Changes](github-desktop-with-changes.png)


## Assignment Tasks

As stated previously, your goal with this assignment is to produce a Java
file that proves the possibility of your design. There are many ways to do this,
but the general approach should be to create a Java file with the following
features:

- A handful of methods from the original design
- An example field(s) demonstrating a possible representation
- A main method showing the component in action

Again, our discipline dictates that all of these features be spread across
a hierarchy of interfaces and abstract classes. You should not attempt to do
that at this point.

When you're ready to start, create a Java file anywhere in `src` and begin
coding. See the submission directions below when you're ready to submit.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

<!-- TODO: update CHANGELOG then delete this comment -->

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a proof of concept for <!-- insert name of component 1 here --> component

### Updated

- Changed design to include ...

```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

### Submission

<!-- TODO: read the submission instructions then delete this comment -->

Assuming that your project is in a GitHub repo somewhere and your changes are on
a part-2 branch, then what we'll want you to do is create a pull request of all
your changes. Pull requests are pretty easy to make if you're using GitHub
Desktop. Just click the `branch` tab and select `Create pull request`. This
should pull up your browser with the pull request form ready to complete. Give
your pull request a good title like "Completed Part 2 of the Portfolio Project"
and briefly describe what you've done. Then, click "Create pull request".

If all goes well, you should have a pull request that you can submit to Carmen
via its URL. The URL should be in the form:
`https://github.com/username/repo-name/pull/#`

<!-- TODO: paste the URL to Carmen then delete this comment -->

### Peer Review

Following the completion of this assignment, you will be assigned three
students' assignments for review. Your job is to assess how comfortable you
are with your peer's proof-of-concept. In other words, do you think they've
demonstrated enough that you're confident they could complete their design
according to our discipline.

When reviewing your peers' assignments, please treat them with respect.
Note also that we can see your comments, which could help your case if you're
looking to become a grader. Ultimately, we recommend using the following
feedback rubric to ensure that your feedback is both helpful and respectful
(you may want to render the markdown as HTML or a PDF to read this rubric as a
table).

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

<!-- TODO: follow the link to share your feedback then delete this comment -->

[pottery-fails]: https://www.youtube.com/shorts/Kqb9l113F_0?feature=share
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
