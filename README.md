# Portfolio Project

The purpose of this repo is to provide a framework for creating your own
component in the software sequence discipline. If you were unsure whether
or not to make your own, consider the following testimonial:

> I really enjoyed the portfolio project! It gave me a stronger understanding
> of the OSU software discipline while also giving me the flexibility to
> design something that reflected my interests. This made the experience
> rewarding and enjoyable as I created a product I was proud of!

## Recommended Steps to Get Started

When starting your portfolio project, the following steps should make your life
a bit easier.

### Step 1: Create a Repo From This Template

<!-- TODO: use GitHub to create a repo from this template -->

Assuming you're reading this README from GitHub, you can make use of this
repo by clicking the `Use this template` button in the top-right corner of
this page. If you can't find the button, [this link][use-this-template] 
should work as well. Personally, I would recommend using the 
`Create a new repository` option, which will allow you to name the 
repository after your component. Given that you will be submitting pull 
requests to me through Carmen, you'll want to make sure your repository 
is public. Then, you can click `Create repository`. After that, you can 
go through all the usual steps of cloning a repository on your system to 
get to work. I use GitHub Desktop to clone projects, and it has a nice 
feature of letting you open a repo directly in VSCode from the 
`Repository` menu.

### Step 2: Install Recommended Plugins

<!-- TODO: install recommended plugins and delete this comment -->

When you open VSCode with this project, you should get a notification in the
bottom right corner that there are some recommended extensions to install.
Click install all. If you ignored this message or it never came up, feel free
to press CTRL+SHIFT+P and type "Show Recommended Extensions". Install all of the
extensions listed.

### Step 3: Install the Latest JDK

<!-- TODO: install latest JDK and delete this comment -->

If you do not have an available JDK on your system, you may be prompted to
install one by VSCode. The default seems to be Red Hat's OpenJDK, which seems to
require you to register for an account or to install on the command line.
Regardless, there is no mac support. As a result, I would just recommend
installing the latest JDK [directly from Oracle's site][jdk-downloads].

### Step 4: Add Key Libraries to Project

<!-- TODO: add key libraries to project and delete this comment -->

As you are probably all aware at this point, you need the components jar to get
anything running. My advice is to [download it from here][components-jar]. Then,
drop it into the `lib` folder in the project. Git automatically ignores anything
you put here by default, so don't worry about committing it to version control.

Similarly, you will need the testing APIs (e.g., JUnit). Perhaps the easiest way
to include them in your project is to click the beaker symbol in the left
sidebar; it's right below the extensions button which looks like four squares.
If you do not see this button, try creating a Java file in `src`. From there, 
you can click "Enable Java Tests" and then click "JUnit" from the
dropdown. That's it! You should now see the two JUnit libraries in the lib
folder.

**Note**: if you're using VSCode for class projects, you might be wondering
why you never had to do this. In general, it's bad practice to commit binaries
to version control. However, we have no way of managing dependencies with the
custom `components.jar`, so I included them directly in the template. I did not
include them here, so you could see how it might be done from scratch. If at any
point you're struggling with Step 3, just copy the lib folder from the monorepo
template.

## Next Steps

<!-- TODO: navigate to part 1 of the portfolio project and delete this comment -->

Now that you have everything setup, you can begin crafting your component. There
will be deadlines for each step in Carmen, but you're free to complete each step
as early as you'd like. To start, you'll want to visit the [doc](doc/) directory
for each assignment file.

[components-jar]: https://cse22x1.engineering.osu.edu/common/components.jar
[jdk-downloads]: https://www.oracle.com/java/technologies/downloads/
[use-this-template]: https://github.com/new?template_name=portfolio-project&template_owner=jrg94
