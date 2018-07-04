# Java-Elevator
This is a java multi-thread application of elevators.

## Tips
all the source code files should be loaded with GBK encoding or some icons may appear in a wrong style.

## Explanation
There are 4 images and 5 classes.
### images
![Alt text](/src/img/closed.jpg)---------------![Alt text](/src/img/opening.jpg)--------------![Alt text](/src/img/opened.jpg)---------------![Alt text](/src/img/closing.jpg)
1. closed.jpg--------------2. opening.jpg---------------3. opened.jpg---------------4. closing.jpg
### classes
1. Const: it saves constants that will be used for many times,
   e.g. "static final int floornumber" means the number of floor in the building.
2. ButtonListener: it responds to the button click action. If a button is clicked, its background color turns red.
3. Outside: it defines the functions and UI of outside buttons on every floor that people outside need to push to call the elevator.
4. Elevator: it defines the functions and UI of inside buttons and it shows states of the elevator (maybe the most complex class).
5. View (main class): it initializes five elevators and outside view on the panel and run them in multithread.

## Snapshots
### 1. Main panel
![Alt text](/snapshots/Main.png)
### 2. Simple demonstration
![Alt text](/snapshots/Simple.png)
